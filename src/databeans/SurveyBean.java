package databeans;
import org.genericdao.PrimaryKey;

@PrimaryKey("surveyId")
public class SurveyBean {
	
	
	private int surveyId;
	private String    q1;
	private String    q2;
	private String    q3;
	private String    q4;
	private String email;
	
	public int    getSurveyId()               { return surveyId;            }
	public void setSurveyId(int i) 		    {	surveyId      = i;        }
	
	public String    getQ1()               { return q1;            }
	public void setQ1(String s) 		    {	q1      = s;        }

	public String    getQ2()               { return q2;            }
	public void setQ2(String s) 		    {	q2      = s;        }
	
	public String    getQ3()               { return q3;            }
	public void setQ3(String s) 		    {	q3      = s;        }
	
	public String    getQ4()               { return q4;            }
	public void setQ4(String s) 		    {	q4      = s;        }
	
	public String    getEmail()               { return email;            }
	public void setEmail(String s) 		    {	email      = s;        }

}
