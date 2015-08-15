package databeans;

import java.util.Arrays;

public class Calculation {
	public int runout = -1;
	public long lastyr_income = -1;
	public long total_retired = -1;
	public long retirement_spending = -1;

	public FormBean[] calculation(CalculatorBean cb) {
		double[] indexedFactor = { 14.22, 13.60, 12.71, 12.33, 12.22, 11.64,
				11.20, 10.98, 10.46, 10.21, 9.81, 9.64, 9.09, 8.61, 8.06, 7.62,
				7.26, 6.91, 6.29, 5.92, 5.59, 5.20, 4.87, 4.59, 4.25, 3.91,
				3.59, 3.26, 3.09, 2.95, 2.78, 2.67, 2.59, 2.44, 2.32, 2.23,
				2.13, 2.06, 1.96, 1.94, 1.89, 1.82, 1.73, 1.64, 1.56, 1.47,
				1.40, 1.36, 1.35, 1.32, 1.26, 1.21, 1.16, 1.11, 1.09, 1.10,
				1.08, 1.04, 1.01, 1.00, 1.00, 1.00 };
		// 1954-2015 used to calculate the social security benefits

		int cur_age = cb.getCurage();
		FormBean[] fb = new FormBean[101 - cur_age];
		int retire_age = cb.getRetire_age();
		long cur_saving = cb.getMoney_saved();
		long cur_income = cb.getIncome();
		int saving_rate = cb.getSaving_rate();
		int income_increase = cb.getIncome_increase_rate();
		int retire_level = cb.getRetirement_level();
		int investment_before = cb.getReturn_rate_before();
		int investment_after = cb.getReturn_rate_after();
		int inflation_rate = cb.getInflation_rate();
		int pension_age = cb.getPension_age();
		long pension = cb.getPension() ? cb.getPension_amount() : 0;
		int partner_pension_age = cb.getPartner_pension_age();
		long partner_pension = cb.getPartner_pension() ? cb
				.getPartner_pension_amount() : 0;
		int ssn_age = cb.getSsn_age();
		long ssn = cb.getSsn() ? cb.getSsn_amount() : 0;
		int partner_ssn_age = cb.getPartner_ssn_age();
		long partner_ssn = cb.getPartner_ssn() ? cb.getPartner_ssn_amount() : 0;

		int[] age_array = get_age_array(cur_age);

		long[] income_array = get_income_array(cur_income, income_increase,
				cur_age, retire_age, age_array.length, retire_level);

		// education
		int[] arr_college = new int[5];
		arr_college[0] = cb.getStore_dependent_college_0();
		arr_college[1] = cb.getStore_dependent_college_1();
		arr_college[2] = cb.getStore_dependent_college_2();
		arr_college[3] = cb.getStore_dependent_college_3();
		arr_college[4] = cb.getStore_dependent_college_4();

		// wedding
		int[] arr_wedding = new int[5];
		arr_wedding[0] = cb.getStore_dependent_wedding_0();
		arr_wedding[1] = cb.getStore_dependent_wedding_1();
		arr_wedding[2] = cb.getStore_dependent_wedding_2();
		arr_wedding[3] = cb.getStore_dependent_wedding_3();
		arr_wedding[4] = cb.getStore_dependent_wedding_4();

		// assume 18 college, 28 married
		int[] arr_index_college = new int[5];
		int[] arr_index_wedding = new int[5];
		int j = 0;
		for (int i = 0; i < 5; i++) {
			if (arr_college[i] >= 0) {
				
				if(18 - arr_college[i] >= 0) arr_index_college[j] = 18 - arr_college[i];
				else arr_index_college[j] = -1;
			} else {
				arr_index_college[j] = -1;
			}
			j++;
		}

		j = 0;
		for (int i = 0; i < 5; i++) {
			if (arr_wedding[i] >= 0) {
				
				if(28 - arr_wedding[i] >= 0) arr_index_wedding[j] = 28 - arr_wedding[i];
				else arr_index_wedding[j] = -1;
			} else {
				arr_index_wedding[j] = -1;
			}
			j++;
		}

		long[] pension_array = get_pension_array(age_array.length,
				100 - pension_age, pension);

		// var ssn =
		// getSocialSecurityBenefits(income_array.length,indexedFactor,income_array);
		long[] ssn_array = get_ssn_array(age_array.length, 100 - ssn_age, ssn);

		long[] partner_pension_array = get_partner_pension_array(
				age_array.length, 100 - partner_pension_age, partner_pension);

		// var ssn_partner =
		// getSocialSecurityBenefits(income_array.length,indexedFactor,income_array);
		long[] partner_ssn_array = get_partner_ssn_array(age_array.length,
				100 - partner_ssn_age, partner_ssn);
		long[] savings_array = get_savings_array(income_array, saving_rate,
				retire_age - cur_age, pension_array, ssn_array,
				partner_pension_array, partner_ssn_array);
		// var mktgain_array =
		// init_array(age_array.length,(cur_saving+savings_array[0]) *
		// investment_before);
		long[] investment_gain_array = init_array(age_array.length,
				((cur_saving + savings_array[0]) * investment_before) / 100);
		long[] spending_array = get_spending_array(age_array.length,
				arr_index_college, arr_index_wedding);
		long[] net_array = init_array(age_array.length, savings_array[0]);
		long[] total_array = init_array(age_array.length, cur_saving
				+ net_array[0]);
		long[] saving_array = get_saving_array(cur_age, retire_age, income_increase, cur_income, saving_rate);
		
		// make a loop from 0 to the length of age_array, compute all the things
		long temp = income_array[retire_age - cur_age - 2];
		for (int i = 0; i < age_array.length; i++) {
			if (i == 0) {
				FormBean fb0 = new FormBean();
				fb0.setAge(cur_age + 1);
				fb0.setBeginretirementbalance(cur_saving);
				fb0.setInvestmentgrowth(Math.round((double) (fb0
						.getBeginretirementbalance() * investment_before)
						/ (double) 100));
				long f0_ssn = 0;
				if (cur_age + 1 >= pension_age)
					f0_ssn += pension;
				if (cur_age + 1 >= partner_pension_age)
					f0_ssn += partner_pension;
				if (cur_age + 1 >= ssn_age)
					f0_ssn += ssn;
				if (cur_age + 1 >= partner_ssn_age)
					f0_ssn += partner_ssn;
				fb0.setSsn(f0_ssn);
				fb0.setSaving(Math.round((double) (cur_income * saving_rate)
						/ (double) 100));
				fb0.setRetirementspend(0);
				fb0.setAccountspending(0);
				fb0.setTotal(fb0.getBeginretirementbalance()
						+ fb0.getInvestmentgrowth() + fb0.getSaving()
						+ fb0.getSsn());
				fb[0] = fb0;
			} else {
				if (i + 1 + cur_age == retire_age) {
					if (total_retired == -1) {
						total_retired = total_array[i];
					}
				}
				if (i + 1 + cur_age > retire_age) {
					spending_array[i] = (temp * retire_level) / 100;
					temp = Math.round((double) temp * (100 + inflation_rate)
							/ (double) 100);

				}
				// we need to calculate
				// mktgain_array[i] =
				// compute_gain(total_array[i-1],EI,FI,retire_age-i-cur_age); //
				// compute the mkt gain
				investment_gain_array[i] = compute_gain(total_array[i - 1],
						investment_before, investment_after, retire_age - i
								- cur_age); // compute the mkt gain
				savings_array[i] = investment_gain_array[i] + savings_array[i];
				net_array[i] = savings_array[i] - spending_array[i]; // this is
																		// the
																		// net

				if (total_array[i - 1] + net_array[i] <= 0)
					total_array[i] = 0;
				else
					total_array[i] = total_array[i - 1] + net_array[i]; // this
																		// is
																		// the
																		// total

				FormBean newbean = new FormBean();
				newbean.setAge(cur_age + i + 1);
				newbean.setBeginretirementbalance(total_array[i - 1]);
				newbean.setInvestmentgrowth(investment_gain_array[i]);
				long cur_ssn = 0;
				if (i + 1 + cur_age >= pension_age)
					cur_ssn += pension;
				if (i + 1 + cur_age >= partner_pension_age)
					cur_ssn += partner_pension;
				if (i + 1 + cur_age >= ssn_age)
					cur_ssn += ssn;
				if (i + 1 + cur_age >= partner_ssn_age)
					cur_ssn += partner_ssn;
				newbean.setSsn(cur_ssn);
				newbean.setSaving(saving_array[i]);
				newbean.setRetirementspend(spending_array[i]);
				if(total_array[i - 1] + cur_ssn + investment_gain_array[i] >= spending_array[i]) newbean.setAccountspending(spending_array[i]);
				else newbean.setAccountspending(total_array[i - 1] + cur_ssn + investment_gain_array[i]);
				newbean.setTotal(total_array[i]);
				fb[i] = newbean;
				if (total_array[i] == 0 && runout == -1) {
					runout = cur_age + i;
				}
			}

		}
		if (runout == -1)
			runout = 100;

//		for (int i = 0; i < fb.length; i++) {
//			System.out.println("total_array[" + i
//					+ "]                                 " + total_array[i]);
//			System.out.println("pension_array[" + i
//					+ "]                               " + pension_array[i]);
//			System.out.println("ssn_array[" + i
//					+ "]                                   " + ssn_array[i]);
//			System.out.println("partner_pension_array[" + i
//					+ "]                       " + partner_pension_array[i]);
//			System.out.println("partner_ssn_array[" + i
//					+ "]                           " + partner_ssn_array[i]);
//			System.out.println("savings_array[" + i
//					+ "]                               " + savings_array[i]);
//			System.out.println("investment_gain_array[" + i
//					+ "]                       " + investment_gain_array[i]);
//			System.out.println("spending_array[" + i
//					+ "]                              " + spending_array[i]);
//			System.out.println("net_array[" + i
//					+ "]                                   " + net_array[i]);
//			System.out.println("income_array[" + i
//					+ "]                                " + income_array[i]);
//		}
		return fb;
	}

