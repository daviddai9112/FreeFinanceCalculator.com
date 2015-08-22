


google.load('visualization', '1.1', {
	packages : [ 'line' ,'corechart']
});
google.setOnLoadCallback(drawChart);

function drawChart() {

	var data = new google.visualization.DataTable();
	data.addColumn('number', 'Age');
	data.addColumn('number', 'Annual Savings');
	data.addColumn('number', 'Annual Expenses');
	data.addColumn('number', 'Total Balance');
     
	data.addRows(finalResult());

	var options = {
			vAxis :{
				title : 'amount USD',
				format:'short',
			},
			title : 'Retirement Plan',
			chartArea:{left:'13%',top:'10%',width:'80%',height:'75%'},
			legend:{position:'bottom'},
			
			
	};

	var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
	
	chart.draw(data, options);
}

/*window.onload = function() {
	var rows = finalResult();
	var totalArray = [];
	var savingArray = [];
	var spendingArray = [];
	var ageArray = [];
	for (var i = 0; i< rows.length;i++) {
		totalArray[i] = rows[i][3]; 
	}
	for (var i = 0; i< rows.length;i++) {
		savingArray[i] = rows[i][1]; 
	}
	for (var i = 0; i< rows.length;i++) {
		spendingArray[i] = rows[i][2]; 
	}
	for (var i = 0; i< rows.length;i++) {
		ageArray[i] = rows[i][0]; 
	}
	console.log(totalArray);
	console.log(spendingArray);
	console.log(savingArray);
	console.log(ageArray);
	
	var lineChartData = {
			labels : ageArray,
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data : savingArray
				},
				{
					label: "My Second dataset",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : totalArray
				},
				{
					label: "My Third dataset",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : spendingArray
				}
			]

		}
	

		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true,
			animation: true,
			scaleShowGridLines : false
		});
}*/

	