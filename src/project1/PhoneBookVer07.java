package project1;

import project1.ver07.PhoneBookManager;

import java.util.InputMismatchException;
import java.util.Scanner;
import project1.ver07.MenuItem;

public class PhoneBookVer07 implements MenuItem
{
	public static int SAVE_NUM = 100;

	public static void main(String[] args)
	{
		PhoneBookManager pbm = new PhoneBookManager();

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
				pbm.dataInput();
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
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			}
		}

	}

}
