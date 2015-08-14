package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.SurveyDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.SurveyBean;
import formbeans.SurveyForm;

public class SurveyAction extends Action {
	private FormBeanFactory<SurveyForm> formBeanFactory = FormBeanFactory
			.getInstance(SurveyForm.class);
	private SurveyDAO surveyDAO;
	public SurveyAction(Model model) {
		surveyDAO = model.getSurveyDAO();
	}

	public String getName() {
		return "survey.do";
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

			SurveyForm form = (SurveyForm) formBeanFactory
					.create(request);

//			if (!form.isPresent())
//				return "Report.jsp";

			errors.addAll(form.getValidationErrors());

			if (errors.size() != 0) {
				return "Report.jsp";
			}
			
			SurveyBean surveybean = new SurveyBean();
			
			//email
			String email = form.getEmail();
			System.out.println("email    " + email);
			surveybean.setEmail(email);
			System.out.println("email------------------------------");
			//Q1
			StringBuilder sb = new StringBuilder();
			String[] q1 = form.getSurveyq1();
			for(int j = 0; j < q1.length; j++){
				sb.append(q1[j]);
				if(j != q1.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ1(sb.toString());
			sb = new StringBuilder();
			System.out.println("1------------------------------");
			
			//Q2
			String[] q2 = form.getSurveyq2();
			for(int j = 0; j < q2.length; j++){
				sb.append(q2[j]);
				if(j != q2.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ2(sb.toString());
			sb = new StringBuilder();
			System.out.println("2------------------------------");
			
			//Q3
			String q3 = form.getSurveyq3();
			System.out.println(q3);
			surveybean.setQ3(q3);
			System.out.println("3------------------------------");
			
			//Q4
			String q4 = form.getSurveyq4();
			System.out.println(q4);
			surveybean.setQ4(q4);
			System.out.println("4------------------------------");

			surveyDAO.create(surveybean);
			
			
			request.setAttribute("message","Thanks for your support, we would contact you if you win the lottery!");
	        return "success.jsp";
		} catch (FormBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Report.jsp";

	}


}
