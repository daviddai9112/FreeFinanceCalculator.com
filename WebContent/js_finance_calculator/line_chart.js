google.load('visualization', '1.1', {
	packages : [ 'line' ]
});
google.setOnLoadCallback(drawChart);

function drawChart() {

	var data = new google.visualization.DataTable();
	data.addColumn('number', 'Age');
	data.addColumn('number', 'Savings');
	data.addColumn('number', 'Spending');
	//data.addColumn('number', 'Transformers: Age of Extinction');

	data.addRows([ [ 35, 100,100 ],
	               [40,150,120],
	               [45,180,130],
	               ]);

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
