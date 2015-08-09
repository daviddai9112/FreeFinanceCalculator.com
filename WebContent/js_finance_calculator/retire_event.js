/*
this is used for write all the events of retirement calculator
 */

//get elementvalue to the variable

/*function getElementValue() {
	cur_income_value = document.getElementById("income").value; //get income slider
	save_rates_value = document.getElementById("saving_rate").value; // get save rates slider
	cur_age_value = document.getElementById("store_cur_age").value;
	retire_age_value =  document.getElementById("retire_age").value;
	retire_level_value =  document.getElementById("retirement_level").value;;
	cur_save_value = document.getElementById("money_saved").value;
	increase_rate_value = document.getElementById("income_increase_rate").value;
	
	pension_value = document.getElementById("pension").value;
	pension_age_value = document.getElementById("pension_age").value;
	pension_monthly_value = document.getElementById("pension_amount").value;
	
	ssn_value = document.getElementById("eligible_SSN").value;
	ssn_age_value = document.getElementById("SSN_age").value;
	ssn_monthly_value = document.getElementById("SSN_amount").value;
	
	partner_value = document.getElementById("partner_eligible").value; 
	
	partner_pension_value = document.getElementById("partner_pension").value; 
	partner_pension_age_value = document.getElementById("partner_pension_age").value; 
	partner_pension_monthly_value = document.getElementById("partner_pension_amount").value; 
	
	partner_ssn_value = document.getElementById("partner_eligible_SSN").value; 
	partner_ssn_age_value = document.getElementById("partner_SSN_age").value; 
	partner_ssn_monthly_value = document.getElementById("partner_SSN_amount").value; 
}*/

//set the element value to the variable here
function setElementValue() {
	document.getElementById("income").value = Number(document.getElementById("store_income").value); //set income slider
	document.getElementById("income_span").innerHTML = Number(document.getElementById("store_income").value); // set income span
	document.getElementById("saving_rate").value = Number(document.getElementById("store_saving_rate").value);
	document.getElementById("saving_rate_span").innerHTML = Number(document.getElementById("store_saving_rate").value) * 100; 
	
	document.getElementById("retire_age").value = Number(document.getElementById("store_retire_age").value); 
	document.getElementById("cur_age").value = Number(document.getElementById("store_cur_age").value);
	document.getElementById("retirement_level").value = Number(document.getElementById("store_retirement_level").value);
	document.getElementById("retirement_level_span").innerHTML = Number(document.getElementById("store_retirement_level").value) * 100; 
	
	
	document.getElementById("money_saved").value = Number(document.getElementById("store_money_saved").value); 
	document.getElementById("money_saved_span").innerHTML =Number(document.getElementById("store_money_saved").value); 
	
	
	document.getElementById("income_increase_rate").value = Number(document.getElementById("store_income_increase_rate").value); 
	document.getElementById("income_increase_rate_span").innerHTML = Number(document.getElementById("store_income_increase_rate").value) * 100; 
	
	document.getElementById("pension").value = document.getElementById("store_pension").value;
	document.getElementById("pension_age").value = Number(document.getElementById("store_pension_age").value);
	document.getElementById("pension_age_span").innerHTML = Number(document.getElementById("store_pension_age").value);
	
	document.getElementById("pension_amount").value = Number(document.getElementById("store_pension_amount").value);
	document.getElementById("pension_amount_span").innerHTML = Number(document.getElementById("store_pension_amount").value);
	
    document.getElementById("eligible_SSN").value = document.getElementById("store_eligible_SSN").value;
	document.getElementById("SSN_age").value = Number(document.getElementById("store_SSN_age").value);
	document.getElementById("SSN_age_span").innerHTML = Number(document.getElementById("store_SSN_age").value);
	
	document.getElementById("SSN_amount").value = Number(document.getElementById("store_SSN_amount").value);
	document.getElementById("SSN_amount_span").value = Number(document.getElementById("store_SSN_amount").value);
	
	document.getElementById("partner_eligible").value = document.getElementById("store_partner_eligible").value;
	
	document.getElementById("partner_pension").value = document.getElementById("store_partner_pension").value;
	document.getElementById("partner_pension_age").value = Number(document.getElementById("store_partner_pension_age").value);
	document.getElementById("partner_pension_age_span").innerHTML = Number( document.getElementById("store_partner_pension_age").value);
	
	document.getElementById("partner_pension_amount").value = Number(document.getElementById("store_partner_pension_amount").value);
	document.getElementById("partner_pension_amount_span").innerHTML = Number(document.getElementById("store_partner_pension_amount").value);
	
	document.getElementById("partner_eligible_SSN").value = document.getElementById("store_partner_eligible_SSN").value;
	document.getElementById("partner_SSN_age").value = Number(document.getElementById("store_partner_SSN_age").value);
	document.getElementById("partner_SSN_age_span").innerHTML = Number(document.getElementById("store_partner_SSN_age").value);
	
	document.getElementById("partner_SSN_amount").value = Number(document.getElementById("store_partner_SSN_amount").value);
	document.getElementById("partner_SSN_amount_span").innerHTML = Number(document.getElementById("store_partner_SSN_amount").value);
	
	document.getElementById("dependent").value = Number(document.getElementById("store_dependent").value);
	document.getElementById("dependent_span").innerHTML = Number(document.getElementById("store_dependent").value);
}

