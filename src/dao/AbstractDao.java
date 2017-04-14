package dao;

import java.sql.*;

public abstract class AbstractDao {

	private String driverClass="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/muchat";
	private String user="muchat";
	private String pwd="1234";
	
	public Connection getConnection() throws Exception
	{
		Connection con=null;
		Class.forName(driverClass);
		con=DriverManager.getConnection(url,user,pwd);
		return con;
	}
}
