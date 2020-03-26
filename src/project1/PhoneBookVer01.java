package project1;
import project1.ver01.PhoneInfo;

public class PhoneBookVer01
{

	public static void main(String[] args)
	{
		PhoneInfo p1 = new PhoneInfo("이준승", "010-3524-3467", "951207");
		PhoneInfo p2 = new PhoneInfo("이정연", "010-7479-6747");
		p1.showPhoneInfo();
		p2.showPhoneInfo();
	}

}

