/*
Team 5
Task 7
Date: Jan. 28, 2015
Only for educational use
 */
package formbeans;

import org.mybeans.form.FormBean;

public class RegisterForm extends FormBean {

	private String    age;
	private String    retirementAge;
	private String    saving;
	private String    rate;
	
	public String    getAge()               { return age;            }
	public String    getRetirementAge()     { return retirementAge;  }
	public String    getSaving() 		    { return saving;	     }
	public String    getRate() 	            { return rate;           }

	public void setAge(String s) 		     {	age      = s;         }
    public void setRetirementAge(String s)   {	retirementAge  = s;   }
	public void setSaving(String s) 		 {	saving       = s;	  }
	public void setRate(String s)            {	rate  = s;            }
    
}
