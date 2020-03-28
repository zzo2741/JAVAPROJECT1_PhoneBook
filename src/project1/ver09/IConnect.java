package project1.ver09;

public interface IConnect
{
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORALE_URL = "jdbc:oracle:thin://@localhost:1521:orcl";
	
	void connect(String user, String pass);
		
	void close();

}
