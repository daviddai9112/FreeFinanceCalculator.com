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
	var retire_level = 0.3;
	
	
	var age_array = get_age_array(cur_age,expect_life);
	var income_array = get_income_array(cur_income,income_increase,cur_age,retire_age,age_array.length);
	var savings_array = get_savings_array(income_array, saving_rate,retire_age-cur_age);
	var gain_array = init_array(age_array.length,0);
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
			gain_array[i] = compute_gain(total_array[i-1],EI,FI,retire_age-i-cur_age); // compute the gain
			net_array[i] = gain_array[i]-spending_array[i]+savings_array[i]; // this is the net
			total_array[i] = total_array[i-1]+net_array[i]; // this is the total
		}
		
		
		
		
		
		
		var item=[]; // this is one small item
		item[0] = age_array[i];// 0 - age
		item[1] = savings_array[i];// 1 -savings
		item[2] = spending_array[i]; // 2 - spendings
		item[3] = total_array[i]; // 3 - total
		
		result_list[i] = item; 
	}
	
	
	
	
	console.log(income_array);
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
	arr[0] = init_value
	for(var i = 1; i < len; i++){
		arr[i] = 0;
	}
	return arr;
}



//get the saving array

function get_savings_array(income_array, saving_rate,age){
	var arr = [];
	for(var i = 0; i < income_array.length; i++){
		if(i <= age ){
			arr[i] = income_array[i]*saving_rate;
		}else{
			arr[i] = 0;
		}
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

