//this is the algorithm that Jeff povided

finalResult();


function finalResult(){
	var indexFactor = [];
	//1954-2015 used to calculate the social security benefits
	indexedFactor = [14.22, 13.60, 12.71,12.33,12.22,11.64,11.20,10.98,10.46,10.21,9.81,9.64,9.09,8.61,
	               8.06,7.62,7.26,6.91,6.29,5.92,5.59,5.20, 4.87, 4.59,4.25,3.91,3.59,3.26,3.09,2.95,2.78,
	               2.67,2.59,2.44,2.32,2.23,2.13,2.06,1.96,1.94,1.89,1.82,1.73,
	               1.64,1.56,1.47,1.40,1.36,1.35,1.32,1.26,1.21,1.16,1.11,1.09,1.10,1.08,1.04,1.01,1.00,1.00,1.00];
	
	var cur_age = Number(document.getElementById("store_cur_age").value);
	var retire_age = Number(document.getElementById("store_retire_age").value);

	var expect_life = 100; // assume he can live to 100
	var cur_income = Number(document.getElementById("store_income").value);
	
	var income_increase =  Number(document.getElementById("store_income_increase_rate").value);
	var saving_rate = Number(document.getElementById("store_saving_rate").value);
	var cur_saving =  Number(document.getElementById("store_money_saved").value);
	
	var retire_level = Number(document.getElementById("store_retirement_level").value);
	//var EI = 0.08;
	//var FI = 0.04;
	var investment_before = Number(document.getElementById("store_investment_before").value);
	var investment_after = Number(document.getElementById("store_investment_after").value);
	var inflation_rate = Number(document.getElementById("store_inflation_rate").value);
	
	console.log("cur_age                    " + cur_age);
	console.log("retire_age                 " + retire_age);
	console.log("cur_income                 " + cur_income);
	console.log("income_increase            " + income_increase);
	console.log("saving_rate                " + saving_rate);
	console.log("cur_saving                 " + cur_saving);
	console.log("retire_level               " + retire_level);
	console.log("investment_before          " + investment_before);
	console.log("investment_after           " + investment_after);
	console.log("inflation_rate             " + inflation_rate);
	
	var age_array = get_age_array(cur_age,expect_life);
	
	var income_array = get_income_array(cur_income,income_increase,cur_age,retire_age,age_array.length);
	
	//education
	var arr_college = [];
	arr_college[0] = Number(document.getElementById("store_dependent_college_0").value);
	arr_college[1] = Number(document.getElementById("store_dependent_college_1").value);
	arr_college[2] = Number(document.getElementById("store_dependent_college_2").value);
	arr_college[3] = Number(document.getElementById("store_dependent_college_3").value);
	arr_college[4] = Number(document.getElementById("store_dependent_college_4").value);
	
	
	//wedding
	var arr_wedding = [];
	arr_wedding[0] = Number(document.getElementById("store_dependent_wedding_0").value);
	arr_wedding[1] = Number(document.getElementById("store_dependent_wedding_1").value);
	arr_wedding[2] = Number(document.getElementById("store_dependent_wedding_2").value);
	arr_wedding[3] = Number(document.getElementById("store_dependent_wedding_3").value);
	arr_wedding[4] = Number(document.getElementById("store_dependent_wedding_4").value);
	
	//assume 18 college, 28 married
	var arr_index_college = [];
	var arr_index_wedding = [];
	var j = 0;
	for (var i = 0; i < 5; i++) {
		if (arr_college[i] >= 0) {
			arr_index_college[j] = 18 - arr_college[i];
		    j++;
		}
	}
	
	j = 0;
	for (var i = 0; i < 5; i++) {
		if (arr_wedding[i] >= 0) {
			arr_index_wedding[j] = 28 - arr_wedding[i];
		    j++;
		}
	}
	

	var run_out_age = Number(0);
	var flag1 = 0;
	
	
	var pension_age;
	var pension;
	var p = document.getElementById("store_pension");
	if (p.value == '1') {
		pension_age = Number(document.getElementById("store_pension_age").value);
		pension = Number(document.getElementById("store_pension_amount").value);
	} else {
		pension_age = 0;
		pension = 0;
	}
	
	var ssn_age;
	var ssn;
	var s = document.getElementById("store_eligible_SSN");
	if (s.value == '1') {
		ssn_age = Number(document.getElementById("store_SSN_age").value);
		ssn = getSocialSecurityBenefits(retire_age - cur_age,indexedFactor,income_array);
	} else {
		ssn_age = 0;
		ssn = 0;
	}
	
	var partner_pension;
	var partner_ssn;
	var partner_pension_age;
	var partner_pension_amount;
	var partner_ssn_age;
	var partner_ssn_amount;
	
	var parter_eligible = document.getElementById("store_partner_eligible");
	if (parter_eligible.value == '1') {
		partner_pension = document.getElementById("store_partner_pension");
		if (partner_pension.value == '1') {
			partner_pension_age = Number(document.getElementById("store_partner_pension_age").value);
			partner_pension_amount = Number(document.getElementById("store_partner_pension_amount").value);
		} else {
			partner_pension_age = 0;
			partner_pension_amount = 0;
		}
		
		
		partner_ssn = document.getElementById("store_partner_eligible_SSN");
		if (partner_ssn.value == '1') {
			partner_ssn_age = Number(document.getElementById("store_partner_SSN_age").value);
			partner_ssn_amount = getSocialSecurityBenefits(retire_age - cur_age,indexedFactor,income_array);
			//partner_ssn_amount = Number(document.getElementById("store_partner_SSN_amount").value);
		} else {
			partner_ssn_age = 0;
			partner_ssn_amount = 0;
		}
	    
	} else {
		partner_pension_age = 0;
		partner_pension_amount = 0;
		partner_ssn_age = 0;
		partner_ssn_amount = 0;
		
	}
	
	
	
	
	
	
	var pension_array = get_pension_array(age_array.length,expect_life-pension_age,pension);
	
	//var ssn = getSocialSecurityBenefits(income_array.length,indexedFactor,income_array);
	var ssn_array = get_ssn_array(age_array.length,expect_life-ssn_age,ssn);
	
	var partner_pension_array = get_partner_pension_array(age_array.length,expect_life-partner_pension_age,partner_pension_amount);
	
	//var ssn_partner = getSocialSecurityBenefits(income_array.length,indexedFactor,income_array);
	var partner_ssn_array = get_partner_ssn_array(age_array.length,expect_life-partner_ssn_age,partner_ssn_amount);
	var savings_array = get_savings_array(income_array, saving_rate,retire_age-cur_age,pension_array,ssn_array,partner_pension_array,partner_ssn_array);
	//var mktgain_array = init_array(age_array.length,(cur_saving+savings_array[0]) * investment_before);
	var investment_gain_array = init_array(age_array.length,(cur_saving+savings_array[0]) * investment_before);
	var pension_array = get_pension_array(age_array.length,expect_life-pension_age,pension);
	var spending_array = get_spending_array(age_array.length,arr_index_college,arr_index_wedding);
	var net_array = init_array(age_array.length,savings_array[0]);
	var total_array = init_array(age_array.length,cur_saving+net_array[0]);
	
	
	var result_list = []; //this is the result that need to return
	
	
	//make a loop from 0 to the length of age_array, compute all the things
	var temp = income_array[retire_age - cur_age-1];
	for(var i = 0; i <age_array.length; i++){
		
		if(i > 0){
			if(i+ cur_age >= retire_age){
				spending_array[i] = temp * retire_level;
				temp = temp * (inflation_rate + 1);
			}
			//we need to calculate
			//mktgain_array[i] = compute_gain(total_array[i-1],EI,FI,retire_age-i-cur_age); // compute the mkt gain
			investment_gain_array[i] = compute_gain(total_array[i-1],investment_before,investment_after,retire_age-i-cur_age); // compute the mkt gain
			savings_array[i] = investment_gain_array[i] + savings_array[i];
			net_array[i] = savings_array[i]-spending_array[i]; // this is the net
			
			if ( total_array[i-1]+net_array[i] < 0)
				total_array[i] = 0;
			else
			total_array[i] = total_array[i-1]+net_array[i]; // this is the total
		}
		
		
		
		
		
		
		var item=[]; // this is one small item
		item[0] = age_array[i];// 0 - age
		item[1] = savings_array[i];// 1 -savings
		item[2] = spending_array[i]; // 2 - spendings
		item[3] = total_array[i]; // 3 - total

		
		
		result_list[i] = item; 
	}
	
//	console.log(income_array);
//	console.log(income_array.length);
//	console.log(age_array);
//	console.log(age_array.length);
//	console.log(savings_array);
//	console.log(savings_array.length);
//	console.log(net_array);
//	console.log(total_array);
//	console.log(total_array.length);
//	console.log(pension_array);
//	console.log(ssn_array);
//	console.log(partner_pension_array);
//	console.log(partner_ssn_array);
//	console.log(spending_array);
//	console.log(investment_before);
//	console.log(investment_after);
//	console.log(investment_gain_array);
//	console.log(net_array);
//	console.log(total_array);
	return result_list;
}

