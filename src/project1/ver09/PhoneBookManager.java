package project1.ver09;

import java.sql.CallableStatement;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneBookManager extends ConnectImpl
{
	public PreparedStatement psmt;
	public Statement stmt;
	public CallableStatement csmt;

	public PhoneBookManager()
	{
		super("kosmo", "1234");
	}

	public void prtintMenu()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("번호 입력 : ");
	}

	public void dataAllShow()
	{
		try
		{
			stmt = con.createStatement();

			rs = stmt.executeQuery(String.format("SELECT name, phonenumber, birthday FROM phonebook_tb"));
			System.out.println("************전체 출력 결과************");

			while (rs.next())
			{
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber");
				java.sql.Date birthday = rs.getDate("birthday");

				System.out.printf("%-10s %-10s %-10s\n", name, phonenumber, birthday);

			}
			System.out.println();
		} catch (Exception e)
		{
			System.out.println("출력 오류");
		}
	}

	public void dataInput()
	{
		try
		{
			String insertQuery = "INSERT INTO phonebook_tb VALUES (?, ?, ?)";

			psmt = con.prepareStatement(insertQuery);
			Scanner sc = new Scanner(System.in);
			String inputName, inputPhoneNumber, inputBirthday;

			while (true)
			{
				System.out.print("이름 : ");
				inputName = sc.nextLine();
				if (inputName.equals(""))
				{
					System.out.println("이름을 입력해주세요.");
					continue;
				}
				break;
			}

			while (true)
			{
				System.out.print("전화번호 : ");
				inputPhoneNumber = sc.nextLine();
				if (inputPhoneNumber.equals(""))
				{
					System.out.println("전화번호를 입력해주세요.");
					continue;
				}
				break;
			}

			System.out.print("생년월일(yymmdd) : ");
			inputBirthday = sc.nextLine();

			DateFormat formatter = new SimpleDateFormat("yymmdd");
			Date date = formatter.parse(inputBirthday);

			java.sql.Date sDate = new java.sql.Date(date.getTime());

			psmt.setString(1, inputName);
			psmt.setString(2, inputPhoneNumber);
			psmt.setDate(3, sDate);
			psmt.executeUpdate();
			System.out.println("저장하였습니다.");


		} catch (Exception e)
		{
			System.out.println("저장 실패");

		}

	}

	public void dataSearch()
	{
		try
		{
			System.out.print("검색할 이름을 입력하세요 : ");

			Scanner sc = new Scanner(System.in);
			String searchName = sc.nextLine();

			stmt = con.createStatement();

			rs = stmt.executeQuery(String.format("SELECT name, phonenumber, birthday FROM phonebook_tb WHERE name = '%s'", searchName));
			while (rs.next())
			{
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber");
				java.sql.Date birthday = rs.getDate("birthday");

				System.out.printf("%-10s %-10s %-10s\n", name, phonenumber, birthday);

			}
			System.out.println("검색을 완료하였습니다.");
		} catch (Exception e)
		{
			System.out.println("검색 오류");
			e.printStackTrace();
		}
	}

	public void dataDelete()
	{
		try
		{
			System.out.print("삭제할 이름을 입력하세요 : ");

			Scanner sc = new Scanner(System.in);
			String deleteName = sc.nextLine();

			stmt = con.createStatement();
			stmt.executeUpdate(String.format(" delete from phonebook_tb where name = '%s'", deleteName));
			System.out.println("삭제하였습니다.");
		} catch (Exception e)
		{
			System.out.println("삭제 오류");
		}
	}

	public void createTable()
	{
		try
		{
			stmt = con.createStatement();
			String creatTableSql = "create table phonebook_tb (" + "name VARCHAR2(50), " + "phonenumber VARCHAR2(50) not null, " + "birthday DATE, "
					+ "PRIMARY KEY (name))";
			// System.out.println(sql);

			stmt.execute(creatTableSql);
			System.out.println("테이블을 생성하였습니다.");
		} catch (Exception e)
		{
			System.out.println("기존 테이블 이용");
		}
	}

	public void createSeq()
	{
		try
		{
			stmt = con.createStatement();
			String createSeqSql = "create sequence seq_phonebook nocycle nocache";
			stmt.execute(createSeqSql);
			System.out.println("시퀀스를 생성하였습니다.");
		} catch (Exception e)
		{
			System.out.println("기존 시퀀스 이용");
		}
	}

	public void programExit()
	{
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
