/*
this is used for write all the events of retirement calculator
 */

//set the element value to the variable here
function setElementValue() {
	document.getElementById("income").value = Number(document
			.getElementById("store_income").value); // set income slider
	document.getElementById("income_span").innerHTML = format2(Number(document
			.getElementById("store_income").value)); // set income span
	document.getElementById("saving_rate").value = Number(document
			.getElementById("store_saving_rate").value);
	document.getElementById("saving_rate_span").innerHTML = Number(document
			.getElementById("store_saving_rate").value) * 1000 / 10;

	document.getElementById("retire_age").value = Number(document
			.getElementById("store_retire_age").value);
	document.getElementById("cur_age").value = Number(document
			.getElementById("store_cur_age").value);
	document.getElementById("retirement_level").value = Number(document
			.getElementById("store_retirement_level").value);
	document.getElementById("retirement_level_span").innerHTML = Number(document
			.getElementById("store_retirement_level").value) * 1000 / 10;

	document.getElementById("money_saved").value = Number(document
			.getElementById("store_money_saved").value);
	document.getElementById("money_saved_span").innerHTML = format2(Number(document
			.getElementById("store_money_saved").value));

	document.getElementById("income_increase_rate").value = Number(document
			.getElementById("store_income_increase_rate").value);
	document.getElementById("income_increase_rate_span").innerHTML = Number(document
			.getElementById("store_income_increase_rate").value) * 1000 / 10;

	if (document.getElementById("store_pension").value == "1") {
		document.getElementById("pension_age_div").style.display = "block";
		document.getElementById("pension_amount_div").style.display = "block";
		document.getElementById("pension_radio_1").checked = true;
	} else {
		document.getElementById("pension_age_div").style.display = "none";
		document.getElementById("pension_amount_div").style.display = "none";
		document.getElementById("pension_radio_0").checked = true;
	}
	document.getElementById("pension").value = document
			.getElementById("store_pension").value;
	document.getElementById("pension_age").value = Number(document
			.getElementById("store_pension_age").value);
	document.getElementById("pension_age_span").innerHTML = Number(document
			.getElementById("store_pension_age").value);

	document.getElementById("pension_amount").value = Number(document
			.getElementById("store_pension_amount").value);
	document.getElementById("pension_amount_span").innerHTML = format2(Number(document
			.getElementById("store_pension_amount").value));

	if (document.getElementById("store_eligible_SSN").value == "1") {
		document.getElementById("ss_age_div").style.display = "block";
		document.getElementById("ss_radio_1").checked = true;
	} else {
		document.getElementById("ss_age_div").style.display = "none";
		document.getElementById("ss_radio_0").checked = true;
	}
	// document.getElementById("eligible_SSN").value = document
	// .getElementById("store_eligible_SSN").value;

	document.getElementById("SSN_age").value = Number(document
			.getElementById("store_SSN_age").value);
	document.getElementById("SSN_age_span").innerHTML = Number(document
			.getElementById("store_SSN_age").value);

	// document.getElementById("SSN_amount").value =
	// Number(document.getElementById("store_SSN_amount").value);
	// document.getElementById("SSN_amount_span").value =
	// Number(document.getElementById("store_SSN_amount").value);

	if (document.getElementById("store_partner_eligible").value == "1") {
		document.getElementById("spouse_pension_div").style.display = "block";
		document.getElementById("spouse_ss_div").style.display = "block";
		document.getElementById("partner_radio_1").checked = true;
	} else {
		document.getElementById("spouse_pension_div").style.display = "none";
		document.getElementById("spouse_ss_div").style.display = "none";
		document.getElementById("partner_radio_0").checked = true;
	}
	// document.getElementById("partner_eligible").value = document
	// .getElementById("store_partner_eligible").value;

	if (document.getElementById("store_partner_pension").value == "1") {
		document.getElementById("spouse_pension_age_div").style.display = "block";
		document.getElementById("spouse_pension_amount_div").style.display = "block";
		document.getElementById("partner_pension_radio_1").checked = true;
	} else {
		document.getElementById("spouse_pension_age_div").style.display = "none";
		document.getElementById("spouse_pension_amount_div").style.display = "none";
		document.getElementById("partner_pension_radio_0").checked = true;
	}
	document.getElementById("partner_pension").value = document
			.getElementById("store_partner_pension").value;
	document.getElementById("partner_pension_age").value = Number(document
			.getElementById("store_partner_pension_age").value);
	document.getElementById("partner_pension_age_span").innerHTML = Number(document
			.getElementById("store_partner_pension_age").value);

	document.getElementById("partner_pension_amount").value = Number(document
			.getElementById("store_partner_pension_amount").value);
	document.getElementById("partner_pension_amount_span").innerHTML = format2(Number(document
			.getElementById("store_partner_pension_amount").value));

	if (document.getElementById("store_partner_eligible_SSN").value == 1) {
		document.getElementById("spouse_ss_age_div").style.display = "block";
		document.getElementById("partner_ssn_radio_1").checked = true;
	} else {
		document.getElementById("spouse_ss_age_div").style.display = "none";
		document.getElementById("partner_ssn_radio_0").checked = true;
	}
	// document.getElementById("partner_eligible_SSN").value = document
	// .getElementById("store_partner_eligible_SSN").value;
	document.getElementById("partner_SSN_age").value = Number(document
			.getElementById("store_partner_SSN_age").value);
	document.getElementById("partner_SSN_age_span").innerHTML = Number(document
			.getElementById("store_partner_SSN_age").value);

	// document.getElementById("partner_SSN_amount").value =
	// Number(document.getElementById("store_partner_SSN_amount").value);
	// document.getElementById("partner_SSN_amount_span").innerHTML =
	// Number(document.getElementById("store_partner_SSN_amount").value);

	document.getElementById("dependent").value = Number(document
			.getElementById("store_dependent").value);
	document.getElementById("dependent_span").innerHTML = Number(document
			.getElementById("store_dependent").value);

	document.getElementById("pay_for_college").value = Number(document
			.getElementById("store_pay_for_college").value);
	document.getElementById("pay_for_college_span").innerHTML = Number(document
			.getElementById("store_pay_for_college").value);

	document.getElementById("pay_for_wedding").value = Number(document
			.getElementById("store_pay_for_wedding").value);
	document.getElementById("pay_for_wedding_span").innerHTML = Number(document
			.getElementById("store_pay_for_wedding").value);

	document.getElementById("investment_before").value = Number(document
			.getElementById("store_investment_before").value);
	document.getElementById("investment_before_span").innerHTML = Number(document
			.getElementById("store_investment_before").value) * 1000 / 10;

	document.getElementById("investment_after").value = Number(document
			.getElementById("store_investment_after").value);
	document.getElementById("investment_after_span").innerHTML = Number(document
			.getElementById("store_investment_after").value) * 1000 / 10;

	document.getElementById("inflation_rate").value = Number(document
			.getElementById("store_inflation_rate").value);
	document.getElementById("inflation_rate_span").innerHTML = Number(document
			.getElementById("store_inflation_rate").value) * 1000 / 10;

	// document.getElementById("alert").innerHTML = document
	// .getElementById("store_alert").innerHTML;
	document.getElementById("alert_saving_rate").innerHTML = document
			.getElementById("store_alert_saving_rate").innerHTML;
	document.getElementById("alert_retirement_level").innerHTML = document
			.getElementById("store_alert_retirement_level").innerHTML;

	if ($('#dependent_college_0').length > 0)
		document.getElementById("dependent_college_0").value = Number(document
				.getElementById("store_dependent_college_0").value);
	if ($('#dependent_college_1').length > 0)
		document.getElementById("dependent_college_1").value = Number(document
				.getElementById("store_dependent_college_1").value);
	if ($('#dependent_college_2').length > 0)
		document.getElementById("dependent_college_2").value = Number(document
				.getElementById("store_dependent_college_2").value);
	if ($('#dependent_college_3').length > 0)
		document.getElementById("dependent_college_3").value = Number(document
				.getElementById("store_dependent_college_3").value);
	if ($('#dependent_college_4').length > 0)
		document.getElementById("dependent_college_4").value = Number(document
				.getElementById("store_dependent_college_4").value);

	if ($('#dependent_wedding_0').length > 0)
		document.getElementById("dependent_wedding_0").value = Number(document
				.getElementById("store_dependent_wedding_0").value);
	if ($('#dependent_wedding_1').length > 0)
		document.getElementById("dependent_wedding_1").value = Number(document
				.getElementById("store_dependent_wedding_1").value);
	if ($('#dependent_wedding_2').length > 0)
		document.getElementById("dependent_wedding_2").value = Number(document
				.getElementById("store_dependent_wedding_2").value);
	if ($('#dependent_wedding_3').length > 0)
		document.getElementById("dependent_wedding_3").value = Number(document
				.getElementById("store_dependent_wedding_3").value);
	if ($('#dependent_wedding_4').length > 0)
		document.getElementById("dependent_wedding_4").value = Number(document
				.getElementById("store_dependent_wedding_4").value);

}

