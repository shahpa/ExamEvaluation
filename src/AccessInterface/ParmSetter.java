package AccessInterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class ParmSetter
{
	@SuppressWarnings("unchecked")
	public static void processParameter(PreparedStatement s,
			int parmIndex, Parm p)
	{
		try
		{
			switch(p.getType())
			{
				case INT:
					s.setInt(parmIndex, (Integer)p.getParm());
					break;
				case STRING:
					s.setString(parmIndex, (String)p.getParm());
					break;
				case DATE:
					s.setDate(parmIndex, (Date)p.getParm());
					break;
				default:
					System.out.println("No Parameter Match");
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
}
