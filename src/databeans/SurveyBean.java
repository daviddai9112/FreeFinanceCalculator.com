package databeans;
import org.genericdao.PrimaryKey;

@PrimaryKey("surveyId")
public class SurveyBean {
	
	
	private int surveyId;
	private String    q1;
	private String    q2;
	private String    q3;
	private String    q4;
	private String    q5;
	private String    q6;
	private String    q7;
	private String    q8;
	private String    q9;
	private String    q10;
	
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
	
	public String    getQ5()               { return q5;            }
	public void setQ5(String s) 		    {	q5      = s;        }
	
	public String    getQ6()               { return q6;            }
	public void setQ6(String s) 		    {	q6      = s;        }
	
	public String    getQ7()               { return q7;            }
	public void setQ7(String s) 		    {	q7      = s;        }
	
	public String    getQ8()               { return q8;            }
	public void setQ8(String s) 		    {	q8      = s;        }
	
	public String    getQ9()               { return q9;            }
	public void setQ9(String s) 		    {	q9      = s;        }
	
	public String    getQ10()               { return q10;            }
	public void setQ10(String s) 		    {	q10      = s;        }
}
