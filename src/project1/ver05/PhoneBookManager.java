package project1.ver05;

import java.util.Scanner;

public class PhoneBookManager
{
	private int numOfPerson = 0;
	private PhoneInfo[] pi;

	public int getNumOfPerson()
	{
		return numOfPerson;
	}

	public PhoneBookManager(int num)
	{
		pi = new PhoneInfo[num];
		numOfPerson = 0;
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

	public void dataInput()
	{
		String inputName, inputPhoneNumber, inputMajor, inputCompanyName;
		int inputGrade;
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반\t2. 동창\t3. 회사");
		System.out.print("선택 : ");
		String choicePerson = sc.nextLine();

		if (choicePerson.equals("1"))
		{
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
			pi[numOfPerson++] = new PhoneInfo(inputName, inputPhoneNumber);

		} else if (choicePerson.equals("2"))
		{
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
			System.out.print("전공 : ");
			inputMajor = sc.nextLine();
			System.out.print("학년 : ");
			inputGrade = sc.nextInt();
			PhoneSchoolInfo psi = new PhoneSchoolInfo(inputName, inputPhoneNumber, inputMajor, inputGrade);
			pi[numOfPerson++] = psi;
		} else if (choicePerson.equals("3"))
		{
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
			System.out.print("회사명 : ");
			inputCompanyName = sc.nextLine();
			PhoneCompanyInfo pci = new PhoneCompanyInfo(inputName, inputPhoneNumber, inputCompanyName);
			pi[numOfPerson++] = pci;
		} else
		{
			System.out.println("잘못된 번호입니다.");
		}
	}

	public void dataSearch()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchName = sc.nextLine();

		for (int i = 0; i < numOfPerson; i++)
		{
			// System.out.println("검색중인 이름 : " + pi[i].getName());

			if (searchName.compareTo(pi[i].getName()) == 0)
			{
				pi[i].showPhoneInfo();
				System.out.println("===찾았습니다===");
				System.out.println();
				return;
			}

		}
		System.out.println("\n***저장되지 않은 이름입니다.***\n");

	}

	public void dataDelete()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = sc.nextLine();

		int deleteIndex = -1;

		for (int i = 0; i < numOfPerson; i++)
		{
			if (deleteName.compareTo(pi[i].getName()) == 0)
			{
				pi[i] = null;
				deleteIndex = i;
				numOfPerson--;
			}
		}
		if (deleteIndex == -1)
		{
			System.out.println("===삭제된 데이터가 없습니다===");
		} else
		{

			for (int i = deleteIndex; i < numOfPerson; i++)
			{
				pi[i] = pi[i + 1];
			}
			System.out.println("===데이터를 삭제하였습니다.===");
		}
	}

	public void dataAllShow()
	{
		System.out.println("입력된 정보 출력..");
		int savePersonNum = 0;
		for (int i = 0; i < numOfPerson; i++)
		{
			pi[i].showPhoneInfo();
			savePersonNum++;
		}
		System.out.println("=====전체정보 출력완료=====");
		System.out.println("주소록에 저장된 사람 수 : " + savePersonNum + "\n");
	}

}
