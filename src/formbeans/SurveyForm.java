package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SurveyForm extends FormBean {

	private String[] surveyq1;
	private String[] surveyq2;
	private String[] surveyq3;
	private String[] surveyq4;
	private String[] surveyq5;
	private String[] surveyq6;
	private String[] surveyq7;
	private String[] surveyq8;
	private String[] surveyq9;
	private String surveyq10;

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

	public String[] getSurveyq3() {
		return surveyq3;
	}

	public void setSurveyq3(String[] s) {
		surveyq3 = s;
	}

	public String[] getSurveyq4() {
		return surveyq4;
	}

	public void setSurveyq4(String[] s) {
		surveyq4 = s;
	}

	public String[] getSurveyq5() {
		return surveyq5;
	}

	public void setSurveyq5(String[] s) {
		surveyq5 = s;
	}

	public String[] getSurveyq6() {
		return surveyq6;
	}

	public void setSurveyq6(String[] s) {
		surveyq6 = s;
	}

	public String[] getSurveyq7() {
		return surveyq7;
	}

	public void setSurveyq7(String[] s) {
		surveyq7 = s;
	}

	public String[] getSurveyq8() {
		return surveyq8;
	}

	public void setSurveyq8(String[] s) {
		surveyq8 = s;
	}

	public String[] getSurveyq9() {
		return surveyq9;
	}

	public void setSurveyq9(String[] s) {
		surveyq9 = s;
	}

	public String getSurveyq10() {
		return surveyq10;
	}

	public void setSurveyq10(String s) {
		surveyq10 = s;
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
		
		if (surveyq3 == null || surveyq3.length == 0)
			errors.add("Question 3 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq4 == null || surveyq4.length == 0)
			errors.add("Question 4 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq5 == null || surveyq5.length == 0)
			errors.add("Question 5 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq6 == null || surveyq6.length == 0)
			errors.add("Question 6 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq7 == null || surveyq7.length == 0)
			errors.add("Question 7 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq8 == null || surveyq8.length == 0)
			errors.add("Question 8 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq9 == null || surveyq9.length == 0)
			errors.add("Question 9 is required");
		if (errors.size() > 0)
			return errors;
		
		if (surveyq10 == null || surveyq10.length() == 0)
			errors.add("Question 10 is required");
		return errors;

	}
}
