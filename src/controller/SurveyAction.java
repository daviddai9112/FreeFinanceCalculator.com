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
			String[] q3 = form.getSurveyq3();
			for(int j = 0; j < q3.length; j++){
				sb.append(q3[j]);
				if(j != q3.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ3(sb.toString());
			sb = new StringBuilder();
			System.out.println("3------------------------------");
			
			//Q4
			String[] q4 = form.getSurveyq4();
			for(int j = 0; j < q4.length; j++){
				sb.append(q4[j]);
				if(j != q4.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ4(sb.toString());
			sb = new StringBuilder();
			System.out.println("4------------------------------");
			
			//Q5
			String[] q5 = form.getSurveyq5();
			for(int j = 0; j < q5.length; j++){
				sb.append(q5[j]);
				if(j != q5.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ5(sb.toString());
			sb = new StringBuilder();
			System.out.println("5------------------------------");
			
			//Q6
			String[] q6 = form.getSurveyq6();
			for(int j = 0; j < q6.length; j++){
				sb.append(q6[j]);
				if(j != q6.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ6(sb.toString());
			sb = new StringBuilder();
			System.out.println("6------------------------------");
			
			//Q7
			String[] q7 = form.getSurveyq7();
			for(int j = 0; j < q7.length; j++){
				sb.append(q7[j]);
				if(j != q7.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ7(sb.toString());
			sb = new StringBuilder();
			System.out.println("7------------------------------");
			
			//Q8
			String[] q8 = form.getSurveyq8();
			for(int j = 0; j < q8.length; j++){
				sb.append(q8[j]);
				if(j != q8.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ8(sb.toString());
			sb = new StringBuilder();
			System.out.println("8------------------------------");
			
			//Q9
			String[] q9 = form.getSurveyq9();
			for(int j = 0; j < q9.length; j++){
				sb.append(q9[j]);
				if(j != q9.length - 1) sb.append(",");
			}
			System.out.println(sb.toString());
			surveybean.setQ9(sb.toString());
			sb = new StringBuilder();
			System.out.println("9------------------------------");
			
			//Q10
			String q10 = form.getSurveyq10();
			System.out.println(q10);
			surveybean.setQ10(q10);
			
			surveyDAO.create(surveybean);
			
			
			return "Report.jsp";
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
