package AccessInterface;

import java.sql.*;


public class PrepStatement
{
	private PreparedStatement pStat = null;
	
	
	private PrepStatement()
	{ }
	
	public PrepStatement(Connection conn, String stat)
	{
		try
		{
			pStat = conn.prepareStatement(stat);
		}
		catch (SQLException e)
		{
			while (e != null)
			{
				System.out.println("SQLException/Error while Preparing Statement: " + stat);
				System.out.println("error message = " + e.getMessage());
				System.out.println("SQL State = " + e.getSQLState());
				System.out.println("Vendor Error Code = " + e.getErrorCode());
				e = e.getNextException();
			}
		}
	}
	
	public PreparedStatement getStatement()
	{
		return pStat;
	}
	
	public void close()
	{
		try
		{
			if (pStat != null)
				pStat.close();
		}
		catch (SQLException e)
		{
			System.out.println("Error Closing Prepared Statement");
		}
	}
	
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