/*function compute_gain(last_total,EI,FI,till_retire){
	//7,3  5,5  
	if(till_retire -5 > 0){
		//7 - EI
		return last_total*0.7*EI+ last_total*0.3*FI;
	}else{
		return last_total*0.5*EI+ last_total*0.5*FI;
	}
}*/
//compute investment earning 
function compute_gain(last_total,investment_before,investment_after,till_retire){
	
	if(till_retire  > 0){
		
		return last_total*investment_before;
	}else{
		return last_total*investment_after;
	}
}


//get spending array from the education and wedding
function get_spending_array(len,arr_index_college,arr_index_wedding){
	var arr = [];
	arr = init_array(len,0);
	
	for (var i = 0; i < arr_index_college.length; i++) {
	    var temp = arr_index_college[i];
	    //four years
	    for (var k = 0; k < 4; k++) {
		    arr[temp] += 30000;
	        temp++;
	    }
	}
	
	for (var i = 0; i < arr_index_wedding.length; i++) {
		arr[arr_index_wedding[i]] += 27000;
	}
	
	return arr;
}




//init the gain_array, make the array the 
function init_array(len,init_value){
	var arr = [];
	arr[0] = init_value;
	for(var i = 1; i < len; i++){
		arr[i] = 0;
	}
	return arr;
}



