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
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.UserBean;
import formbeans.RegisterForm;

public class CreateCustomerAction extends Action {
	private FormBeanFactory<RegisterForm> formBeanFactory = FormBeanFactory
			.getInstance(RegisterForm.class);
	private UserDAO userDAO;

	public CreateCustomerAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() {
		return "create_user.do";
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

			RegisterForm form = (RegisterForm) formBeanFactory.create(request);

			if (!form.isPresent())
				return "create_user.jsp";

			errors.addAll(form.getValidationErrors());

			if (errors.size() != 0) {
				return "create_user.jsp";
			}

			// UserBean[] cb = userDAO.match(MatchArg.equals("userid",
			// form.getEmail()));
			// if (cb.length != 0) {
			// errors.add("Email already exists.");
			// return "employee_createcustomer.jsp";
			// }
			
			System.out.println(form.getAge());
			System.out.println(form.getRetirementAge());
			System.out.println(form.getSaving());
			System.out.println(form.getRate());
			
			UserBean user = new UserBean();
			user.setAge(Integer.parseInt(form.getAge()));
			user.setRetirementAge(Integer.parseInt(form.getRetirementAge()));
			user.setSaving(Long.parseLong(form.getSaving()));
			user.setRate(Integer.parseInt(form.getRate()));

			userDAO.create(user);

			request.setAttribute("msg",
					"Customer account for " + user.getUserId()
							+ " has been created");
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
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FormBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "create_user.jsp";

	}
}
