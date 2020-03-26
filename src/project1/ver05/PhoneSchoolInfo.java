package project1.ver05;

public class PhoneSchoolInfo extends PhoneInfo
{
	private String major;
	private int grade;

	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade)
	{
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}

	@Override
	public void showPhoneInfo()
	{
		System.out.println("===동창===");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
		System.out.println();


	}

	public String getMajor()
	{
		return major;
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public int getGrade()
	{
		return grade;
	}

	public void setGrade(int grade)
	{
		this.grade = grade;
	}

}