function addAge() {

	if (editor.innerHTML === document.getElementById('ed5').innerHTML) {

		var collegeCount = document.getElementById("store_pay_for_college").value;

		var section = document.getElementById("college_age");
		section.innerHTML = "";
		var html = "";
		for (var index = 0; index < collegeCount; index++) {
			var countIndex = index + 1;
			html += "<div class='panel-body'>";
			html += "<span class='help-block col-lg-6' style='text-align: left;' id='id_college_"
					+ index
					+ "'><b>Dependent "
					+ countIndex
					+ " Age</b>"
					+ "</span>";
			html += "<div class = 'col-lg-6'>";
			html += "<input type = 'number' class='form-control' value = '' id = 'dependent_college_"
					+ index + "' onchange = 'valueChange(this);'";
			html += "</div>";
			html += "<br>";
			html += "</div>";

		}
		section.innerHTML += html;

		var weddingCount = document.getElementById("store_pay_for_wedding").value;

		var section1 = document.getElementById("wedding_age");
		section1.innerHTML = "";
		var html = "";
		for (var index = 0; index < weddingCount; index++) {
			var countIndex = index + 1;
			html += "<div class='panel-body'>";
			html += "<span class='help-block col-lg-6' style='text-align: left;' id='id_wedding_"
					+ index
					+ "'><b>Dependent "
					+ countIndex
					+ " Age</b>"
					+ "</span>";
			html += "<div class = 'col-lg-6'>";
			html += "<input type = 'number' class='form-control' value = '' id = 'dependent_wedding_"
					+ index + "' onchange = 'valueChange(this);'";
			html += "</div>";
			html += "<br>";
			html += "</div>";
		}

		section1.innerHTML += html;
	}
};