//get the saving array

function get_savings_array(income_array, saving_rate,age,pension_array,ssn_array,partner_pension_array,partner_ssn_array){
	var arr = [];
	for(var i = 0; i < income_array.length; i++){
		if(i <= age ){
			arr[i] = income_array[i]*saving_rate;
		}else{
			arr[i] = 0;
		}
	}
	
	for (var i = 0; i < income_array.length;i++) {
		arr[i] = arr[i] + pension_array[i];
	}
	
	
	for (var i = 0; i < income_array.length;i++) {
		arr[i] = arr[i] + ssn_array[i];
	}
	
	for (var i = 0; i < income_array.length;i++) {
		arr[i] = arr[i] + partner_pension_array[i];
	}
	
	
	for (var i = 0; i < income_array.length;i++) {
		arr[i] = arr[i] + partner_ssn_array[i];
	}
	
	
	
	return arr;
}


//return the array of age
function get_age_array(cur_age,expect_life){
	var arr = [];
	for(var i = cur_age; i <= expect_life; i++){
		arr[i - cur_age] = i; // a[0] = 35;
	}
	
	return arr;
}

//get the array of income
function get_income_array(cur_income,income_increase,cur_age,retire_age,len){
	var arr = [];
	var work_year = retire_age - cur_age;
	for(var i=0; i < len; i++ ){
		if(i + cur_age < retire_age){
			//not retire
			if(i == 0){
				//the first year
				arr[i] = cur_income;
			}else{
				arr[i] = arr[i - 1]*(1+income_increase);
			}
		}else{
			arr[i] = 0;
		}
	}
	return arr;
}

function getSocialSecurityBenefits(len1,indexedFactor,income_array) {
	
	var len = indexedFactor.length;
	console.log(len);
	var earning = [];
	var j = 0;
    for (var i = len - len1 ; i < len; i++) {
	    earning[j] = indexedFactor[i] * income_array[j];
	    j++;
    }
    console.log(earning);
    var len2 = earning.length;
    var AIME = 0;
    var PIA = 0;
    earning.sort(sortNumber);
    console.log(earning);
    var total = 0;
    if (len2 >= 35) {
    	for (var  i = earning.length - 1; i >= earning.length - 35; i--)
    	      total += earning[i];
    	AIME = total/(35*12);
    } else {
    	for (var i = 0; i < earning.length; i++)
    		 total += earning[i];
    	AIME  = total/(35*12);
    }
    
    if (AIME <= 816) {
		PIA = AIME * 0.9;
	} if (AIME > 816 && AIME <= 4101) {
		PIA = (AIME - 816) * 0.32 + 606 * 0.9;
	} else {
		PIA = (AIME - 4101) * 0.15 + (3653 - 606) * 0.32 + 606 * 0.9;
	}
    
	
    console.log(PIA);
    return PIA;
    

}

function sortNumber(a,b) {
    return a - b;
}

//get pension array
function get_pension_array(len,actuallen,pension){
	var arr = [];
	for(var i = 0; i < len; i++){
		if (i < len - actuallen )
		    arr[i] = 0; // a[0] = 0;
		else
	        arr[i] = pension * 12;
	} 
		
	return arr;
	
}

//get ssn array
function get_ssn_array(len,actuallen,ssn){
	var arr = [];
	for(var i = 0; i < len; i++){
		if (i < len - actuallen )
		    arr[i] = 0; // a[0] = 0;
		else
	        arr[i] = ssn * 12;
	} 
		
	return arr;
	
}


//get partner pension array
function get_partner_pension_array(len,actuallen,pension){
	var arr = [];
	for(var i = 0; i < len; i++){
		if (i < len - actuallen )
		    arr[i] = 0; // a[0] = 0;
		else
	        arr[i] = pension * 12;
	} 
		
	return arr;
	
}

//get partner ssn array
function get_partner_ssn_array(len,actuallen,ssn){
	var arr = [];
	for(var i = 0; i < len; i++){
		if (i < len - actuallen )
		    arr[i] = 0; // a[0] = 0;
		else
	        arr[i] = ssn * 12;
	} 
		
	return arr;
	
}


