
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.*;

public class DatabaseConnector {
	
	private String username;
	private String password;
	private String uri;
	private Properties sql_properties;
	private Connection sql_conn;
	
	public DatabaseConnector(String connection_uri,String users,String passwrd)
	{
		uri = connection_uri;
		username= users;
		password = passwrd;
	}
	
	public DatabaseConnector(String connection_urt,Properties prop)
	{
		uri=connection_urt;
		sql_properties = prop;
	}
	public Boolean IsConnectionActive()
	{
		try 
		{
			return !sql_conn.isClosed();
		}
		catch(Exception ex) 
		{
			return false;
		}
	}
	
	public void StartConnection() {
		try {
			sql_conn = DriverManager.getConnection(uri, username, password);
			System.out.println("Connected to " + uri + "successfully.");
		}
		catch(SQLException ex)
		{
		System.out.println(ex);
		}
	}
	
	public Connection getSQLCONN()
	{
		return sql_conn;
	}
	
	
}