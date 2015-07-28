package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("userId")
public class UserBean {

	private int    userId;
	private int    age;
	private int    retirementAge;
	private long    saving;
	private int    rate;
	
	public int    getUserId()            { return userId;         }
	public int    getAge()               { return age;            }
	public int    getRetirementAge()     { return retirementAge;  }
	public long   getSaving() 		     { return saving;		  }
	public int    getRate() 	         { return rate;           }

	public void setUserId(int i) 	     {	userId = i;           }
	public void setAge(int i) 		     {	age      = i;         }
    public void setRetirementAge(int i)  {	retirementAge  = i;   }
	public void setSaving(long l) 		 {	saving       = l;	  }
	public void setRate(int i)           {	rate  = i;            }
	
}
