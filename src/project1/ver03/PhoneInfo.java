package project1.ver03;

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

	// 정보출력용 메소드
	public void showPhoneInfo()
	{
		System.out.println();
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);

		if (birthday.equals(""))
		{
			System.out.println("생일 : 입력되지 않음");
		} else
		{
			System.out.println("생일 : " + birthday);

		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

}
