package project1.ver07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem
{
	HashSet<PhoneInfo> piSet;

	public PhoneBookManager()
	{
		piSet = new HashSet<>();
	}

	public void prtintMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("번호 입력 : ");
	}

	public HashMap<String, String> commonVarInput()
	{
		HashMap<String, String> commnVar = new HashMap<>();
		String inputName, inputPhoneNumber;
		while (true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("이름 : ");
			inputName = sc.nextLine();
			if (inputName.equals(""))
			{
				System.out.println("이름을 입력해주세요.");
				continue;
			}
			commnVar.put("name", inputName);
			break;
		}

		while (true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("전화번호 : ");
			inputPhoneNumber = sc.nextLine();
			if (inputPhoneNumber.equals(""))
			{
				System.out.println("전화번호을 입력해주세요.");
				continue;
			}
			commnVar.put("phoneNumber", inputPhoneNumber);
			break;
		}
		return commnVar;
	}

	public void dataInput()
	{
		HashMap<String, String> commonVar;
		Scanner sc = new Scanner(System.in);
		String inputMajor, inputCompanyName, answer = "";
		int inputGrade;

		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반\t2. 동창\t3. 회사");
		System.out.print("선택 : ");

		int choicePerson = 0;

		try
		{
			choicePerson = sc.nextInt();

		} catch (InputMismatchException e)
		{
			System.out.println("숫자를 입력해주세요.");
		}

		switch (choicePerson)
		{
		case GENERAL:
			commonVar = commonVarInput();
			if (piSet.add(new PhoneInfo(commonVar.get("name"), commonVar.get("phoneNumber"))) == false)
			{
				System.out.print("덮어쓰시겠습니까?(y/n) : ");
				answer = sc.next();
				if (answer.equals("y"))
				{
					piSet.remove(new PhoneInfo(commonVar.get("name"), commonVar.get("phoneNumber")));
					piSet.add(new PhoneInfo(commonVar.get("name"), commonVar.get("phoneNumber")));
				} else if (answer.equals("n"))
				{
					System.out.println("중복입니다.");
				}

			}
			break;
		// piSet.add(new PhoneInfo(commonVar.get("name"),
		// commonVar.get("phoneNumber")));

		case FRIEND:
			commonVar = commonVarInput();
			System.out.print("전공 : ");
			inputMajor = sc.next();
			System.out.print("학년 : ");
			inputGrade = sc.nextInt();
			if (piSet.add(new PhoneSchoolInfo(commonVar.get("name"), commonVar.get("phoneNumber"), inputMajor, inputGrade)) == false)
			{
				System.out.print("덮어쓰시겠습니까?(y/n) : ");
				answer = sc.next();
				if (answer.equals("y"))
				{
					piSet.remove(new PhoneSchoolInfo(commonVar.get("name"), commonVar.get("phoneNumber"), inputMajor, inputGrade));
					piSet.add(new PhoneSchoolInfo(commonVar.get("name"), commonVar.get("phoneNumber"), inputMajor, inputGrade));
				} else if (answer.equals("n"))
				{
					System.out.println("중복입니다.");
				}

			}
			break;

		case COMPANY:
			commonVar = commonVarInput();
			System.out.print("회사명 : ");
			inputCompanyName = sc.next();
			if (piSet.add(new PhoneCompanyInfo(commonVar.get("name"), commonVar.get("phoneNumber"), inputCompanyName)) == false)
			{
				System.out.print("덮어쓰시겠습니까?(y/n) : ");
				answer = sc.next();
				if (answer.equals("y"))
				{
					piSet.remove(new PhoneCompanyInfo(commonVar.get("name"), commonVar.get("phoneNumber"), inputCompanyName));
					piSet.add(new PhoneCompanyInfo(commonVar.get("name"), commonVar.get("phoneNumber"), inputCompanyName));
				} else if (answer.equals("n"))
				{
					System.out.println("중복입니다.");
				}

			}
			break;
		}

	}

	public void dataAllShow()
	{
		Iterator<PhoneInfo> it = piSet.iterator();
		while (it.hasNext())
		{
			PhoneInfo p = it.next();
			p.showPhoneInfo();
		}
	}

	public void dataSearch()
	{
		System.out.print("검색할 이름을 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String searchName = scanner.nextLine();
		int searchFlag = 0;

		for (Iterator<PhoneInfo> iterator = piSet.iterator(); iterator.hasNext();)
		{
			PhoneInfo pi = (PhoneInfo) iterator.next();
			if (searchName.equals(pi.name))
			{
				pi.showPhoneInfo();
				searchFlag = 1;
			}
		}
		if (searchFlag != 1)
		{
			System.out.println("찾으시는 정보가 없습니다.\n");
		}
	}

	public void dataDelete()
	{
		System.out.print("삭제할 이름을 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String searchName = scanner.nextLine();

		for (Iterator<PhoneInfo> iterator = piSet.iterator(); iterator.hasNext();)
		{
			PhoneInfo pi = (PhoneInfo) iterator.next();
			if (searchName.equals(pi.name))
			{
				piSet.remove(pi);
			}
		}

	}

}
