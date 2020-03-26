package project1.ver01;

public class PhoneInfo
{

	// 멤버 변수
	private String name;
	private String phoneNumber;
	private String birthday;

	public PhoneInfo(String name, String phoneNumber, String birthday)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	public PhoneInfo(String name, String phoneNumber)
	{

		this.name = name;
		this.phoneNumber = phoneNumber;
		birthday = null; // 생년월일은 필수사항 아니므로 없는 경우 null로 초기화
	}

	// 정보출력용 메소드
	public void showPhoneInfo()
	{
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		if (birthday == null)
		{
			System.out.println("생일 : 입력되지 않음");
		} else
		{
			System.out.println("생일 : " + birthday);

		}
		System.out.println();
	}
	
}