function addAge () {
	
    if (editor.innerHTML === document.getElementById('ed6').innerHTML) {
		
	    var childCount = document.getElementById("store_dependent").value;
	    var section = document.getElementById("dependent_age"); 
	    var html = "";
	    for(var index = 0; index < childCount; index++) {
		    var countIndex = index + 1;
		    html += "<div class='panel-body' style='padding: 5px;'>";
		    html += "<span class='help-block col-lg-6' style='text-align: left' id='id_" + index + "'><b>Dependent " + countIndex + " Age</b>" + "</span>";
		    html += "<div class = 'col-lg-6'>";
		    html += "<input type = 'text' class='form-control' value = '5' id = 'dependent_" + index + "' onchange = 'valueChange(this);'";
		    html += "</div>";
		    html += "</div>";
	    }
	    section.innerHTML += html;
	}
};

function addEvent() {
	//if page just load, then cur should be 0
	alert.innerHTML = document.getElementById('alert0').innerHTML;
	if (cur == 0) {
		editor.innerHTML = document.getElementById('ed0').innerHTML;
		
		setElementValue(); // syn the value
		
	}
	if (flag == 0) {
		result.innerHTML = document.getElementById('result0').innerHTML;
	} 
	
	
	nextBtn.onclick = nextClickEvent;//set click event
	preBtn.onclick = preClickEvent; // pre btn click event 
	
	
};

//when next button is clicked the following happens
function nextClickEvent() {
	cur = cur + 1;
	editor.innerHTML = document.getElementById(contents[cur % contents.length]).innerHTML;
	setElementValue(); // syn the value
	addAge();
	
}
//when pre button is clicked
function preClickEvent() {
	if (cur > 0) {
		cur = cur - 1;
		editor.innerHTML = document.getElementById(contents[cur
				% contents.length]).innerHTML;
		setElementValue(); // syn the value
		addAge();
	}
}

//when any input has change the value
function valueChange(ele) {
	//save to its own store
	var store_ele = document.getElementById('store_' + ele.id);
	store_ele.value = ele.value;
	addAge();
	result.innerHTML = document.getElementById('result1').innerHTML;
	//calculate
	calculate();
    var age = document.getElementById("runOutAge").innerHTML;
	
	if (age < 80) {
		document.getElementById("forecast_result").innerHTML = document.getElementById('forecast_result3').innerHTML;
	} if (age <= 95 && age >= 80) {
		document.getElementById("forecast_result").innerHTML = document.getElementById('forecast_result2').innerHTML;
	   
	} if (age > 95) {
		document.getElementById("forecast_result").innerHTML = document.getElementById('forecast_result1').innerHTML;
	} 
	
	var save_rate =Number( document.getElementById("store_saving_rate").value );
	var retirement_level =Number( document.getElementById("store_retirement_level").value );
	if (save_rate < 0.07) {
		
		document.getElementById("alert").innerHTML = document.getElementById('alert1').innerHTML;
		document.getElementById("alert_saving_rate").innerHTML = save_rate * 100;
	} else {
		
		if (retirement_level > 0.80) {
			document.getElementById("alert").innerHTML = document.getElementById('alert4').innerHTML;
			document.getElementById("alert_retirement_level").innerHTML =  retirement_level * 100;
		} else {
			document.getElementById("alert").innerHTML = document.getElementById('alert0').innerHTML;
		}
		
	}
	
	
	
}

//calcualte the and then put to the data
function calculate() {

	//alert("calculate the result using the excel and its algorithm");

	//draw the chart

	var rows = finalResult();
	reDraw(rows); // draw the google chart
}


//redraw the chart
function reDraw(rows){
	var data = new google.visualization.DataTable();
	data.addColumn('number', 'Age');
	data.addColumn('number', 'Savings');
	data.addColumn('number', 'Spending');
	data.addColumn('number', 'Total');
	
	data.addRows(rows);
	var options = {
		chart : {
			title : 'Retirement Plan',
			subtitle : 'in dollars (USD)'
		},
		width : 600,
		height : 400
	};
	var chart = new google.charts.Line(document.getElementById('chart_div'));
	chart.draw(data, options);
}


