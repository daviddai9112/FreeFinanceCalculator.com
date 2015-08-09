/*
this is used to contain all the google chart js related code
*/

// init the parameter
var p1 = 100;
var p2 = 200;

//declare the method draw color

function drawColColors() {
	var data = google.visualization.arrayToDataTable([
			[ 'Element', 'Amount', {
				role : 'style'
			}, {
				role : 'annotation'
			} ], [ 'You will Need', p1, 'color: #e5e4e2', '$' + p1 ],
			[ 'You will get', p2, 'gold', '$' + p2 ] ]);

	var options = {
		title : 'How much Money You can get',
		colors : [ 'gold', '#33ac71' ],
	};

	var chart = new google.visualization.ColumnChart(document
			.getElementById('chart_div'));
	chart.draw(data, options);

	//get element
	var cur_income = document.getElementById("cur_income");
	var save_rates = document.getElementById("save_rates");
	var cur_age = document.getElementById("cur_age");
	var retire_age = document.getElementById("retire_age");
	var amount_saved = document.getElementById("amount_saved");

	function recalculate() {
		getElementValue();//get element value to the varialbe
		
		var newValue1 = 0;
		var newValue2 = 100;

		newValue1 = (Number(amount_saved.value) + Number(cur_income.value))
				* Number(save_rates.value)
				* (Number(retire_age.value) - Number(cur_age.value));
		newValue2 = newValue1 * 1.5 + Number(amount_saved.value);

		//change the data
		data.setValue(0, 1, newValue1);
		data.setValue(0, 3, '$' + newValue1);
		data.setValue(1, 1, newValue2);
		data.setValue(1, 3, '$' + newValue2);

		chart.draw(data, options);

		//show change in slider
		setELementValue();
	}
	//set listener
	cur_income.onchange = recalculate;
	save_rates.onchange = recalculate;
	cur_age.onchange = recalculate;
	retire_age.onchange = recalculate;
	amount_saved.onchange = recalculate;
}


/*
	show the chart
*/

google.load('visualization', '1', {
	packages : [ 'corechart', 'bar' ]
});
google.setOnLoadCallback(drawColColors);


