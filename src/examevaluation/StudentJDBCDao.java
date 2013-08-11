/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examevaluation;

import AccessInterface.Driver;
import DAOInterface.StudentDao;
import DAOImplementation.StudentDAOImpl;
import java.util.List;


import DomainObjects.StudentData;
import DomainObjectPrinter.StudentPrinter;
import AccessInterface.Driver;

/**
 *
 * @author Parth
 */
public class StudentJDBCDao {
    /**
     *
     * @param args
     */
    public static void main(String args[])
    {
        Driver d = new Driver("sun.jdbc.odbc.JdbcOdbcDrivers");
        StudentDao su = new StudentDAOImpl();
        StudentPrinter sp = new StudentPrinter();
       
        List<StudentData> aList = su.getStudent();
        
        sp.printStudents(aList);
        for(StudentData e: aList)
		{
			StudentData ex = su.getStudentWithStudentID(e.getS_id());
			sp.printStudent(ex);
		}
		
		for(StudentData e: aList)
		{
			List<StudentData> el = su.getStudentWithName(e.getFirstName(), e.getLastName());
			sp.printStudents(el);
		}
		
        
    }
}
