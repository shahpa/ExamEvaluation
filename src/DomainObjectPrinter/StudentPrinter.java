/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainObjectPrinter;

import DomainObjects.StudentData;
import java.util.List;

/**
 *
 * @author Parth
 */
public class StudentPrinter {
    public void printStudents(List<StudentData> aList)
	{
		if (aList == null)
		{
			System.out.println("*** No Student ***\n");
			return;
		}
		
		int n = 0;
		
		for(StudentData a : aList)
		{
			n++;
                        //System.out.println("the value of n is : "+n);
			printStudent(a);
		}
		System.out.println("Student Count is " + n + "\n");
	}
	
	public void printStudent(StudentData a)
	{
		System.out.println("\nStudent ID is " + a.getS_id());
		System.out.println("last name is " + a.getLastName());
		System.out.println("first name is " + a.getFirstName());
		System.out.println("birth date is " + a.getBirthDate() + "\n");

	}
    
}