	private long[] get_saving_array(int cur_age, int retire_age, int income_increase, long cur_income, int saving_rate) {
		long[] savings = new long[100 - cur_age + 1];
		savings[0] = Math.round((double) (cur_income * saving_rate)/(double)100);
		for(int i = 1; i <= 100 - cur_age; i++){
			cur_income = Math.round((double) (cur_income * (100 + income_increase))/ (double) 100);
			if(i + cur_age < retire_age){
				savings[i] = Math.round((double) (cur_income * saving_rate)/(double)100);
			}else{
				savings[i] = 0;
			}
		}
		return savings;
	}

	// compute investment earning
	private long compute_gain(long last_total, int investment_before,
			long investment_after, int till_retire) {

		if (till_retire > 0) {

			return (last_total * investment_before) / 100;
		} else {
			return (last_total * investment_after) / 100;
		}
	}

	// get spending array from the education and wedding
	private long[] get_spending_array(int len, int[] arr_index_college,
			int[] arr_index_wedding) {
		long[] arr = new long[len];
		arr = init_array(len, 0);

		for (int i = 0; i < arr_index_college.length; i++) {
			int temp = arr_index_college[i];
			if (temp == -1)
				continue;
			// four years
			for (int k = 0; k < 4; k++) {
				System.out.println("temp" + temp);
				arr[temp] += 30000;
				temp++;
			}
		}

		for (int i = 0; i < arr_index_wedding.length; i++) {
			int temp = arr_index_wedding[i];
			if (temp == -1)
				continue;
			arr[temp] += 27000;
		}

		return arr;
	}

