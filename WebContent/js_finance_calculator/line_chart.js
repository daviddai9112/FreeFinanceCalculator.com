

google.load('visualization', '1.1', {
	packages : [ 'line' ]
});
google.setOnLoadCallback(drawChart);

function drawChart() {

	var data = new google.visualization.DataTable();
	data.addColumn('number', 'Age');
	data.addColumn('number', 'Savings');
	data.addColumn('number', 'Spending');
	data.addColumn('number', 'Total');
	//data.addColumn('number', 'Transformers: Age of Extinction');

	data.addRows(finalResult());

	var options = {
		chart : {
			title : 'Retirement Plan',
			subtitle : 'in dollars (USD)'
		},
		width : 650,
		height : 400
	};

	var chart = new google.charts.Line(document.getElementById('chart_div'));

	chart.draw(data, options);
}