function addEvent() {
	// if page just load, then cur should be 0
	// document.getElementById("store_alert").innerHTML = "We would give you
	// some advice here.";
	if (cur == 0) {
		editor.innerHTML = document.getElementById('ed0').innerHTML;
		progress.innerHTML = document.getElementById('progress0').innerHTML;
		$("#Next").show();
		setElementValue(); // syn the value

	}
	if (flag == 0) {
		result.innerHTML = document.getElementById('result0').innerHTML;
	}

	nextBtn.onclick = nextClickEvent;// set click event
	preBtn.onclick = preClickEvent; // pre btn click event

};

function setButton() {
	if (cur % contents.length !== 5 && cur % contents.length !== 0) {
		$("#Next").show();
		$("#Pre").show();
		$("#viewdetails").hide();
	} else if (cur % contents.length === 5) {
		$("#Pre").show();
		$("#Next").hide();
		$("#viewdetails").show();
	} else if (cur % contents.length === 0) {
		$("#Pre").hide();
		$("#Next").show();
		$("#viewdetails").hide();
	}

};

function setAlert() {
	var run_out_of_money_age = Number(document.getElementById("runOutAge").innerHTML);

	if (document.getElementById("result").innerHTML == document
			.getElementById("result2").innerHTML) {
		document.getElementById('alert5').style.display = "block";
		document.getElementById('alert1').style.display = "none";
		document.getElementById('alert2').style.display = "none";
		document.getElementById('alert3').style.display = "none";
		document.getElementById('alert4').style.display = "none";

	} else if (cur % contents.length === 0 && run_out_of_money_age < 100) {
		document.getElementById('alert5').style.display = "none";
		var save_rate = Number(document.getElementById("store_saving_rate").value);
		var retirement_level = Number(document
				.getElementById("store_retirement_level").value);
		if (save_rate < 0.07) {

			document.getElementById('alert1').style.display = "block";
			document.getElementById("store_alert_saving_rate").innerHTML = (save_rate * 1000) / 10;

		} else {
			document.getElementById('alert1').style.display = "none";
		}

		if (retirement_level > 0.90) {

			document.getElementById('alert4').style.display = "block";
			document.getElementById("store_alert_retirement_level").innerHTML = (retirement_level * 1000) / 10;

		} else {
			document.getElementById('alert4').style.display = "none";
		}

	} else if (cur % contents.length === 4) {
		document.getElementById('alert5').style.display = "none";
		var education_number = Number(document
				.getElementById("store_pay_for_college").value);
		if (education_number >= 1) {
			document.getElementById('alert2').style.display = "block";

		} else {
			document.getElementById('alert2').style.display = "none";
		}

		var wedding_number = Number(document
				.getElementById("store_pay_for_wedding").value);
		if (wedding_number >= 1 && run_out_of_money_age < 85) {

			document.getElementById('alert3').style.display = "block";
		} else {
			document.getElementById('alert3').style.display = "none";
		}

	}

};

