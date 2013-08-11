/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOInterface;

import DomainObjects.StudentData;
import java.util.List;
/**
 *
 * @author Parth
 */
public interface StudentDao {
    List<StudentData> getStudent();
    List<StudentData> getStudentWithLastName(String ln);
    List<StudentData> gettudentWithFirstName(String fn);
    StudentData getStudentWithStudentID(String s_id);
    List<StudentData> getStudentWithName(String fn, String ln);
}
