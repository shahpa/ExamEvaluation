/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examevaluation;

import AccessInterface.*;
import java.sql.ResultSet;
/**
 *
 * @author Parth
 */
public class ExamEvaluation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Driver d = new Driver("sun.jdbc.odbc.JdbcOdbcDriver");
        
        AccessConnection con = new AccessConnection("jdbc:odbc:Database1", "", "");
        
        PrepStatement p = new PrepStatement(con.getConnection(),"select * from StudentData");
        
        try
        {
            ResultSet rs = p.getStatement().executeQuery();
            while(rs.next())
            {
                String ssn = rs.getString("student_id");
                String first_name = rs.getString("student_first_name");
                String last_name = rs.getString("student_last_name");
                
                System.out.println(ssn+" "+first_name+" "+last_name);
                
            }
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
