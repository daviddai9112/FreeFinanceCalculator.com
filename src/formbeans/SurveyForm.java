package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SurveyForm extends FormBean {

	private String[] surveyq1;
	private String[] surveyq2;
	private String surveyq3;
	private String surveyq4;
	private String email;

	public String[] getSurveyq1() {
		return surveyq1;
	}

	public void setSurveyq1(String[] s) {
		surveyq1 = s;
	}

	public String[] getSurveyq2() {
		return surveyq2;
	}

	public void setSurveyq2(String[] s) {
		surveyq2 = s;
	}

	public String getSurveyq3() {
		return surveyq3;
	}

	public void setSurveyq3(String s) {
		surveyq3 = s;
	}

	public String getSurveyq4() {
		return surveyq4;
	}

	public void setSurveyq4(String s) {
		surveyq4 = s;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String s) {
		email = s;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (surveyq1 == null || surveyq1.length == 0)
			errors.add("Question 1 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq2 == null || surveyq2.length == 0)
			errors.add("Question 2 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq3 == null || surveyq3.length() == 0)
			errors.add("Question 3 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq4 == null || surveyq4.length() == 0)
			errors.add("Question 4 is required");
		return errors;

	}
}
