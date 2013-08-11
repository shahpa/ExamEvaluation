/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessInterface;

/**
 *
 * @author Parth
 */
public class Driver {
    private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	
	Class driverObject = null;
	
	private Driver()
	{ }
	
	public Driver(String className)
	{
		if (className != null)
			driver = className;
		try
		{
			driverObject = Class.forName(driver);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
	
	public Class getDriver()
	{
		return driverObject;
	}
    
}
