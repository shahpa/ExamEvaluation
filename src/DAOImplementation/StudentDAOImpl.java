/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplementation;

import java.util.ArrayList;
import java.util.List;

import DAOInterface.StudentDao;
import DomainObjects.StudentData;
import AccessInterface.*;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Parth
 */
public class StudentDAOImpl implements StudentDao
{

    private AccessConnection conn = null;
	
	private Query getEmpWithFN = null;
	private Query getEmpWithLN = null;
	private Query getEmpWithName = null;
	private Query getEmpWithSsn = null;
	private Query getEmps = null;
	
	private String baseQry = 
		"select student_id, student_last_name, student_first_name, " +
		"student_bdate from StudentData ";
	
	private String gewfn = baseQry +
	"where student_first_name = ?;";
	private String gewln = baseQry +
	"where student_last_name = ?;";
	private String gewn = baseQry + 
	"where student_first_name = ? and student_last_name = ?;";
	private String gews = baseQry +
	"where student_id = ?;";
	private String ge = baseQry;
	
	public StudentDAOImpl()
	{
		conn = new AccessConnection("jdbc:odbc:Database1", "", "");
		
		getEmpWithFN = new Query(conn);
		getEmpWithLN = new Query(conn);
		getEmpWithName = new Query(conn);
		getEmpWithSsn = new Query(conn);
		getEmps = new Query(conn);
		
		getEmpWithFN.setQueryString(gewfn);
		getEmpWithLN.setQueryString(gewln);
		getEmpWithName.setQueryString(gewn);
		getEmpWithSsn.setQueryString(gews);
		getEmps.setQueryString(ge);
	}
	
	private StudentData mapEmployee(ResultSet rs)
	{
		StudentData e = new StudentData();
		try
		{
			e.setS_id(rs.getString("student_id"));
			e.setFirstName(rs.getString("student_first_name"));
			e.setLastName(rs.getString("student_last_name"));
			
			e.setBirthDate(rs.getDate("student_bdate"));
			return e;
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return null;
	}
	
    @Override
    public List<StudentData> getStudent() {
        
        //To change body of generated methods, choose Tools | Templates.
        
        	ResultSet rs = getEmps.execute();
		ArrayList<StudentData> result = new ArrayList<StudentData>();
		
		try
		{
			while(rs.next())
			{
				StudentData e = mapEmployee(rs);
				result.add(e);
			}
			return result;
		}
		catch(SQLException e)
		{
                    System.out.println(e);
		}
		return null;
    }

    @Override
    public List<StudentData> getStudentWithLastName(String ln) {
        //To change body of generated methods, choose Tools | Templates.
        
        Parm<String> p = new Parm<String>();
		p.setType(TypeID.STRING);
		p.setParm(ln);
		ArrayList<Parm> parms = new ArrayList<Parm>();
		parms.add(p);
		getEmpWithLN.setQueryParms(parms);
		ResultSet rs = getEmpWithLN.execute();
		ArrayList<StudentData> result = new ArrayList<StudentData>();
		
		try
		{
			while(rs.next())
			{
				StudentData e = mapEmployee(rs);
				result.add(e);
			}
			return result;
		}
		catch(SQLException e)
		{
                    System.out.println(e);
		}
		return null;
    }

    @Override
    public List<StudentData> gettudentWithFirstName(String fn) {
         //To change body of generated methods, choose Tools | Templates.
        
        Parm<String> p = new Parm<String>();
		p.setType(TypeID.STRING);
		p.setParm(fn);
		ArrayList<Parm> parms = new ArrayList<Parm>();
		parms.add(p);
		getEmpWithFN.setQueryParms(parms);
		ResultSet rs = getEmpWithFN.execute();
		ArrayList<StudentData> result = new ArrayList<StudentData>();
		
		try
		{
			while(rs.next())
			{
				StudentData e = mapEmployee(rs);
				result.add(e);
			}
			return result;
		}
		catch(SQLException e)
		{

			System.out.println(e);
		}
		return null;
    }

    @Override
    public StudentData getStudentWithStudentID(String s_id) {
        //To change body of generated methods, choose Tools | Templates.
        		Parm<String> p = new Parm<String>();
		p.setType(TypeID.STRING);
		p.setParm(s_id);
		ArrayList<Parm> parms = new ArrayList<Parm>();
		parms.add(p);
		getEmpWithSsn.setQueryParms(parms);
		ResultSet rs = getEmpWithSsn.execute();
		
		try
		{
			StudentData e = new StudentData();
			if(rs.next())
			{
				e = mapEmployee(rs);
			}
			return e;
		}
		catch(SQLException e)
		{
                    System.out.println(e);
		}
		return null;
    }

    @Override
    public List<StudentData> getStudentWithName(String fn, String ln) {
        //To change body of generated methods, choose Tools | Templates.
        		Parm<String> pf = new Parm<String>();
		pf.setType(TypeID.STRING);
		pf.setParm(fn);
		Parm<String> pl = new Parm<String>();
		pl.setType(TypeID.STRING);
		pl.setParm(ln);
		ArrayList<Parm> parms = new ArrayList<Parm>();
		parms.add(pf);
		parms.add(pl);
		getEmpWithName.setQueryParms(parms);
		ResultSet rs = getEmpWithName.execute();
		ArrayList<StudentData> result = new ArrayList<StudentData>();
		
		try
		{
			while(rs.next())
			{
				StudentData e = mapEmployee(rs);
				result.add(e);
			}
			return result;
		}
		catch(SQLException e)
		{
                    System.out.println(e);
		}
		return null;
    }
    
}
