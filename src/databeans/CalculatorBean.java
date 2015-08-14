package databeans;
import org.genericdao.PrimaryKey;

@PrimaryKey("calId")
public class CalculatorBean {
	
	
	private int calId;
	private int userid;
	private long    money_saved;
	private long    income;
	private int    cur_age;
	private int    retire_age;
	private int    saving_rate;
	private int    income_increase_rate;
	private boolean pension;
	private int    pension_age;
	private long    pension_amount;
	private boolean ssn;
	private int    SSN_age;
	private long    SSN_amount;
	private boolean partner;
	private boolean partner_pension;
	private int    partner_pension_age;
	private long    partner_pension_amount;
	private boolean partner_SSN;
	private int    partner_SSN_age;
	private long    partner_SSN_amount;
	private int    dependent;
	private int    retirement_level;
	private int return_rate_before;
	private int return_rate_after;
	private int inflation_rate;
	
	public int    getCalId()               { return calId;            }
	public void setCalId(int i) 		    {	calId      = i;        }
	
	public int    getUserId()               { return userid;            }
	public void setUserId(int i) 		    {	userid      = i;        }
	
	public long    getMoney_Saved()               { return money_saved;            }
	public void setMoney_Saved(long l) 		    {	money_saved      = l;        }
	
	public long    getIncome()               { return income;            }
	public void setIncome(long l) 		    {	income      = l;        }

	public int    getCur_Age()               { return cur_age;            }
	public void setCur_Age(int i) 		    {	cur_age      = i;        }
	
	public int    getRetire_Age()               { return retire_age;            }
	public void setRetire_Age(int i) 		    {	retire_age      = i;        }
	
	public int    getSaving_Rate()               { return saving_rate;            }
	public void setSaving_Rate(int i) 		    {	saving_rate      = i;        }
	
	public int    getIncome_Increase_Rate()               { return income_increase_rate;            }
	public void setIncome_Increase_Rate(int i) 		    {	income_increase_rate      = i;        }
	
	public boolean    getPension()               { return pension;            }
	public void setPension(int i) {
		if (i == 1)
			pension = true;
		else
			pension = false;
	}
	
	public int    getPension_Age()               { return pension_age;            }
	public void setPension_Age(int i) 		    {	pension_age      = i;        }
	
	public long    getPension_Amount()               { return pension_amount;            }
	public void setPension_Amount(long l) 		    {	pension_amount      = l;        }
	
	public boolean    getSSN()               { return ssn;            }
	public void setSSN(int i) {
		if (i == 1)
			ssn = true;
		else
			ssn = false;
	}
	
	public int    getSSN_Age()               { return SSN_age;            }
	public void setSSN_Age(int i) 		    {	SSN_age      = i;        }
	
	public long    getSSN_Amount()               { return SSN_amount;            }
	public void setSSN_Amount(long l) 		    {	SSN_amount      = l;        }
	
	public boolean getPartner()               { return partner;            }
	public void setPartner(int i) {
		if (i == 1)
			partner = true;
		else
			partner = false;
	}
	
	public boolean getPartner_Pension()               { return partner_pension;            }
	public void setPartner_Pension(int i) {
		if (i == 1)
			partner_pension = true;
		else
			partner_pension = false;
	}
	
	public int    getPartner_Pension_Age()               { return partner_pension_age;            }
	public void setPartner_Pension_Age(int i) 		    {	partner_pension_age      = i;        }
	
	public long    getPartner_Pension_Amount()               { return partner_pension_amount;            }
	public void setPartner_Pension_Amount(long l) 		    {	partner_pension_amount      = l;        }

	public boolean    getPartner_SSN()               { return partner_SSN;            }
	public void setPartner_SSN(int i) {
		if (i == 1)
			partner_SSN = true;
		else
			partner_SSN = false;
	}
	
	public int    getPartner_SSN_Age()               { return partner_SSN_age;            }
	public void setPartner_SSN_Age(int i) 		    {	partner_SSN_age      = i;        }
	
	public long    getPartner_SSN_Amount()               { return partner_SSN_amount;            }
	public void setPartner_SSN_Amount(long l) 		    {	partner_SSN_amount      = l;        }
	
	public int    getDependent()               { return dependent;            }
	public void setDependent(int i) 		    {	dependent      = i;        }
	
	public int    getRetirement_Level()               { return retirement_level;            }
	public void setRetirement_Level(int i) 		    {	retirement_level      = i;        }
	
	public int    getInvestment_Rate_Before()               { return return_rate_before;            }
	public void setInvestment_Rate_Before(int i) 		    {	return_rate_before      = i;        }
	
	public int    getInvestment_Rate_After()               { return return_rate_after;            }
	public void setInvestment_Rate_After(int i) 		    {	return_rate_after      = i;        }
	
	public int    getInflation_Rate()               { return inflation_rate;            }
	public void setInflation_Rate(int i) 		    {	inflation_rate      = i;        }
}
