package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneBookManager;
import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;

public class PhoneBookVer06 implements MenuItem
{
	public static int SAVE_NUM = 100;

	public static void main(String[] args)
	{
		PhoneBookManager pbm = new PhoneBookManager(SAVE_NUM);

		while (true)
		{

			pbm.prtintMenu();
			int choiceNum = 0;
			Scanner sc = new Scanner(System.in);
			try
			{
				choiceNum = sc.nextInt();

			} catch (InputMismatchException e)
			{
				System.out.println("숫자를 입력해주세요.");
				continue;
			}

			switch (choiceNum)
			{
			case DATA_INPUT:

				if (SAVE_NUM > pbm.getNumOfPerson())
				{

					pbm.dataInput();
				} else
				{
					System.out.println();
					System.out.println("**저장 인원수를 초과하였습니다.**");
					System.out.println("삭제메뉴에서 데이터를 삭제해주세요.");
					System.out.println();
				}
				break;

			case DATA_SEARCH:
				pbm.dataSearch();
				break;

			case DATA_DELETE:
				pbm.dataDelete();
				break;

			case DATA_ALL_SHOW:
				pbm.dataAllShow();
				break;

			case PROGRAM_EXIT:
				System.out.println();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				if (choiceNum > 5 || choiceNum < 1)
				{
					MenuSelectException ex = new MenuSelectException();
					try
					{
						throw ex;
					} catch (MenuSelectException e)
					{
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}
