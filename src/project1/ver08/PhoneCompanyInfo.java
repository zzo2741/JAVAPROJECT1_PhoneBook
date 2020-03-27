package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo
{
	private String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName)
	{
		super(name, phoneNumber);
		this.companyName = companyName;
	}

	@Override
	public void showPhoneInfo()
	{
		System.out.println("===비즈니스===");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("회사명 : " + companyName);
		System.out.println();
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

}