	// init the gain_array, make the array the
	private long[] init_array(int len, long init_value) {
		long[] arr = new long[len];
		arr[0] = init_value;
		for (int i = 1; i < len; i++) {
			arr[i] = 0;
		}
		return arr;
	}

	// get the saving array

	private long[] get_savings_array(long[] income_array, int saving_rate,
			int age, long[] pension_array, long[] ssn_array,
			long[] partner_pension_array, long[] partner_ssn_array) {
		long[] arr = new long[income_array.length];
		for (int i = 0; i < income_array.length; i++) {
			if (i <= age) {
				arr[i] = Math.round((double) (income_array[i] * saving_rate)
						/ (double) 100);
			} else {
				arr[i] = 0;
			}
		}

		for (int i = 0; i < income_array.length; i++) {
			arr[i] = arr[i] + pension_array[i];
		}

		for (int i = 0; i < income_array.length; i++) {
			arr[i] = arr[i] + ssn_array[i];
		}

		for (int i = 0; i < income_array.length; i++) {
			arr[i] = arr[i] + partner_pension_array[i];
		}

		for (int i = 0; i < income_array.length; i++) {
			arr[i] = arr[i] + partner_ssn_array[i];
		}

		return arr;
	}

	// return the array of age
	private int[] get_age_array(int cur_age) {
		int[] arr = new int[101 - cur_age];
		for (int i = cur_age; i <= 100; i++) {
			arr[i - cur_age] = i; // a[0] = 35;
		}

		return arr;
	}