// when next button is clicked the following happens
function nextClickEvent() {
	cur = cur + 1;
	editor.innerHTML = document.getElementById(contents[cur % contents.length]).innerHTML;
	progress.innerHTML = document.getElementById(progressname[cur
			% progressname.length]).innerHTML;
	addAge();
	setAlert();
	setElementValue(); // syn the value
	// set the button
	setButton();

	$('[data-toggle="tooltip"]').tooltip();
	// $('[data-toggle="toggle"]').bootstrapToggle();

}
// when pre button is clicked
function preClickEvent() {
	if (cur > 0) {
		cur = cur - 1;
		editor.innerHTML = document.getElementById(contents[cur
				% contents.length]).innerHTML;
		progress.innerHTML = document.getElementById(progressname[cur
				% progressname.length]).innerHTML;
		addAge();
		setAlert();
		setElementValue(); // syn the value
		// set the button
		setButton();
	}

	$('[data-toggle="tooltip"]').tooltip();
	// $('#pension').bootstrapToggle();
}

// when any input has change the value
function valueChange(ele) {
	// save to its own store
	if (ele.id == "pay_for_college") {
		if (ele.value > Number(document.getElementById("store_dependent").value))
			ele.value = Number(document.getElementById("store_dependent").value);
	}

	if (ele.id == "pay_for_wedding") {
		if (ele.value > Number(document.getElementById("store_dependent").value))
			ele.value = Number(document.getElementById("store_dependent").value);
	}

	if (ele.id == "cur_age") {

		if (ele.value > 90) {
			ele.value = 90;
			$("#cur_age").attr('data-original-title',
					'Your current age should not be more than 90.');
		}
		if (ele.value < 14) {
			ele.value = 14;
			$("#cur_age").attr('data-original-title',
					'Your current age should not be less than 14.');
		}
		if (ele.value >= Number(document.getElementById("store_retire_age").value)) {
			ele.value = Number(document.getElementById("store_retire_age").value) - 2;
			$("#cur_age").attr('data-original-title',
					'Your current age should be less than retirement age.');
		}
	}

	if (ele.id == "retire_age") {
		if (ele.value > 90) {
			ele.value = 90;
			$("#retire_age").attr('data-original-title',
					'Your retirement age should not be more than 90.');
		}
		if (ele.value < 14) {
			ele.value = 14;
			$("#retire_age").attr('data-original-title',
					'Your retirement age should not be less than 14.');
		}
		if (ele.value <= Number(document.getElementById("store_cur_age").value)) {
			ele.value = Number(document.getElementById("store_cur_age").value) + 2;
			$("#retire_age").attr('data-original-title',
					'Your retirement age should be more than current age.');
		}
	}

	if (ele.id == "dependent_college_0") {
		if (ele.value > 18)
			ele.value = 18;
	}
	if (ele.id == "dependent_college_1") {
		if (ele.value > 18)
			ele.value = 18;
	}
	if (ele.id == "dependent_college_2") {
		if (ele.value > 18)
			ele.value = 18;
	}
	if (ele.id == "dependent_college_3") {
		if (ele.value > 18)
			ele.value = 18;
	}
	if (ele.id == "dependent_college_4") {
		if (ele.value > 18)
			ele.value = 18;
	}

	if (ele.id == "dependent_wedding_0") {
		if (ele.value > 28)
			ele.value = 28;
	}
	if (ele.id == "dependent_wedding_1") {
		if (ele.value > 28)
			ele.value = 28;
	}
	if (ele.id == "dependent_wedding_2") {
		if (ele.value > 28)
			ele.value = 28;
	}
	if (ele.id == "dependent_wedding_3") {
		if (ele.value > 28)
			ele.value = 28;
	}
	if (ele.id == "dependent_wedding_4") {
		if (ele.value > 28)
			ele.value = 28;
	}
	var store_ele = null;
	if (ele.id == "pension_radio_1") {
		store_ele = document.getElementById('store_pension');
		store_ele.value = 1;
	} else if (ele.id == "pension_radio_0") {
		store_ele = document.getElementById('store_pension');
		store_ele.value = 0;
	} else if (ele.id == "ss_radio_1") {
		store_ele = document.getElementById('store_eligible_SSN');
		store_ele.value = 1;
	} else if (ele.id == "ss_radio_0") {
		store_ele = document.getElementById('store_eligible_SSN');
		store_ele.value = 0;
	} else if (ele.id == "partner_radio_1") {
		store_ele = document.getElementById('store_partner_eligible');
		store_ele.value = 1;
	} else if (ele.id == "partner_radio_0") {
		store_ele = document.getElementById('store_partner_eligible');
		store_ele.value = 0;
	} else if (ele.id == "partner_pension_radio_1") {
		store_ele = document.getElementById('store_partner_pension');
		store_ele.value = 1;
	} else if (ele.id == "partner_pension_radio_0") {
		store_ele = document.getElementById('store_partner_pension');
		store_ele.value = 0;
	} else if (ele.id == "partner_ssn_radio_1") {
		store_ele = document.getElementById('store_partner_eligible_SSN');
		store_ele.value = 1;
	} else if (ele.id == "partner_ssn_radio_0") {
		store_ele = document.getElementById('store_partner_eligible_SSN');
		store_ele.value = 0;
	} else {
		store_ele = document.getElementById('store_' + ele.id);
		store_ele.value = ele.value;
	}

	setAlert();
	setElementValue();
	if (ele.id === 'pay_for_college') {
		document.getElementById("store_dependent_college_0").value = -1;
		document.getElementById("store_dependent_college_1").value = -1;
		document.getElementById("store_dependent_college_2").value = -1;
		document.getElementById("store_dependent_college_3").value = -1;
		document.getElementById("store_dependent_college_4").value = -1;
	}

	if (ele.id === 'pay_for_wedding') {
		document.getElementById("store_dependent_wedding_0").value = -1;
		document.getElementById("store_dependent_wedding_1").value = -1;
		document.getElementById("store_dependent_wedding_2").value = -1;
		document.getElementById("store_dependent_wedding_3").value = -1;
		document.getElementById("store_dependent_wedding_4").value = -1;
	}
	addAge();
	console.log(document.getElementById('store_pay_for_college').value);
	result.innerHTML = document.getElementById('result1').innerHTML;
	// calculate
	calculate();
	var age = document.getElementById("runOutAge").innerHTML;

	if (age < 75) {
		document.getElementById("forecast_result").innerHTML = document
				.getElementById('forecast_result3').innerHTML;
	}
	if (age < 84 && age >= 75) {
		document.getElementById("forecast_result").innerHTML = document
				.getElementById('forecast_result2').innerHTML;

	}
	if (age <= 100 && age >= 85) {
		document.getElementById("forecast_result").innerHTML = document
				.getElementById('forecast_result1').innerHTML;
	}

}

