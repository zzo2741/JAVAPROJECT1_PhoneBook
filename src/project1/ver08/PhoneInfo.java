package project1.ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable
{
	// 멤버 변수
	protected String name;
	protected String phoneNumber;

	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// 정보출력용 메소드
	public void showPhoneInfo()
	{
		System.out.println("===일반===");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		PhoneInfo pi = (PhoneInfo) obj;

		if (pi.name.equals(this.name))
		{
			return true;
		} else
		{
			return false;
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

}
