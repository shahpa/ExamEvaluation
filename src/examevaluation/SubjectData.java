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
public class SubjectData {
    public static void main(String[] args) {
        // TODO code application logic here
        Driver d = new Driver("sun.jdbc.odbc.JdbcOdbcDriver");
        
        AccessConnection con = new AccessConnection("jdbc:odbc:Database1", "", "");
        
        PrepStatement p = new PrepStatement(con.getConnection(),"select * from SubjectData");
        
        try
        {
            ResultSet rs = p.getStatement().executeQuery();
            while(rs.next())
            {
                String s_id = rs.getString("student_id");
                String sub_id = rs.getString("subject_id");
                String sub_name = rs.getString("subject_name");
                String test1 = rs.getString("test1_marks");
                String test2 = rs.getString("test2_marks");
                String avg = rs.getString("avg_marks");
                
                System.out.println(s_id+" "+sub_id+" "+sub_name+" "+test1+" "+test2+" "+test2+" "+avg);
                
            }
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
