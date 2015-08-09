//this is the algorithm that Jeff povided

finalResult();


function finalResult(){
	var cur_age = Number(document.getElementById("store_cur_age").value);
	var retire_age = Number(document.getElementById("store_retire_age").value);
	var expect_life = 100; // assume he can live to 100
	var cur_income = Number(document.getElementById("store_income").value);
	var income_increase =  Number(document.getElementById("store_income_increase_rate").value);
	var saving_rate = Number(document.getElementById("store_saving_rate").value);
	var cur_saving =  Number(document.getElementById("store_money_saved").value);
	var EI = 0.08;
	var FI = 0.04;
	var retire_level = Number(document.getElementById("store_retirement_level").value);
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
		ssn = Number(document.getElementById("store_SSN_amount").value);
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
			partner_ssn_amount = Number(document.getElementById("store_partner_SSN_amount").value);
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
	
	
	
	
	
	var age_array = get_age_array(cur_age,expect_life);
	var income_array = get_income_array(cur_income,income_increase,cur_age,retire_age,age_array.length);
	var pension_array = get_pension_array(age_array.length,expect_life-pension_age,pension);
	var ssn_array = get_pension_array(age_array.length,expect_life-ssn_age,ssn);
	var partner_pension_array = get_partner_pension_array(age_array.length,expect_life-partner_pension_age,partner_pension_amount);
	var partner_ssn_array = get_partner_ssn_array(age_array.length,expect_life-partner_ssn_age,partner_ssn_amount);
	var savings_array = get_savings_array(income_array, saving_rate,retire_age-cur_age,pension_array,ssn_array,partner_pension_array,partner_ssn_array);
	var mktgain_array = init_array(age_array.length,0);
	var spending_array = get_spending_array(age_array.length);
	var net_array = init_array(age_array.length,savings_array[0]);
	var total_array = init_array(age_array.length,cur_saving+net_array[0]);
	
	var result_list = []; //this is the result that need to return
	
	
	//make a loop from 0 to the length of age_array, compute all the things
	for(var i = 0; i <age_array.length; i++){
		
		if(i > 0){
			if(i+ cur_age >= retire_age){
				spending_array[i] = income_array[retire_age - cur_age-1]*retire_level;
			}
			//we need to calculate
			mktgain_array[i] = compute_gain(total_array[i-1],EI,FI,retire_age-i-cur_age); // compute the mkt gain
			net_array[i] = mktgain_array[i]-spending_array[i]+savings_array[i]; // this is the net
			total_array[i] = total_array[i-1]+net_array[i]; // this is the total
		}
		
		
		
		
		
		
		var item=[]; // this is one small item
		item[0] = age_array[i];// 0 - age
		item[1] = savings_array[i];// 1 -savings
		item[2] = spending_array[i]; // 2 - spendings
		item[3] = total_array[i]; // 3 - total
		
		if (total_array[i] <= 0 && flag1 == 0) {
			run_out_age = age_array[i];
			flag1 = 1;
			document.getElementById('runOutAge').innerHTML = run_out_age;
		}
		
		
		
		result_list[i] = item; 
	}
	
	
	if (flag1 == 0) {
		document.getElementById('result').innerHTML = document.getElementById('result2').innerHTML;
	}
	
	//console.log(income_array);
	//console.log(income_array.length);
	//console.log(age_array);
	//console.log(age_array.length);
	//console.log(savings_array);
	//console.log(savings_array.length);
	//console.log(mktgain_array);
	//console.log(mktgain_array.length);
	//console.log(net_array);
	//console.log(total_array);
	//console.log(total_array.length);
	//console.log(pension_array);
	//console.log(ssn_array);
	//console.log(partner_pension_array);
	//console.log(partner_ssn_array);
	//console.log(spending_array);
	return result_list;
}

function compute_gain(last_total,EI,FI,till_retire){
	//7,3  5,5  
	if(till_retire -5 > 0){
		//7 - EI
		return last_total*0.7*EI+ last_total*0.3*FI;
	}else{
		return last_total*0.5*EI+ last_total*0.5*FI;
	}
}


//get spending array from the html
function get_spending_array(len){
	
	return init_array(len,0);
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

