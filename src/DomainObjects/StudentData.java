/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainObjects;

import java.sql.Date;

/**
 *
 * @author Parth
 */
public class StudentData {
    
    private String s_id;
	private String lastName;
	private String firstName;
	private Date birthDate;
	
	public void setS_id(String s_id)
	{
		this.s_id = s_id;
	}
	
	public String getS_id()
	{
		return s_id;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate()
	{
		return birthDate;
	}

}
