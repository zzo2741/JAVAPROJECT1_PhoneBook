package project1;

import java.util.Scanner;
import project1.ver02.PhoneInfo;

public class PhoneBookVer02
{
	static public String selectMenu()
	{
		String select;
		Scanner scanner = new Scanner(System.in);
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택 : ");
		select = scanner.nextLine();
		return select;
	}

	static public void userInfoInput()
	{
		Scanner scanner = new Scanner(System.in);
		PhoneInfo person = new PhoneInfo();

		String name = "";
		String phoneNumber = "";
		String birthday = "";

		while (true)
		{
			System.out.print("이름 : ");
			name = scanner.nextLine();
			if (name.equals(""))
			{
				System.out.println("이름을 입력해주세요.");
				continue;
			} else
			{
				person.setName(name);
				break;
			}
		}

		while (true)
		{
			System.out.print("전화번호 : ");
			phoneNumber = scanner.nextLine();
			if (phoneNumber.equals(""))
			{
				System.out.println("전화번호을 입력해주세요.");
				continue;
			} else
			{
				person.setPhoneNumber(phoneNumber);
				break;
			}
		}

		System.out.print("생년월일 : ");
		birthday = scanner.nextLine();
		person.setBirthday(birthday);
		person.showPhoneInfo();
	}

	public static void main(String[] args)
	{
		while (true)
		{
			String selectMenu = selectMenu();

			if (selectMenu.equals("1"))
			{
				userInfoInput();
			} else if (selectMenu.equals("2"))
			{
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else
			{
				System.out.println("\n**다시입력해주세요.**");
			}

		}

	}

}
