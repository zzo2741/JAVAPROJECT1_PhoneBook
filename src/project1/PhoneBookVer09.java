package project1;

import java.util.Scanner;
import project1.ver09.PhoneBookManager;

public class PhoneBookVer09
{

	public static void main(String[] args)
	{
		System.out.println("JDBC시작");
		PhoneBookManager pbm = new PhoneBookManager();
		pbm.createTable();
		pbm.createSeq();
		while (true)
		{
			pbm.prtintMenu();

			Scanner sc = new Scanner(System.in);
			int choiceNum = sc.nextInt();

			switch (choiceNum)
			{
			case 1:

				pbm.dataInput();
				break;

			case 2:
				pbm.dataSearch();
				break;

			case 3:
				pbm.dataDelete();
				break;

			case 4:
				pbm.dataAllShow();
				break;

			case 5:
				pbm.close();
				pbm.programExit();

			}
		}

	}

}
