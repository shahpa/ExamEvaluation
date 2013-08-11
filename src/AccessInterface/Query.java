package AccessInterface;

import AccessInterface.AccessConnection;
import AccessInterface.PrepStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import AccessInterface.Parm;
import AccessInterface.ParmSetter;

public class Query
{
	private AccessConnection conn = null;
	private PrepStatement statement = null;
	
	@SuppressWarnings("unused")
	private Query()
	{ }
	
	public Query(AccessConnection c)
	{
		conn = c;
	}
	
	public void setQueryString(String q)
	{
		if(statement != null)
			statement.close();
		statement = new PrepStatement(conn.getConnection(), q);
	}
	
	@SuppressWarnings("unchecked")
	public void setQueryParms(ArrayList<Parm> parms)
	{
		for(int i = 0; i < parms.size(); i++)
		{
			ParmSetter.processParameter(
					statement.getStatement(), i+1, parms.get(i));
		}
	}
	
	public ResultSet execute()
	{
		ResultSet rs = null;
		
		try
		{
			rs = statement.getStatement().executeQuery();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return rs;
	}
}
