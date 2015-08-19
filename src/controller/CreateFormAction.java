package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CalculatorDAO;
import model.Model;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import au.com.bytecode.opencsv.CSVWriter;
import databeans.Calculation;
import databeans.CalculatorBean;
import databeans.FormBean;
import formbeans.CalculatorForm;

public class CreateFormAction extends Action {
	private FormBeanFactory<CalculatorForm> formBeanFactory = FormBeanFactory
			.getInstance(CalculatorForm.class);
	private CalculatorDAO calDAO;
	private int runout = -1;
	private long lastyr_income = -1;
	private long total_retired = -1;
	private long retirement_spending = -1;
	private long retirement_total_spending = -1;

	public CreateFormAction(Model model) {
		calDAO = model.getCalculatorDAO();
	}

	public String getName() {
		return "create_form.do";
	}

	public String perform(HttpServletRequest request) {
		// EmployeeBean employ = (EmployeeBean) request.getSession(false)
		// .getAttribute("employee");
		// if (employ == null) {
		// return "employee_login.do";
		// }
		try {

			List<String> errors = new ArrayList<String>();
			request.setAttribute("errors", errors);

			CalculatorForm form = (CalculatorForm) formBeanFactory
					.create(request);

			if (!form.isPresent())
				return "finance_calculator.html";

			errors.addAll(form.getValidationErrors());

			if (errors.size() != 0) {
				return "finance_calculator.html";
			}

			System.out.println(form.getMoneysaved());
			System.out.println(form.getIncome());
			System.out.println(form.getCurage());
			System.out.println(form.getRetireage());
			System.out.println(form.getSavingrate());
			System.out.println(form.getIncomeincreaserate());
			System.out.println(form.getPension());
			System.out.println(form.getPensionage());
			System.out.println(form.getPensionamount());
			System.out.println(form.getSsn());
			System.out.println(form.getSsnage());
			System.out.println("ssn" + form.getSsnamount());
			System.out.println(form.getPartner());
			System.out.println(form.getPartnerpension());
			System.out.println(form.getPartnerpensionage());
			System.out.println(form.getPartnerpensionamount());
			System.out.println(form.getPartnerssn());
			System.out.println(form.getPartnerssnage());
			System.out.println("partner_ssn" + form.getPartnerssnamount());
			System.out.println(form.getDependent());
			System.out.println(form.getRetirementlevel());
			System.out.println(form.getReturnratebefore());
			System.out.println(form.getReturnrateafter());
			System.out.println(form.getInflationrate());

			CalculatorBean calbean = new CalculatorBean();

			calbean.setMoney_saved(Long.parseLong(form.getMoneysaved()));

			calbean.setIncome(Long.parseLong(form.getIncome()));
			calbean.setCurage(Integer.parseInt(form.getCurage()));
			calbean.setRetire_age(Integer.parseInt(form.getRetireage()));

			double savingrate = Double.parseDouble(form.getSavingrate());
			calbean.setSaving_rate((int) (savingrate * 100));

			double incomeincreaserate = Double.parseDouble(form
					.getIncomeincreaserate());
			calbean.setIncome_increase_rate((int) (incomeincreaserate * 100));

			// pension
			calbean.setPension(Integer.parseInt(form.getPension()));
			calbean.setPension_age(Integer.parseInt(form.getPensionage()));
			calbean.setPension_amount(Long.parseLong(form.getPensionamount()));

			// SSN
			calbean.setSsn(Integer.parseInt(form.getSsn()));
			calbean.setSsn_age(Integer.parseInt(form.getSsnage()));
			calbean.setSsn_amount((long) Double.parseDouble(form.getSsnamount()));

			calbean.setPartner(Integer.parseInt(form.getPartner()));
			// partner_pension
			calbean.setPartner_pension(Integer.parseInt(form
					.getPartnerpension()));
			calbean.setPartner_pension_age(Integer.parseInt(form
					.getPartnerpensionage()));
			calbean.setPartner_pension_amount(Long.parseLong(form
					.getPartnerpensionamount()));

			// partner_ssn
			calbean.setPartner_ssn(Integer.parseInt(form.getPartnerssn()));
			calbean.setPartner_ssn_age(Integer.parseInt(form.getPartnerssnage()));
			calbean.setPartner_ssn_amount((long) Double.parseDouble(form
					.getPartnerssnamount()));

			calbean.setDependent(Integer.parseInt(form.getDependent()));

			double retirement_level = Double.parseDouble(form
					.getRetirementlevel());
			calbean.setRetirement_level((int) (retirement_level * 100));

			double return_rate_before = Double.parseDouble(form
					.getReturnratebefore());
			calbean.setReturn_rate_before((int) (return_rate_before * 100));

			double return_rate_after = Double.parseDouble(form
					.getReturnrateafter());
			calbean.setReturn_rate_after((int) (return_rate_after * 100));

			double inflation_rate = Double.parseDouble(form.getInflationrate());
			calbean.setInflation_rate((int) (inflation_rate * 100));

			calbean.setStore_dependent_college_0(Integer.parseInt(form
					.getStore_dependent_college_0()));
			calbean.setStore_dependent_college_1(Integer.parseInt(form
					.getStore_dependent_college_1()));
			calbean.setStore_dependent_college_2(Integer.parseInt(form
					.getStore_dependent_college_2()));
			calbean.setStore_dependent_college_3(Integer.parseInt(form
					.getStore_dependent_college_3()));
			calbean.setStore_dependent_college_4(Integer.parseInt(form
					.getStore_dependent_college_4()));
			calbean.setStore_dependent_wedding_0(Integer.parseInt(form
					.getStore_dependent_wedding_0()));
			calbean.setStore_dependent_wedding_1(Integer.parseInt(form
					.getStore_dependent_wedding_1()));
			calbean.setStore_dependent_wedding_2(Integer.parseInt(form
					.getStore_dependent_wedding_2()));
			calbean.setStore_dependent_wedding_3(Integer.parseInt(form
					.getStore_dependent_wedding_3()));
			calbean.setStore_dependent_wedding_4(Integer.parseInt(form
					.getStore_dependent_wedding_4()));
			calDAO.create(calbean);

			// System.out.println("calbean.getMoney_Saved()         ++"
			// + calbean.getMoney_Saved());
			// System.out.println("calbean.getIncome()              ++"
			// + calbean.getIncome());
			// System.out.println("calbean.getCur_Age()               ++"
			// + calbean.getCur_Age());
			// System.out.println("calbean.getRetire_Age()            ++"
			// + calbean.getRetire_Age());
			// System.out.println("calbean.getSaving_Rate()           ++"
			// + calbean.getSaving_Rate());
			// System.out.println("calbean.getIncome_Increase_Rate()  ++"
			// + calbean.getIncome_Increase_Rate());
			// System.out.println("calbean.getPension()               ++"
			// + calbean.getPension());
			// System.out.println("calbean.getPension_Age()           ++"
			// + calbean.getPension_Age());
			// System.out.println("calbean.getPension_Amount()        ++"
			// + calbean.getPension_Amount());
			// System.out.println("calbean.getSSN()                   ++"
			// + calbean.getSSN());
			// System.out.println("calbean.getSSN_Age()               ++"
			// + calbean.getSSN_Age());
			// System.out.println("calbean.getSSN_Amount()            ++"
			// + calbean.getSSN_Amount());
			// System.out.println("calbean.getPartner()               ++"
			// + calbean.getPartner());
			// System.out.println("calbean.getPartner_Pension()       ++"
			// + calbean.getPartner_Pension());
			// System.out.println("calbean.getPartner_Pension_Age()   ++"
			// + calbean.getPartner_Pension_Age());
			// System.out.println("calbean.getPartner_Pension_Amount()++"
			// + calbean.getPartner_Pension_Amount());
			// System.out.println("calbean.getPartner_SSN()           ++"
			// + calbean.getPartner_SSN());
			// System.out.println("calbean.getPartner_SSN_Age()       ++"
			// + calbean.getPartner_SSN_Age());
			// System.out.println("calbean.getPartner_SSN_Amount()    ++"
			// + calbean.getPartner_SSN_Amount());
			// System.out.println("calbean.getDependent()             ++"
			// + calbean.getDependent());
			// System.out.println("calbean.getRetirement_Level()      ++"
			// + calbean.getRetirement_Level());
			// System.out.println("calbean.getReturn_Rate_Before()++"
			// + calbean.getInvestment_Rate_Before());
			// System.out.println("calbean.getInvestment_Rate_After() ++"
			// + calbean.getInvestment_Rate_After());
			// System.out.println("calbean.getInflation_Rate()        ++"
			// + calbean.getInflation_Rate());

			// test
			// CalculatorBean test = new CalculatorBean();
			// test.setMoney_Saved(1000);
			// test.setIncome(110000);
			// test.setCurage(25);
			// test.setRetire_Age(67);
			// test.setSaving_Rate(15);
			// test.setIncome_Increase_Rate(2);
			// test.setRetirement_Level(90);
			// test.setPension(1);
			// test.setPension_Age(55);
			// test.setPension_Amount(10000);
			// test.setPartner_Pension(1);
			// test.setPartner_Pension_Age(60);
			// test.setPartner_Pension_Amount(5000);
			// test.setSSN(1);
			// test.setSSN_Age(70);
			// test.setSSN_Amount(8000);
			// test.setPartner_SSN(1);
			// test.setPartner_SSN_Age(80);
			// test.setPartner_SSN_Amount(3000);
			//
			// test.setInvestment_Rate_Before(7);
			// test.setInvestment_Rate_After(4);
			// test.setInflation_Rate(3);
			Calculation calculation = new Calculation();

			FormBean[] formBean = calculation.calculation(calbean);
			// for (int i = 0; i < formBean.length; i++) {
			// System.out.print(formBean[i].getAge());
			// System.out.print("    ");
			// System.out.print(formBean[i].getBeginretirementbalance());
			// System.out.print("    ");
			// System.out.print(formBean[i].getInvestmentgrowth());
			// System.out.print("    ");
			// System.out.print(formBean[i].getSaving());
			// System.out.print("    ");
			// System.out.print(formBean[i].getRetirementspend());
			// System.out.print("    ");
			// System.out.print(formBean[i].getAccountspending());
			// System.out.print("    ");
			// System.out.print(formBean[i].getTotal());
			// System.out.println("");
			// }
			request.setAttribute("calbean", calbean);
			request.setAttribute("formBeans", formBean);
			request.setAttribute("income_rate", calbean.getSaving_rate());
			request.setAttribute("retirement_level",
					calbean.getRetirement_level());
			if(calculation.runout  == 101){
				request.setAttribute("run_out", "over 100");
			}else{
				request.setAttribute("run_out", calculation.runout);
			}
			
			request.setAttribute("lastyr_income", calculation.lastyr_income);
			request.setAttribute("total_retired", calculation.total_retired);
			request.setAttribute("retirement_spending",
					calculation.retirement_spending);
			request.setAttribute("rate_before",
					new Integer(calbean.getReturn_rate_before()));

			if (calbean.getPartner_pension())
				request.setAttribute("partner_pension", 1);
			else
				request.setAttribute("partner_pension", 0);
			if (calbean.getPartner())
				request.setAttribute("partner", 1);
			else
				request.setAttribute("partner", 0);
			if (calbean.getPartner_ssn())
				request.setAttribute("partner_ssn", 1);
			else
				request.setAttribute("partner_ssn", 0);
			if (calbean.getSsn())
				request.setAttribute("ssn", 1);
			else
				request.setAttribute("ssn", 0);
			if (calbean.getPension())
				request.setAttribute("pension", 1);
			else
				request.setAttribute("pension", 0);
			// set graphic parameter
			request.setAttribute("saving_rate",
					(double) calbean.getSaving_rate() / (double) 100);
			request.setAttribute("income_increase_rate",
					(double) calbean.getIncome_increase_rate() / (double) 100);
			request.setAttribute("retirement_level1",
					(double) calbean.getRetirement_level() / (double) 100);
			request.setAttribute("return_rate_before",
					(double) calbean.getReturn_rate_before() / (double) 100);
			request.setAttribute("return_rate_after",
					(double) calbean.getReturn_rate_after() / (double) 100);
			request.setAttribute("inflation_rate",
					(double) calbean.getInflation_rate() / (double) 100);

			
			//recommend_return_rate
			
			CalculatorBean tmpbean = new CalculatorBean();
			// create tmpbean
			tmpbean.setMoney_saved(calbean.getMoney_saved());
			tmpbean.setIncome(calbean.getIncome());
			tmpbean.setCurage(calbean.getCurage());
			tmpbean.setRetire_age(calbean.getRetire_age());
			tmpbean.setSaving_rate(calbean.getSaving_rate());
			tmpbean.setIncome_increase_rate(calbean
					.getIncome_increase_rate());
			if (calbean.getPension())
				tmpbean.setPension(1);
			else
				tmpbean.setPension(0);
			tmpbean.setPension_age(calbean.getPension_age());
			tmpbean.setPension_amount(calbean.getPension_amount());
			if (calbean.getSsn())
				tmpbean.setSsn(1);
			else
				tmpbean.setSsn(0);
			tmpbean.setSsn_age(calbean.getSsn_age());
			tmpbean.setSsn_amount(calbean.getSsn_amount());
			if (calbean.getPartner())
				tmpbean.setPartner(1);
			else
				tmpbean.setPartner(0);
			if (calbean.getPartner_pension())
				tmpbean.setPartner_pension(1);
			else
				tmpbean.setPartner_pension(0);
			tmpbean.setPartner_pension_age(calbean.getPartner_pension_age());
			tmpbean.setPartner_pension_amount(calbean
					.getPartner_pension_amount());
			if (calbean.getPartner_ssn())
				tmpbean.setPartner_ssn(1);
			else
				tmpbean.setPartner_ssn(0);
			tmpbean.setPartner_ssn_age(calbean.getPartner_ssn_age());
			tmpbean.setPartner_ssn_amount(calbean.getPartner_ssn_amount());
			tmpbean.setDependent(calbean.getDependent());
			tmpbean.setRetirement_level(calbean.getRetirement_level());
			tmpbean.setReturn_rate_before(calbean.getReturn_rate_before());
			tmpbean.setReturn_rate_after(calbean.getReturn_rate_after());
			tmpbean.setInflation_rate(calbean.getInflation_rate());
			tmpbean.setStore_dependent_college_0(calbean
					.getStore_dependent_college_0());
			tmpbean.setStore_dependent_college_1(calbean
					.getStore_dependent_college_1());
			tmpbean.setStore_dependent_college_2(calbean
					.getStore_dependent_college_2());
			tmpbean.setStore_dependent_college_3(calbean
					.getStore_dependent_college_3());
			tmpbean.setStore_dependent_college_4(calbean
					.getStore_dependent_college_4());
			tmpbean.setStore_dependent_wedding_0(calbean
					.getStore_dependent_wedding_0());
			tmpbean.setStore_dependent_wedding_1(calbean
					.getStore_dependent_wedding_1());
			tmpbean.setStore_dependent_wedding_2(calbean
					.getStore_dependent_wedding_2());
			tmpbean.setStore_dependent_wedding_3(calbean
					.getStore_dependent_wedding_3());
			tmpbean.setStore_dependent_wedding_4(calbean
					.getStore_dependent_wedding_4());
			int newrate = tmpbean.getReturn_rate_before();
			Calculation tmpcal = new Calculation();
			FormBean[] tempbeans = tmpcal.calculation(tmpbean);
			if (tempbeans[tempbeans.length - 1].getTotal() == 0 && tempbeans[tempbeans.length - 2].getTotal() == 0) {
				newrate++;
				tmpbean.setReturn_rate_before(newrate);
				while (tempbeans[tempbeans.length - 1].getTotal() == 0 && tempbeans[tempbeans.length - 2].getTotal() == 0) {
					newrate++;
					tmpbean.setReturn_rate_before(newrate);
					tmpcal = new Calculation();
					tempbeans = tmpcal.calculation(tmpbean);
				}
			}else if(tempbeans[tempbeans.length - 1].getTotal() > 0 && tempbeans[tempbeans.length - 2].getTotal() > 0){
				newrate--;
				tmpbean.setReturn_rate_before(newrate);

				while (tempbeans[tempbeans.length - 1].getTotal() > 0 && tempbeans[tempbeans.length - 2].getTotal() > 0) {
					newrate--;
					tmpbean.setReturn_rate_before(newrate);
					tmpcal = new Calculation();
					tempbeans = tmpcal.calculation(tmpbean);
				}
			}
			String recommand_rate = "";
			if (newrate > calbean.getReturn_rate_before()) {
				recommand_rate = "You should make some changes on investment plan to increase your investment rate from <font color='#6698FF'>"
						+ calbean.getReturn_rate_before()
						+ "% </font> to <font color='#6698FF'>"
						+ newrate
						+ "%</font>.";
			} else if (newrate == calbean.getReturn_rate_before()) {
				recommand_rate = "You already have a good return rate! Your money will run out at age of 100.";
			} else {
				recommand_rate = "You will have money surplus at age of 100. You can keep the return rate at <font color='#6698FF'>"
						+ calbean.getReturn_rate_before()
						+ "%</font>, or change your investment plan that has low risk and return rate above <font color='#6698FF'>"
						+ newrate + "%</font>.";
			}
			request.setAttribute("recommand_rate", recommand_rate);
			
			
			if (calculation.runout > 100) {
				request.setAttribute("pic", "img/rainbow.png");
			} else if (calculation.runout >= 85 && calculation.runout <= 100) {
				request.setAttribute("pic", "img/sun.png");
			} else if (calculation.runout >= 75 && calculation.runout < 85) {
				request.setAttribute("pic", "img/windy.png");
			} else {
				request.setAttribute("pic", "img/rainy.png");
			}

			// recommend_retirement_level;
			int rec_retirement_level = getRetirement_level(calbean, calculation, formBean);
			String rec_retirement_level_word = "";
			if (rec_retirement_level > calbean.getRetirement_level()) {
				rec_retirement_level_word = "You will have money surplus at age of 100. You can spend more money to improve quality of life by increase retirement level from <font color='#6698FF'>"
						+ calbean.getRetirement_level()
						+ "% </font> to <font color='#6698FF'>"
						+ rec_retirement_level + "% </font>.";
			} else if (rec_retirement_level == calbean.getRetirement_level()) {
				rec_retirement_level_word = "You already have a good retirement_level!";
			} else {
				rec_retirement_level_word = "You should reduce annual spending after retirement by decreasing retirement level from <font color='#6698FF'>"
						+ calbean.getRetirement_level()
						+ "% </font> to <font color='#6698FF'>"
						+ rec_retirement_level
						+ "% </font> to support retirement plan.";
			}
			System.out
					.println("rec_retirement_level   " + rec_retirement_level);
			request.setAttribute("recommand_retirement_level",
					rec_retirement_level_word);

			// recommend_retirement_age
			int rec_retirement_age = getRetirement_age(calbean, formBean);
			String rec_retirement_age_word = "";
			if (rec_retirement_age > calbean.getRetire_age()) {
				rec_retirement_age_word = "You should delay your retirement age from <font color='#6698FF'>"
						+ calbean.getRetire_age()
						+ "</font> to <font color='#6698FF'>"
						+ rec_retirement_age
						+ "</font> to get enough money for retirement.";
			} else if (rec_retirement_age == calbean.getRetire_age()) {
				rec_retirement_age_word = "You already have an appropriate time for retirement.";
			} else {
				rec_retirement_age_word = "You will have enough money for retirement. You can bring forward retirement age from <font color='#6698FF'>"
						+ calbean.getRetire_age()
						+ "</font> to <font color='#6698FF'>"
						+ rec_retirement_age
						+ "</font>.";
			}
			request.setAttribute("rec_retirement_age", rec_retirement_age_word);

			// recommend_saving_rate
			int rec_saving_rate = getSaving_rate(calbean);
			String rec_saving_rate_word = "";
			if(rec_saving_rate > calbean.getSaving_rate()){
				rec_saving_rate_word = "You should increase contributions from <font color='#6698FF'>"+ calbean.getSaving_rate()
						+ "%</font> to <font color='#6698FF'>"
						+ rec_saving_rate
						+ "%</font> of your income to get enough money for retirement.";
			}else if(rec_saving_rate == calbean.getSaving_rate()){
				rec_saving_rate_word = "You already have a good saving rate. Please keep going.";
			}else{
				rec_saving_rate_word = "You will have enough money for retirement. You can spend more money to improve life quality by decreasing contributions from <font color='#6698FF'>"
						+ calbean.getSaving_rate()
						+ "%</font> to <font color='#6698FF'>"
						+ rec_saving_rate
						+ "%</font> of your income.";
			}
			System.out.println("rec_saving_rate   " + rec_saving_rate);
			request.setAttribute("rec_saving_rate", rec_saving_rate_word);

//			String fileName = "abc.csv";
//
//			try {
//				// duplicate full set of settings of CSV file format
//				CSVWriter writer = new CSVWriter(new OutputStreamWriter(
//						new FileOutputStream(fileName), "UTF-8"), ';', '\'');
//				try {
//					// we have to create arrays manually
//					String[] record = "savings-income,100".split(",");
//					String[] record1 = "savings-ssn,100".split(",");
//					String[] record2 = "savings-investment,100".split(",");
//					String[] record3 = "savings-pension,100".split(",");
//					String[] record4 = "spending,100".split(",");
//					writer.writeNext(record);
//					writer.writeNext(record1);
//					writer.writeNext(record2);
//					writer.writeNext(record3);
//					writer.writeNext(record4);
//				} finally {
//					// we have to close writer manually
//					writer.close();
//				}
//			} catch (IOException e) {
//				// we have to process exceptions when it is not required
//				e.printStackTrace();
//			}

			// BufferedWriter out = new BufferedWriter(new
			// FileWriter("result.csv"));
			// CSVWriter writer = new CSVWriter(out);
			//
			// String [] record = "savings-income,100".split(",");
			// String [] record1 = "savings-ssn,100".split(",");
			// String [] record2 = "savings-investment,100".split(",");
			// String [] record3 = "savings-pension,100".split(",");
			// String [] record4 = "spending,100".split(",");
			// writer.writeNext(record);
			// writer.writeNext(record1);
			// writer.writeNext(record2);
			// writer.writeNext(record3);
			// writer.writeNext(record4);
			// writer.close();
			// out.close();
			// System.out.println("CsvCsvCsvCsvCsvCsvCsvCsvCsvCsvCsvCsv");
			//

			retirement_total_spending = -1;
			total_retired = -1;
			runout = -1;
			lastyr_income = -1;
			retirement_spending = -1;
			return "Report.jsp";
		} catch (FormBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "finance_calculator.html";

	}

	// // calculate table
	// private FormBean[] calculation1(CalculatorBean cb) {
	// int age = cb.getCurage();
	// FormBean[] fb = new FormBean[101 - age];
	// int retire_age = cb.getRetire_Age();
	// long money_saved = cb.getMoney_Saved();
	// long income = cb.getIncome();
	// int saving_rate = cb.getSaving_Rate();
	// int income_increase_rate = cb.getIncome_Increase_Rate();
	// int retirement_level = cb.getRetirement_Level();
	// int investment_rate_before = cb.getReturn_Rate_Before();
	// int investment_rate_after = cb.getReturn_Rate_After();
	// int inflate_rate = cb.getInflation_Rate();
	// int pension_age = cb.getPension_Age();
	// long pension = cb.getPension() ? cb.getPension_Amount() : 0;
	// int partner_pension_age = cb.getPartner_Pension_Age();
	// long partner_pension = cb.getPartner_Pension() ? cb
	// .getPartner_Pension_Amount() : 0;
	// int ssn_age = cb.getSSN_Age();
	// long ssn = cb.getSSN() ? cb.getSSN_Amount() : 0;
	// int partner_ssn_age = cb.getPartner_SSN_Age();
	// long partner_ssn = cb.getPartner_SSN() ? cb.getPartner_SSN_Amount() : 0;
	//
	//
	// retirement_total_spending = 0;
	//
	// // fb[0]
	// FormBean fb0 = new FormBean();
	// fb0.setAge(age + 1);
	// fb0.setBeginretirementbalance(money_saved);
	// fb0.setReturngrowth(Math.round((double) (fb0
	// .getBeginretirementbalance() * investment_rate_before)
	// / (double) 100));
	// long f0_ssn = 0;
	// if (age + 1 >= pension_age)
	// f0_ssn += pension;
	// if (age + 1 >= partner_pension_age)
	// f0_ssn += partner_pension;
	// if (age + 1 >= ssn_age)
	// f0_ssn += ssn;
	// if (age + 1 >= partner_ssn_age)
	// f0_ssn += partner_ssn;
	// fb0.setSsn(f0_ssn);
	// fb0.setSaving(Math
	// .round((double) (income * saving_rate) / (double) 100));
	// fb0.setRetirementspend(0);
	// fb0.setAccountspending(0);
	// fb0.setTotal(fb0.getBeginretirementbalance()
	// + fb0.getReturngrowth() + fb0.getSaving() + fb0.getSsn());
	// fb[0] = fb0;
	//
	// for (int i = age + 1; i < retire_age - 1; i++) {
	// income = Math
	// .round((double) ((100 + income_increase_rate) * income)
	// / (double) 100);
	// FormBean temp = fb[i - age - 1];
	// FormBean newbean = new FormBean();
	// newbean.setAge(i + 1);
	// newbean.setBeginretirementbalance(temp.getTotal());
	// newbean.setReturngrowth(Math.round((double) (newbean
	// .getBeginretirementbalance() * investment_rate_before)
	// / (double) 100));
	// long cur_ssn = 0;
	// if (i + 1 >= pension_age)
	// cur_ssn += pension;
	// if (i + 1 >= partner_pension_age)
	// cur_ssn += partner_pension;
	// if (i + 1 >= ssn_age)
	// cur_ssn += ssn;
	// if (i + 1 >= partner_ssn_age)
	// cur_ssn += partner_ssn;
	// newbean.setSsn(cur_ssn);
	// newbean.setSaving(Math.round((double) income * saving_rate
	// / (double) 100));
	// newbean.setRetirementspend(0);
	// newbean.setAccountspending(0);
	// newbean.setTotal(newbean.getBeginretirementbalance()
	// + newbean.getReturngrowth() + newbean.getSaving()
	// + newbean.getSsn());
	// fb[i - age] = newbean;
	// }
	// income = (100 + income_increase_rate) * income / 100;
	// lastyr_income = income;
	// long spending = income * retirement_level / 100;
	// retirement_spending = spending;
	// for (int i = retire_age - 1; i < 101; i++) {
	// FormBean temp = fb[i - age - 1];
	// if (total_retired == -1) {
	// total_retired = temp.getTotal();
	// }
	// FormBean newbean = new FormBean();
	// newbean.setAge(i);
	// newbean.setBeginretirementbalance(temp.getTotal());
	// newbean.setReturngrowth(Math.round((double) (newbean
	// .getBeginretirementbalance() * investment_rate_after)
	// / (double) 100));
	// long cur_snn = 0;
	// if (i + 1 >= pension_age)
	// cur_snn += pension;
	// if (i + 1 >= partner_pension_age)
	// cur_snn += partner_pension;
	// if (i + 1 >= ssn_age)
	// cur_snn += ssn;
	// if (i + 1 >= partner_ssn_age)
	// cur_snn += partner_ssn;
	// newbean.setSsn(cur_snn);
	// newbean.setSaving(0);
	// newbean.setRetirementspend(spending);
	// retirement_total_spending += spending;
	// spending = Math.round((double) ((100 + inflate_rate) * spending)
	// / (double) 100);
	// newbean.setAccountspending((newbean.getBeginretirementbalance() + newbean
	// .getReturngrowth()) > newbean.getRetirementspend() ? newbean
	// .getRetirementspend() : (newbean
	// .getBeginretirementbalance() + newbean
	// .getReturngrowth()));
	// newbean.setTotal(newbean.getBeginretirementbalance()
	// + newbean.getReturngrowth()
	// - newbean.getAccountspending());
	// fb[i - age] = newbean;
	// if (newbean.getBeginretirementbalance()
	// + newbean.getReturngrowth()
	// - newbean.getAccountspending() == 0
	// && runout == -1) {
	// runout = i + 1;
	// }
	// }
	// if (runout == -1)
	// runout = 100;
	// return fb;
	// }

	// calculate recommend retirement level
	// private long retirement_level(long total, int retirement_age,
	// int flate_rate, int return_rate, int pension_age, int pension,
	// int ssn_age, int ssn, int partner_pension_age, int partner_pension,
	// int partner_ssn_age, int partner_ssn) {
	// long rs = 0;
	// double left = Math.pow(((double) (100 + return_rate)) / 100.00,
	// (double) (100 - retirement_age)) * total;
	// //pension amount
	// pension_age = Math.max(pension_age, retirement_age);
	// partner_pension_age = Math.max(pension_age, retirement_age);
	// double total_pension = 0;
	// for(int i = 0; i < 100 - pension_age; i++){
	// total_pension += pension;
	// total_pension = ((double) (100 + return_rate) / 100.00) * total_pension;
	// }
	// left += total_pension;
	//
	// double total_partner_pension = 0;
	// for(int i = 0; i < 100 - partner_pension_age; i++){
	// total_partner_pension += partner_pension;
	// total_partner_pension = ((double) (100 + return_rate) / 100.00) *
	// total_partner_pension;
	// }
	// left += total_partner_pension;
	//
	// //SS amount
	// ssn_age = Math.max(ssn_age, retirement_age);
	// partner_ssn_age = Math.max(partner_ssn_age, retirement_age);
	// double total_ssn = 0;
	// for(int i = 0; i < 100 - ssn_age; i++){
	// total_ssn += ssn;
	// total_ssn = ((double) (100 + return_rate) / 100.00) * total_ssn;
	// }
	// left += total_ssn;
	//
	// double total_partner_ssn = 0;
	// for(int i = 0; i < 100 - partner_ssn_age; i++){
	// total_partner_ssn += partner_ssn;
	// total_partner_ssn = ((double) (100 + return_rate) / 100.00) *
	// total_partner_ssn;
	// }
	// left += total_partner_ssn;
	//
	// double flate_n = Math.pow(((double) (100 + flate_rate)) / 100.00,
	// (double) (100 - retirement_age));
	// double right = 0.00;
	// for (int i = 0; i < 100 - retirement_age; i++) {
	// right += flate_n;
	// flate_n *= ((double) (100 + return_rate) / 100.00);
	// flate_n /= ((double) (100 + flate_rate) / 100.00);
	// }
	// rs = (long) (left / right);
	// return rs - 1;
	// }

	// private int saving_rate(long total_retirement_spending, int
	// retirement_age,
	// int cur_age, int return_rate, long deposit, long income,
	// int income_increase_rate) {
	// int rs = 0;
	// double left = Math.pow(((double) (100 + return_rate)) / 100.00,
	// (double) (retirement_age - cur_age)) * deposit;
	// left = total_retirement_spending - left;
	// double income_increase_n = Math.pow(
	// ((double) (100 + income_increase_rate)) / 100.00,
	// (double) (retirement_age - cur_age));
	// double right = 0.00;
	// for (int i = 0; i < retirement_age - cur_age; i++) {
	// right += income_increase_n;
	// income_increase_n *= ((double) (100 + return_rate) / 100.00);
	// income_increase_n /= ((double) (100 + income_increase_rate) / 100.00);
	// }
	// rs = (int) (left * 100 / (right * income));
	// return rs;
	// }

	private int getSaving_rate(CalculatorBean calbean) {
		Calculation calculation = new Calculation();

		CalculatorBean tmpbean = new CalculatorBean();
		// create tmpbean
		tmpbean.setMoney_saved(calbean.getMoney_saved());
		tmpbean.setIncome(calbean.getIncome());
		tmpbean.setCurage(calbean.getCurage());
		tmpbean.setRetire_age(calbean.getRetire_age());
		tmpbean.setSaving_rate(calbean.getSaving_rate());
		tmpbean.setIncome_increase_rate(calbean.getIncome_increase_rate());
		if (calbean.getPension())
			tmpbean.setPension(1);
		else
			tmpbean.setPension(0);
		tmpbean.setPension_age(calbean.getPension_age());
		tmpbean.setPension_amount(calbean.getPension_amount());
		if (calbean.getSsn())
			tmpbean.setSsn(1);
		else
			tmpbean.setSsn(0);
		tmpbean.setSsn_age(calbean.getSsn_age());
		tmpbean.setSsn_amount(calbean.getSsn_amount());
		if (calbean.getPartner())
			tmpbean.setPartner(1);
		else
			tmpbean.setPartner(0);
		if (calbean.getPartner_pension())
			tmpbean.setPartner_pension(1);
		else
			tmpbean.setPartner_pension(0);
		tmpbean.setPartner_pension_age(calbean.getPartner_pension_age());
		tmpbean.setPartner_pension_amount(calbean.getPartner_pension_amount());
		if (calbean.getPartner_ssn())
			tmpbean.setPartner_ssn(1);
		else
			tmpbean.setPartner_ssn(0);
		tmpbean.setPartner_ssn_age(calbean.getPartner_ssn_age());
		tmpbean.setPartner_ssn_amount(calbean.getPartner_ssn_amount());
		tmpbean.setDependent(calbean.getDependent());
		tmpbean.setRetirement_level(calbean.getRetirement_level());
		tmpbean.setReturn_rate_before(calbean.getReturn_rate_before());
		tmpbean.setReturn_rate_after(calbean.getReturn_rate_after());
		tmpbean.setInflation_rate(calbean.getInflation_rate());
		tmpbean.setStore_dependent_college_0(calbean
				.getStore_dependent_college_0());
		tmpbean.setStore_dependent_college_1(calbean
				.getStore_dependent_college_1());
		tmpbean.setStore_dependent_college_2(calbean
				.getStore_dependent_college_2());
		tmpbean.setStore_dependent_college_3(calbean
				.getStore_dependent_college_3());
		tmpbean.setStore_dependent_college_4(calbean
				.getStore_dependent_college_4());
		tmpbean.setStore_dependent_wedding_0(calbean
				.getStore_dependent_wedding_0());
		tmpbean.setStore_dependent_wedding_1(calbean
				.getStore_dependent_wedding_1());
		tmpbean.setStore_dependent_wedding_2(calbean
				.getStore_dependent_wedding_2());
		tmpbean.setStore_dependent_wedding_3(calbean
				.getStore_dependent_wedding_3());
		tmpbean.setStore_dependent_wedding_4(calbean
				.getStore_dependent_wedding_4());

		int cur_saving_rate = tmpbean.getSaving_rate();
		if (cur_saving_rate >= 100)
			return 100;
		int start = 0;
		int end = 100;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			tmpbean.setSaving_rate(mid);
			FormBean[] temp = calculation.calculation(tmpbean);
			if (temp[temp.length - 1].getTotal() <= 0) {
				if (temp[temp.length - 2].getTotal() > 0)
					return mid;
				else
					start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(end < calbean.getCurage()) end = calbean.getCurage();
		return end;
	}

	private int getRetirement_level(CalculatorBean calbean,
			Calculation calculation, FormBean[] formBean) {
		Calculation tmpcalculation = new Calculation();
		CalculatorBean tmpbean = new CalculatorBean();
		// create tmpbean
		tmpbean.setMoney_saved(calbean.getMoney_saved());
		tmpbean.setIncome(calbean.getIncome());
		tmpbean.setCurage(calbean.getCurage());
		tmpbean.setRetire_age(calbean.getRetire_age());
		tmpbean.setSaving_rate(calbean.getSaving_rate());
		tmpbean.setIncome_increase_rate(calbean.getIncome_increase_rate());
		if (calbean.getPension())
			tmpbean.setPension(1);
		else
			tmpbean.setPension(0);
		tmpbean.setPension_age(calbean.getPension_age());
		tmpbean.setPension_amount(calbean.getPension_amount());
		if (calbean.getSsn())
			tmpbean.setSsn(1);
		else
			tmpbean.setSsn(0);
		tmpbean.setSsn_age(calbean.getSsn_age());
		tmpbean.setSsn_amount(calbean.getSsn_amount());
		if (calbean.getPartner())
			tmpbean.setPartner(1);
		else
			tmpbean.setPartner(0);
		if (calbean.getPartner_pension())
			tmpbean.setPartner_pension(1);
		else
			tmpbean.setPartner_pension(0);
		tmpbean.setPartner_pension_age(calbean.getPartner_pension_age());
		tmpbean.setPartner_pension_amount(calbean.getPartner_pension_amount());
		if (calbean.getPartner_ssn())
			tmpbean.setPartner_ssn(1);
		else
			tmpbean.setPartner_ssn(0);
		tmpbean.setPartner_ssn_age(calbean.getPartner_ssn_age());
		tmpbean.setPartner_ssn_amount(calbean.getPartner_ssn_amount());
		tmpbean.setDependent(calbean.getDependent());
		tmpbean.setRetirement_level(calbean.getRetirement_level());
		tmpbean.setReturn_rate_before(calbean.getReturn_rate_before());
		tmpbean.setReturn_rate_after(calbean.getReturn_rate_after());
		tmpbean.setInflation_rate(calbean.getInflation_rate());
		tmpbean.setStore_dependent_college_0(calbean
				.getStore_dependent_college_0());
		tmpbean.setStore_dependent_college_1(calbean
				.getStore_dependent_college_1());
		tmpbean.setStore_dependent_college_2(calbean
				.getStore_dependent_college_2());
		tmpbean.setStore_dependent_college_3(calbean
				.getStore_dependent_college_3());
		tmpbean.setStore_dependent_college_4(calbean
				.getStore_dependent_college_4());
		tmpbean.setStore_dependent_wedding_0(calbean
				.getStore_dependent_wedding_0());
		tmpbean.setStore_dependent_wedding_1(calbean
				.getStore_dependent_wedding_1());
		tmpbean.setStore_dependent_wedding_2(calbean
				.getStore_dependent_wedding_2());
		tmpbean.setStore_dependent_wedding_3(calbean
				.getStore_dependent_wedding_3());
		tmpbean.setStore_dependent_wedding_4(calbean
				.getStore_dependent_wedding_4());

		int cur_retirement_level = tmpbean.getRetirement_level();
		if (cur_retirement_level >= 160)
			return 160;
		int end = 100;
		int start = 0;
		if(formBean[formBean.length - 1].getTotal() <= 0 && formBean[formBean.length - 2].getTotal() <= 0){
			end = cur_retirement_level;
		}else if(formBean[formBean.length - 1].getTotal() <= 0 && formBean[formBean.length - 2].getTotal() > 0){
			return cur_retirement_level;
		}else{
			start = cur_retirement_level;
		}
		while (start <= end) {
			int mid = start + (end - start) / 2;
			tmpbean.setRetirement_level(mid);
			FormBean[] temp = tmpcalculation.calculation(tmpbean);
			if (temp[temp.length - 1].getTotal() <= 0) {
				if (temp[temp.length - 2].getTotal() > 0)
					return mid;
				else
					end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	private int getRetirement_age(CalculatorBean calbean, FormBean[] formBean) {
		Calculation tmp = new Calculation();

		CalculatorBean tmpbean = new CalculatorBean();
		// create tmpbean
		tmpbean.setMoney_saved(calbean.getMoney_saved());
		tmpbean.setIncome(calbean.getIncome());
		tmpbean.setCurage(calbean.getCurage());
		tmpbean.setRetire_age(calbean.getRetire_age());
		tmpbean.setSaving_rate(calbean.getSaving_rate());
		tmpbean.setIncome_increase_rate(calbean.getIncome_increase_rate());
		if (calbean.getPension())
			tmpbean.setPension(1);
		else
			tmpbean.setPension(0);
		tmpbean.setPension_age(calbean.getPension_age());
		tmpbean.setPension_amount(calbean.getPension_amount());
		if (calbean.getSsn())
			tmpbean.setSsn(1);
		else
			tmpbean.setSsn(0);
		tmpbean.setSsn_age(calbean.getSsn_age());
		tmpbean.setSsn_amount(calbean.getSsn_amount());
		if (calbean.getPartner())
			tmpbean.setPartner(1);
		else
			tmpbean.setPartner(0);
		if (calbean.getPartner_pension())
			tmpbean.setPartner_pension(1);
		else
			tmpbean.setPartner_pension(0);
		tmpbean.setPartner_pension_age(calbean.getPartner_pension_age());
		tmpbean.setPartner_pension_amount(calbean.getPartner_pension_amount());
		if (calbean.getPartner_ssn())
			tmpbean.setPartner_ssn(1);
		else
			tmpbean.setPartner_ssn(0);
		tmpbean.setPartner_ssn_age(calbean.getPartner_ssn_age());
		tmpbean.setPartner_ssn_amount(calbean.getPartner_ssn_amount());
		tmpbean.setDependent(calbean.getDependent());
		tmpbean.setRetirement_level(calbean.getRetirement_level());
		tmpbean.setReturn_rate_before(calbean.getReturn_rate_before());
		tmpbean.setReturn_rate_after(calbean.getReturn_rate_after());
		tmpbean.setInflation_rate(calbean.getInflation_rate());
		tmpbean.setStore_dependent_college_0(calbean
				.getStore_dependent_college_0());
		tmpbean.setStore_dependent_college_1(calbean
				.getStore_dependent_college_1());
		tmpbean.setStore_dependent_college_2(calbean
				.getStore_dependent_college_2());
		tmpbean.setStore_dependent_college_3(calbean
				.getStore_dependent_college_3());
		tmpbean.setStore_dependent_college_4(calbean
				.getStore_dependent_college_4());
		tmpbean.setStore_dependent_wedding_0(calbean
				.getStore_dependent_wedding_0());
		tmpbean.setStore_dependent_wedding_1(calbean
				.getStore_dependent_wedding_1());
		tmpbean.setStore_dependent_wedding_2(calbean
				.getStore_dependent_wedding_2());
		tmpbean.setStore_dependent_wedding_3(calbean
				.getStore_dependent_wedding_3());
		tmpbean.setStore_dependent_wedding_4(calbean
				.getStore_dependent_wedding_4());

		int cur_retirement_age = tmpbean.getRetire_age();
		if (cur_retirement_age >= 100)
			return 100;
		int start = tmpbean.getCurage();
		int end = 100;
		if(formBean[formBean.length - 1].getTotal() <= 0 && formBean[formBean.length - 2].getTotal() <= 0){
			start = cur_retirement_age;
		}else if(formBean[formBean.length - 1].getTotal() <= 0 && formBean[formBean.length - 2].getTotal() > 0){
			return cur_retirement_age;
		}else{
			start = tmpbean.getCurage();
			end = cur_retirement_age;
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;

			tmpbean.setRetire_age(mid);
			FormBean[] temp = tmp.calculation(tmpbean);

			if (temp[temp.length - 1].getTotal() <= 0) {
				if (temp[temp.length - 2].getTotal() > 0)
					return mid;
				else
					start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end;
	}
}