	// get the array of income
	private long[] get_income_array(long cur_income, int income_increase,
			int cur_age, int retire_age, int len, int retire_level) {
		long[] arr = new long[len];

		for (int i = 0; i < len; i++) {
			if (i + 1 + cur_age < retire_age) {
				// not retire
				if (i == 0) {
					// the first year
					arr[i] = cur_income;
				} else {
					arr[i] = Math
							.round((double) ((100 + income_increase) * arr[i - 1])
									/ (double) 100);
				}
				if (i + cur_age + 1 == retire_age - 1) {
					if (lastyr_income == -1)
						lastyr_income = arr[i];
					if (retirement_spending == -1)
						retirement_spending = (retire_level * arr[i]) / 100;
				}

			} else {
				arr[i] = 0;
			}
		}
		return arr;
	}

	private double getSocialSecurityBenefits(int len1, double[] indexedFactor,
			long[] income_array) {

		int len = indexedFactor.length;
		double[] earning = new double[len];
		int j = 0;
		for (int i = len - len1; i < len; i++) {
			earning[j] = indexedFactor[i] * income_array[j];
			j++;
		}
		int len2 = earning.length;
		double AIME = 0;
		double PIA = 0;
		Arrays.sort(earning);

		for (int i = 0; i < earning.length - 1; i++) {
			for (int k = i + 1; k < earning.length; k++) {
				if (earning[i] < earning[k]) {
					double temp = earning[i];
					earning[i] = earning[k];
					earning[k] = temp;
				}
			}
		}

		double total = 0;
		if (len2 >= 35) {
			for (int i = earning.length - 1; i >= earning.length - 35; i--)
				total += earning[i];
			AIME = total / (35 * 12);
		} else {
			for (int i = 0; i < earning.length; i++)
				total += earning[i];
			AIME = total / (35 * 12);
		}

		if (AIME <= 816) {
			PIA = AIME * 0.9;
		}
		if (AIME > 816 && AIME <= 4101) {
			PIA = (AIME - 816) * 0.32 + 606 * 0.9;
		} else {
			PIA = (AIME - 4101) * 0.15 + (3653 - 606) * 0.32 + 606 * 0.9;
		}

		return PIA;

	}

	// get pension array
	private long[] get_pension_array(int len, int actuallen, long pension) {
		long[] arr = new long[len];
		for (int i = 0; i < len; i++) {
			if (i < len - actuallen)
				arr[i] = 0; // a[0] = 0;
			else
				arr[i] = pension * 12;
		}

		return arr;

	}

	// get ssn array
	private long[] get_ssn_array(int len, int actuallen, long ssn) {
		long[] arr = new long[len];
		for (int i = 0; i < len; i++) {
			if (i < len - actuallen)
				arr[i] = 0; // a[0] = 0;
			else
				arr[i] = ssn * 12;
		}

		return arr;

	}

	// get partner pension array
	private long[] get_partner_pension_array(int len, int actuallen,
			long pension) {
		long[] arr = new long[len];
		for (int i = 0; i < len; i++) {
			if (i < len - actuallen)
				arr[i] = 0; // a[0] = 0;
			else
				arr[i] = pension * 12;
		}

		return arr;

	}

	// get partner ssn array
	private long[] get_partner_ssn_array(int len, int actuallen, long ssn) {
		long[] arr = new long[len];
		for (int i = 0; i < len; i++) {
			if (i < len - actuallen)
				arr[i] = 0; // a[0] = 0;
			else
				arr[i] = ssn * 12;
		}

		return arr;

	}
}
