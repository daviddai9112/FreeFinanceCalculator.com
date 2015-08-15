package databeans;
import org.genericdao.PrimaryKey;

@PrimaryKey("calId")
public class CalculatorBean {
	
	
	private int calId;
	private int userid;
	private long    money_saved;
	private long    income;
	private int    curage;
	private int    retire_age;
	private int    saving_rate;
	private int    income_increase_rate;
	private boolean pension;
	private int    pension_age;
	private long    pension_amount;
	private boolean ssn;
	private int    ssn_age;
	private long    ssn_amount;
	private boolean partner;
	private boolean partner_pension;
	private int    partner_pension_age;
	private long    partner_pension_amount;
	private boolean partner_ssn;
	private int    partner_ssn_age;
	private long    partner_ssn_amount;
	private int    dependent;
	private int    retirement_level;
	private int return_rate_before;
	private int return_rate_after;
	private int inflation_rate;
	private int store_dependent_college_0;
	private int store_dependent_college_1;
	private int store_dependent_college_2;
	private int store_dependent_college_3;
	private int store_dependent_college_4;
	private int store_dependent_wedding_0;
	private int store_dependent_wedding_1;
	private int store_dependent_wedding_2;
	private int store_dependent_wedding_3;
	private int store_dependent_wedding_4;

	
	public int    getCalId()               { return calId;            }
	public void setCalId(int i) 		    {	calId      = i;        }
	
	public int    getUserId()               { return userid;            }
	public void setUserId(int i) 		    {	userid      = i;        }
	
	public long    getMoney_saved()               { return money_saved;            }
	public void setMoney_saved(long l) 		    {	money_saved      = l;        }
	
	public long    getIncome()               { return income;            }
	public void setIncome(long l) 		    {	income      = l;        }

	public int    getCurage()               { return curage;            }
	public void setCurage(int i) 		    {	curage      = i;        }
	
	public int    getRetire_age()               { return retire_age;            }
	public void setRetire_age(int i) 		    {	retire_age      = i;        }
	
	public int    getSaving_rate()               { return saving_rate;            }
	public void setSaving_rate(int i) 		    {	saving_rate      = i;        }
	
	public int    getIncome_increase_rate()               { return income_increase_rate;            }
	public void setIncome_increase_rate(int i) 		    {	income_increase_rate      = i;        }
	
	public boolean    getPension()               { return pension;            }
	public void setPension(int i) {
		if (i == 1)
			pension = true;
		else
			pension = false;
	}
	
	public int    getPension_age()               { return pension_age;            }
	public void setPension_age(int i) 		    {	pension_age      = i;        }
	
	public long    getPension_amount()               { return pension_amount;            }
	public void setPension_amount(long l) 		    {	pension_amount      = l;        }
	
	public boolean    getSsn()               { return ssn;            }
	public void setSsn(int i) {
		if (i == 1)
			ssn = true;
		else
			ssn = false;
	}
	
	public int    getSsn_age()               { return ssn_age;            }
	public void setSsn_age(int i) 		    {	ssn_age      = i;        }
	
	public long    getSsn_amount()               { return ssn_amount;            }
	public void setSsn_amount(long l) 		    {	ssn_amount      = l;        }
	
	public boolean getPartner()               { return partner;            }
	public void setPartner(int i) {
		if (i == 1)
			partner = true;
		else
			partner = false;
	}
	
	public boolean getPartner_pension()               { return partner_pension;            }
	public void setPartner_pension(int i) {
		if (i == 1)
			partner_pension = true;
		else
			partner_pension = false;
	}
	
	public int    getPartner_pension_age()               { return partner_pension_age;            }
	public void setPartner_pension_age(int i) 		    {	partner_pension_age      = i;        }
	
	public long    getPartner_pension_amount()               { return partner_pension_amount;            }
	public void setPartner_pension_amount(long l) 		    {	partner_pension_amount      = l;        }

	public boolean    getPartner_ssn()               { return partner_ssn;            }
	public void setPartner_ssn(int i) {
		if (i == 1)
			partner_ssn = true;
		else
			partner_ssn = false;
	}
	
	public int    getPartner_ssn_age()               { return partner_ssn_age;            }
	public void setPartner_ssn_age(int i) 		    {	partner_ssn_age      = i;        }
	
	public long    getPartner_ssn_amount()               { return partner_ssn_amount;            }
	public void setPartner_ssn_amount(long l) 		    {	partner_ssn_amount      = l;        }
	
	public int    getDependent()               { return dependent;            }
	public void setDependent(int i) 		    {	dependent      = i;        }
	
	public int    getRetirement_level()               { return retirement_level;            }
	public void setRetirement_level(int i) 		    {	retirement_level      = i;        }
	
	public int    getReturn_rate_before()               { return return_rate_before;            }
	public void setReturn_rate_before(int i) 		    {	return_rate_before      = i;        }
	
	public int    getReturn_rate_after()               { return return_rate_after;            }
	public void setReturn_rate_after(int i) 		    {	return_rate_after      = i;        }
	
	public int    getInflation_rate()               { return inflation_rate;            }
	public void setInflation_rate(int i) 		    {	inflation_rate      = i;        }
	
	
	public int    getStore_dependent_college_0()               { return store_dependent_college_0;            }
	public void setStore_dependent_college_0(int i) 		    {	store_dependent_college_0      = i;        }
	
	public int    getStore_dependent_college_1()               { return store_dependent_college_1;            }
	public void setStore_dependent_college_1(int i) 		    {	store_dependent_college_1      = i;        }

	public int    getStore_dependent_college_2()               { return store_dependent_college_2;            }
	public void setStore_dependent_college_2(int i) 		    {	store_dependent_college_2      = i;        }
	
	public int    getStore_dependent_college_3()               { return store_dependent_college_3;            }
	public void setStore_dependent_college_3(int i) 		    {	store_dependent_college_3      = i;        }
	
	public int    getStore_dependent_college_4()               { return store_dependent_college_4;            }
	public void setStore_dependent_college_4(int i) 		    {	store_dependent_college_4      = i;        }
	
	public int    getStore_dependent_wedding_0()               { return store_dependent_wedding_0;            }
	public void setStore_dependent_wedding_0(int i) 		    {	store_dependent_wedding_0      = i;        }
	
	public int    getStore_dependent_wedding_1()               { return store_dependent_wedding_1;            }
	public void setStore_dependent_wedding_1(int i) 		    {	store_dependent_wedding_1      = i;        }

	public int    getStore_dependent_wedding_2()               { return store_dependent_wedding_2;            }
	public void setStore_dependent_wedding_2(int i) 		    {	store_dependent_wedding_2      = i;        }
	
	public int    getStore_dependent_wedding_3()               { return store_dependent_wedding_3;            }
	public void setStore_dependent_wedding_3(int i) 		    {	store_dependent_wedding_3      = i;        }
	
	public int    getStore_dependent_wedding_4()               { return store_dependent_wedding_4;            }
	public void setStore_dependent_wedding_4(int i) 		    {	store_dependent_wedding_4      = i;        }

}