// calcualte the and then put to the data
function calculate() {

	// alert("calculate the result using the excel and its algorithm");

	// draw the chart

	var rows = finalResult();
	var totalArray = [];
	var savingArray = [];
	var spendingArray = [];
	var ageArray = [];
	for (var i = 0; i < rows.length; i++) {
		totalArray[i] = rows[i][3];
	}
	for (var i = 0; i < rows.length; i++) {
		savingArray[i] = rows[i][1];
	}
	for (var i = 0; i < rows.length; i++) {
		spendingArray[i] = rows[i][2];
	}
	for (var i = 0; i < rows.length; i++) {
		ageArray[i] = rows[i][0];
	}
	reDraw(rows); // draw the google chart

	// reDraw(totalArray, savingArray, spendingArray,ageArray);
}

/*
 * function reDraw(totalArray, savingArray, spendingArray, ageArray) { var
 * lineChartData = { labels : ageArray, datasets : [ { label: "My First
 * dataset", fillColor : "rgba(220,220,220,0.2)", strokeColor :
 * "rgba(220,220,220,1)", pointColor : "rgba(220,220,220,1)", pointStrokeColor :
 * "#fff", pointHighlightFill : "#fff", pointHighlightStroke :
 * "rgba(220,220,220,1)", data : savingArray }, { label: "My Second dataset",
 * fillColor : "rgba(151,187,205,0.2)", strokeColor : "rgba(151,187,205,1)",
 * pointColor : "rgba(151,187,205,1)", pointStrokeColor : "#fff",
 * pointHighlightFill : "#fff", pointHighlightStroke : "rgba(151,187,205,1)",
 * data : totalArray }, { label: "My Third dataset", fillColor :
 * "rgba(151,187,205,0.2)", strokeColor : "rgba(151,187,205,1)", pointColor :
 * "rgba(151,187,205,1)", pointStrokeColor : "#fff", pointHighlightFill :
 * "#fff", pointHighlightStroke : "rgba(151,187,205,1)", data : spendingArray } ] }
 * var ctx = document.getElementById("cansvas").getContext("2d"); window.myLine =
 * new Chart(ctx).Line(lineChartData, { responsive: true, animation: true,
 * scaleShowGridLines : false,
 * 
 * labelsFilter: function (value, index) { return (index + 1) % 5 !== 0; } }); }
 */

// redraw the chart
function reDraw(rows) {
	var data = new google.visualization.DataTable();
	data.addColumn('number', 'Age');
	data.addColumn('number', 'Annual Savings');
	data.addColumn('number', 'Annual Expenses');
	data.addColumn('number', 'Total Balance');

	data.addRows(rows);
	var options = {
			vAxis :{
				title : 'amount USD',
			},

			title : 'Retirement Plan',
			chartArea:{left:'13%',top:'10%',width:'80%',height:'75%'},
			legend:{position:'bottom'},

	};
	var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));

	chart.draw(data, options);
}
//function reDraw(rows) {
//	var data = new google.visualization.DataTable();
//	data.addColumn('number', 'Age');
//	data.addColumn('number', 'Annual Savings');
//	data.addColumn('number', 'Annual Expenses');
//	data.addColumn('number', 'Total Balance');
//
//	data.addRows(rows);
//	var options = {
//		chart : {
//			title : 'Retirement Plan',
//			subtitle : 'in dollars (USD)'
//		},
//		width : 620,
//		height : 400,
//
//	};
//	var chart = new google.charts.Line(document.getElementById('chart_div'));
//
//	chart.draw(data, options);
//}
