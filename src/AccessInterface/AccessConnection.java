/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessInterface;

import java.sql.*;
/**
 *
 * @author Parth
 */
public class AccessConnection {
    private Connection conn = null;
	
	private AccessConnection()
	{ }
	
	public AccessConnection(String dbURL, String dbUser, String dbPass)
	{
		try
		{
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		}
		catch (SQLException e)
		{
			while (e != null)
			{
				System.out.println("SQLException/Error while making Connection: ");
				System.out.println("error message = " + e.getMessage());
				System.out.println("SQL State = " + e.getSQLState());
				System.out.println("Vendor Error Code = " + e.getErrorCode());
				e = e.getNextException();
			}
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}

	public void close()
	{
		try
		{
			if (conn != null)
				conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("Error Closing Connection");
		}
	}
	
        @Override
	protected void finalize() throws Throwable
	{
		try
		{
			close();
		}
		finally
		{
			super.finalize();
		}
	}
}
