package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CalculatorDAO;
import model.Model;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

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

			// UserBean[] cb = userDAO.match(MatchArg.equals("userid",
			// form.getEmail()));
			// if (cb.length != 0) {
			// errors.add("Email already exists.");
			// return "employee_createcustomer.jsp";
			// }

			System.out.println(form.getMoneysaved());
			System.out.println(form.getIncome());
			System.out.println(form.getCurage());
			System.out.println(form.getRetireage());
			System.out.println(form.getSavingrate());
			System.out.println(form.getIncomeincreaserate());
			System.out.println(form.getPensionage());
			System.out.println(form.getPensionamount());
			System.out.println(form.getSsnage());
			System.out.println(form.getSsnamount());
			System.out.println(form.getPartnerpensionamount());
			System.out.println(form.getPartnerSSNage());
			System.out.println(form.getPartnerSSNamount());
			System.out.println(form.getDependent());
			System.out.println(form.getPartnerpensionage());

			CalculatorBean calbean = new CalculatorBean();
			calbean.setUserId(5);
			calbean.setMoney_Saved(Long.parseLong(form.getMoneysaved()));
			calbean.setIncome(Long.parseLong(form.getIncome()));
			calbean.setCur_Age(Integer.parseInt(form.getCurage()));
			calbean.setRetire_Age(Integer.parseInt(form.getRetireage()));

			double savingrate = Double.parseDouble(form.getSavingrate());
			calbean.setSaving_Rate((int) (savingrate * 100));

			double incomeincreaserate = Double.parseDouble(form
					.getIncomeincreaserate());
			calbean.setIncome_Increase_Rate((int) (incomeincreaserate * 100));

			calbean.setPension_Age(Integer.parseInt(form.getPensionage()));
			calbean.setPension_Amount(Long.parseLong(form.getPensionamount()));
			calbean.setSSN_Age(Integer.parseInt(form.getSsnage()));
			calbean.setSSN_Amount(Long.parseLong(form.getSsnamount()));
			calbean.setPartner_Pension_Amount(Long.parseLong(form
					.getPartnerpensionamount()));
			calbean.setPartner_SSN_Age(Integer.parseInt(form.getPartnerSSNage()));
			calbean.setPartner_SSN_Amount(Long.parseLong(form
					.getPartnerSSNamount()));
			calbean.setDependent(Integer.parseInt(form.getDependent()));
			calbean.setPartner_Pension_Age(Integer.parseInt(form
					.getPartnerpensionage()));

			calDAO.create(calbean);

			//test
			CalculatorBean test = new CalculatorBean();
			test.setMoney_Saved(1000);
			test.setIncome(110000);
			test.setCur_Age(25);
			test.setRetire_Age(67);
			test.setSaving_Rate(15);
			test.setIncome_Increase_Rate(2);
			test.setRetirement_Level(90);
			test.setInvestment_Rate_Before(7);
			test.setInvestment_Rate_After(4);
			test.setInflate_Rate(3);
			
			FormBean[] formBean = calculation(test);
			for(int i = 0; i < formBean.length; i++){
				System.out.print(formBean[i].getAge());
				System.out.print("    ");
				System.out.print(formBean[i].getBeginretirementbalance());
				System.out.print("    ");
				System.out.print(formBean[i].getInvestmentgrowth());
				System.out.print("    ");
				System.out.print(formBean[i].getSaving());
				System.out.print("    ");
				System.out.print(formBean[i].getRetirementspend());
				System.out.print("    ");
				System.out.print(formBean[i].getAccountspending());
				System.out.print("    ");
				System.out.print(formBean[i].getTotal());
				System.out.println("");
			}
			request.setAttribute("formBeans", formBean);
			request.setAttribute("income_rate", test.getSaving_Rate());
			request.setAttribute("retirement_level", test.getRetirement_Level());
			request.setAttribute("run_out", new Integer(runout));
			request.setAttribute("lastyr_income", new Long(lastyr_income));
			request.setAttribute("total_retired", new Long(total_retired));
			total_retired = -1;
			runout = -1;
			lastyr_income = -1;
			return "Report.jsp";
			// UserBean user = new UserBean();
			// user.setAge(Integer.parseInt(form.getAge()));
			// user.setRetirementAge(Integer.parseInt(form.getRetirementAge()));
			// user.setSaving(Long.parseLong(form.getSaving()));
			// user.setRate(Integer.parseInt(form.getRate()));

			// userDAO.create(user);

			// request.setAttribute("msg",
			// "Customer account for " + user.getUserId()
			// + " has been created");
			// SimpleEmail email = new SimpleEmail();

			// email.setTLS(true);
			// email.setSSL(true);
			// email.setHostName("smtp.gmail.com");
			// email.setSmtpPort(465);
			//
			// email.setAuthentication("cfsteam5help@gmail.com", "helphelph");
			// int i = 8;
			// String pwd = "";
			// while (i-- > 0) {
			// int a = (int) (Math.random() * 26) + 'a';
			// char b = (char) a;
			// pwd += b;
			// }
			// customer.setPassword(pwd);

			// System.out.print(pwd);
			// try {
			// email.addTo(customer.getEmail());
			// email.setFrom("cfsteam5help@gmail.com");
			// email.setSubject("Account Create Confirm");
			// email.setCharset("utf-8");
			//
			// email.setContent(new MimeMultipart("text/html"));
			// email.setMsg("Dear " + customer.getFirstName() + "," + "\n" +
			// " Thanks for using Carnegie Financial Service! Your temp-password is:"
			// + pwd + "." + "\n" +
			// "You can change password through this link: http://54.173.57.219:8080/home%20page/");
			// email.send();
			// request.setAttribute("pwd", pwd);
			// } catch (EmailException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} catch (FormBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "finance_calculator.html";

	}

	private FormBean[] calculation(CalculatorBean cb) {
		int age = cb.getCur_Age();
		FormBean[] fb = new FormBean[101 - age];
		int retire_age = cb.getRetire_Age();
		long money_saved = cb.getMoney_Saved();
		long income = cb.getIncome();
		int saving_rate = cb.getSaving_Rate();
		int income_increase_rate = cb.getIncome_Increase_Rate();
		int retirement_level = cb.getRetirement_Level();
		int investment_rate_before = cb.getInvestment_Rate_Before();
		int investment_rate_after = cb.getInvestment_Rate_After();
		int inflate_rate = cb.getInflate_Rate();

		// fb[0]
		FormBean fb0 = new FormBean();
		fb0.setAge(age + 1);
		fb0.setBeginretirementbalance(money_saved);
		fb0.setInvestmentgrowth(Math.round((double) (fb0
				.getBeginretirementbalance() * investment_rate_before)
				/ (double) 100));
		fb0.setSaving(Math
				.round((double) (income * saving_rate) / (double) 100));
		fb0.setRetirementspend(0);
		fb0.setAccountspending(0);
		fb0.setTotal(fb0.getBeginretirementbalance()
				+ fb0.getInvestmentgrowth() + fb0.getSaving());
		fb[0] = fb0;

		for (int i = age + 1; i < retire_age - 1; i++) {
			income = Math
					.round((double) ((100 + income_increase_rate) * income)
							/ (double) 100);
			FormBean temp = fb[i - age - 1];
			FormBean newbean = new FormBean();
			newbean.setAge(i + 1);
			newbean.setBeginretirementbalance(temp.getTotal());
			newbean.setInvestmentgrowth(Math.round((double) (newbean
					.getBeginretirementbalance() * investment_rate_before)
					/ (double) 100));
			newbean.setSaving(Math.round((double) income * saving_rate
					/ (double) 100));
			newbean.setRetirementspend(0);
			newbean.setAccountspending(0);
			newbean.setTotal(newbean.getBeginretirementbalance()
					+ newbean.getInvestmentgrowth() + newbean.getSaving());
			fb[i - age] = newbean;
		}
		income = (100 + income_increase_rate) * income / 100;
		lastyr_income = income;
		long spending = income * retirement_level / 100;
		for (int i = retire_age - 1; i < 101; i++) {
			FormBean temp = fb[i - age - 1];
			if(total_retired == -1) {
				total_retired = temp.getTotal();
			}
			FormBean newbean = new FormBean();
			newbean.setAge(i);
			newbean.setBeginretirementbalance(temp.getTotal());
			newbean.setInvestmentgrowth(Math.round((double) (newbean
					.getBeginretirementbalance() * investment_rate_after)
					/ (double) 100));
			newbean.setSaving(0);
			newbean.setRetirementspend(spending);
			spending = Math.round((double) ((100 + inflate_rate) * spending)
					/ (double) 100);
			newbean.setAccountspending((newbean.getBeginretirementbalance() + newbean
					.getInvestmentgrowth()) > newbean.getRetirementspend() ? newbean
					.getRetirementspend() : (newbean
					.getBeginretirementbalance() + newbean
					.getInvestmentgrowth()));
			newbean.setTotal(newbean.getBeginretirementbalance()
					+ newbean.getInvestmentgrowth()
					- newbean.getAccountspending());
			fb[i - age] = newbean;
			if(newbean.getBeginretirementbalance()
					+ newbean.getInvestmentgrowth()
					- newbean.getAccountspending() == 0 && runout == -1){
				runout = i + 1;
			}
		}
		return fb;
	}
}
