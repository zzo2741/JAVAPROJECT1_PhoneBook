package project1.ver09;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectImpl implements IConnect
{
	public PreparedStatement psmt;
	public Statement stmt;
	public CallableStatement csmt;
	public Connection con;
	public ResultSet rs;

	public ConnectImpl(String user, String pass)
	{
		try
		{
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		} catch (ClassNotFoundException e)
		{
			System.out.println("드라이버를 찾을 수 없습니다.");
		}
	}

	@Override
	public void connect(String user, String pass)
	{
		try
		{
			con = DriverManager.getConnection(ORALE_URL, user, pass);
		} catch (SQLException e)
		{
			System.out.println("데이터베이스를 연결할 수 없습니다.");
		}
	}

	@Override
	public void close()
	{
		try
		{
			if (con != null)
			{
				con.close();
			}

			if (psmt != null)
			{
				psmt.close();
			}
			if (stmt != null)
			{
				stmt.close();
			}
			if (csmt != null)
			{
				csmt.close();
			}
			if (rs != null)
			{
				rs.close();
			}
		} catch (Exception e)
		{
			System.out.println("자원반납을 할 수 없습니다.");
		}
	}

}
