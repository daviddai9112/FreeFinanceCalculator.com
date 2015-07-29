/*
Team 5
Task 7
Date: Jan. 28, 2015
Only for educational use
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import formbeans.CalculatorForm;

public class CreateFormAction extends Action {
	private FormBeanFactory<CalculatorForm> formBeanFactory = FormBeanFactory
			.getInstance(CalculatorForm.class);
	//private UserDAO userDAO;

	public CreateFormAction(Model model) {
		//userDAO = model.getUserDAO();
	}

	public String getName() {
		return "create_form.do";
	}

	public String perform(HttpServletRequest request) {
//		EmployeeBean employ = (EmployeeBean) request.getSession(false)
//				.getAttribute("employee");
//		if (employ == null) {
//			return "employee_login.do";
//		}
		try {

			List<String> errors = new ArrayList<String>();
			request.setAttribute("errors", errors);

			CalculatorForm form = (CalculatorForm) formBeanFactory.create(request);

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
			
//			UserBean user = new UserBean();
//			user.setAge(Integer.parseInt(form.getAge()));
//			user.setRetirementAge(Integer.parseInt(form.getRetirementAge()));
//			user.setSaving(Long.parseLong(form.getSaving()));
//			user.setRate(Integer.parseInt(form.getRate()));

			//userDAO.create(user);

//			request.setAttribute("msg",
//					"Customer account for " + user.getUserId()
//							+ " has been created");
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
		}

		return "finance_calculator.html";

	}
}
