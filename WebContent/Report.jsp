<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="databeans.FormBean"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Retirement Calculator | Report</title>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" type="text/css"
	href="http://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<!-- Custom Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"
	type="text/css">

<!-- Plugin CSS -->
<link rel="stylesheet" href="css/animate.min.css" type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/creative.css" type="text/css">

<!-- JQuery -->
<script type="text/javascript" src="jQuery/jquery-1.11.2.js"></script>
<script type="text/javascript" src="jQuery/jquery-ui.js"></script>
</head>
<script>
	function format(n) {
		return n.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,");
	}
</script>
<body id="page-top">

	<nav id="mainNav" class="navbar navbar-subpage navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top">Financial
					Calculator</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<!-- <li><a class="page-scroll" href="#about">About</a></li>
					<li><a class="page-scroll" href="#services">Services</a></li>
					<li><a class="page-scroll" href="#calculator">Calculator</a></li>
					<li><a class="page-scroll" href="#contact">Contact</a></li> -->
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- the header picture is unique, naroow-->
	<!-- header-->


	<!-- end header -->

	<!--here is the main part -->
	<section id="services">
		<div class="container">

			<div class="row">

				<!-- start main_part -->
				<div class="col-lg-12  text-center" id="main_part">
					<h2>Financial Calculator</h2>
					<hr>
					<!-- here is the top_content -->
					<div class="col-lg-12" id="top_content"></div>
					<!-- top_content end -->



					<!-- here is the left_chart -->
					<div class="col-lg-6" id="left_chart">
						<div class="panel panel-default">
							<div class="panel-body">
								<div id="forecast_img" class="col-lg-2">
									<img id="img" src="${pic}" style="float: left;">
								</div>
								<div id="text"
									style="font-size: 20px; color: #D1D0CE; float: left; font-family: Arial"
									class="col-lg-10">
									You will run out of money at ${run_out} years old.
									<div id="text"
										style="font-size: 15px; color: #D1D0CE; font-family: Arial; text-align: left;">

										You're in <font color="#6698FF">excellent shape</font>.This
										assumes annual retirement expenses of ${retirement_spending}
										which is ${retirement_level}% of your last year's income of
										${lastyr_income}.
									</div>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-body">
								<div id="chart_div" style="height: 250px;"></div>
								<!-- this is the google chart-->
							</div>
						</div>
					</div>
					<!-- left_chart end -->


					<!-- right_div start -->
					<div class="col-lg-6" id="right_div">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b>Suggestions for you</b>
							</div>
							<div class="panel-body" style="text-align: left;">
								<span>To help meet your goal, you may wish to do the
									following:</span> <br /> <span style="text-align: left;">1.
									Increase your rate of return before retirement from <font
									color="#6698FF">${rate_before}% </font> to <font
									color="#6698FF">${recommand_rate}% </font>.
								</span> <br /> <span style="text-align: left;">2. Reduce your
									retirement level to <font color="#6698FF">${recommand_retirement_level}%</font>
									of your final year's income.
								</span> <br /> <span style="text-align: left;">3.Increase
									contributions to <font color="#6698FF">${rec_saving_rate}%</font>
									of your income
								</span>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<b>Tips</b>
							</div>
							<div class="panel-body" style="text-align: left;">
								<span style="text-align: left;">The best way and most
									convenient way to achieve your retirement goal is to find a
									financial advisor. They will help you to manage your money and
									account, to make reasonable investment. Personal financial
									advisor are professional for goal planning.</span>
							</div>
						</div>

						<!--form-->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne"> show table </a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse">
								<div class="panel-body" id="fund_list">
									<table class="table table-hover ">
										<tr>
											<td>Age</td>
											<td>Beginning Retirement Balance</td>
											<td>Investment Growth</td>
											<td>Contributions at ${income_rate}% of Income</td>
											<td>Retire with ${retirement_level}& of Income</td>
											<td>Retirement Account Withdrawals</td>
											<td>Ending Retirement Balance</td>
										</tr>
										<c:forEach var="formBean" items="${formBeans}">
											<tr>
												<td>${formBean.age}</td>
												<td>${formBean.beginretirementbalance}</td>
												<td>${formBean.investmentgrowth}</td>
												<td>${formBean.saving}</td>
												<td>${formBean.retirementspend}</td>
												<td>${formBean.accountspending}</td>
												<td>${formBean.total}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
						<!--form end-->

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseTwo"> survey </a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse">
								<div class="panel-body" id="fund_list">
								<jsp:include page="error.jsp" />
									<form method="POST" action="survey.do">
										<div id="question1" class="panel-body">
											<span class="help-block" style="text-align: left;">1.Do
												you find our app useful ?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="radio" name="surveyq1" value="Very Useful">A.
												Very Useful <input type="radio" name="surveyq1"
													value="Useful">B. Useful <input type="radio"
													name="surveyq1" value="Okay">C. Okay <input
													type="radio" name="surveyq1" value="Not Useful">D.
												Not Useful
											</div>
										</div>
										<div id="question2" class="panel-body">
											<span class="help-block" style="text-align: left;">2.Do
												you find it contains enough information you are interested
												in? If not, what else it should be included.</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="radio" name="surveyq2"
													value="Enough Information">A. Enough Information <input
													type="radio" name="surveyq2" value="Not Enough Information">B.
												Not Enough Information <input type="text" name="surveyq2"
													placeholder="it should have">
											</div>
										</div>
										<div id="question3" class="panel-body">
											<span class="help-block" style="text-align: left;">3.Do
												you find our app easy to use?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="radio" name="surveyq3" value="Very Easy to use">A.
												Very Easy to use <input type="radio" name="surveyq3"
													value="Not Easy to use">B. Not Easy to use
											</div>
										</div>
										<div id="question4" class="panel-body">
											<span class="help-block" style="text-align: left;">4.Will
												you introduce our app to your friends and relatives?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="radio" name="surveyq4" value="Yes, I would">A.
												Yes, I would <input type="radio" name="surveyq4"
													value="Not probably">B. Not probably
											</div>
										</div>
										<div id="question5" class="panel-body">
											<span class="help-block" style="text-align: left;">5.Do
												you want more personalized financial suggestions?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="radio" name="surveyq5" value="Yes, I think so">A.
												Yes, I think so <input type="radio" name="surveyq5"
													value="No, that's enough">B. No, that's enough
											</div>
										</div>
										<div id="question6" class="panel-body">
											<span class="help-block" style="text-align: left;">6.If
												yes in Q5, Are you willing to register account and link your
												bank account?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="radio" name="surveyq6" value="Yes, I'd love to">A.
												Yes, I'd love to <input type="radio" name="surveyq6"
													value="Not probably">B. Not probably <input
													type="radio" name="surveyq6" value="No">C. No <input
													type="radio" name="surveyq6" value="Not safe">D.
												Not safe
											</div>
										</div>
										<div id="question7" class="panel-body">
											<span class="help-block" style="text-align: left;">7.What
												is the most precious function you think in our website?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="checkbox" name="surveyq7"
													value="Financial calculator">A. Financial
												calculator <input type="checkbox" name="surveyq7"
													value="Financial Tips">B. Financial Tips <input
													type="checkbox" name="surveyq7" value="Track spending">C.
												Track spending
											</div>
										</div>
										<div id="question8" class="panel-body">
											<span class="help-block" style="text-align: left;">8.What
												do you like the least in our website?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="checkbox" name="surveyq8"
													value="Financial Calculator">A. Financial
												Calculator <input type="checkbox" name="surveyq8"
													value="Financial Tips">B. Financial Tips <input
													type="checkbox" name="surveyq8" value="Track spending">C.
												Track spending <input type="checkbox" name="surveyq8"
													value="User interface">D. User interface
											</div>
										</div>
										<div id="question9" class="panel-body">
											<span class="help-block" style="text-align: left;">9.What
												functions do you expect in a financial planning website?</span>
											<div class="col-lg-6" style="text-align: left;">
												<input type="checkbox" name="surveyq9" value="That's enough">A.
												That's enough <input type="checkbox" name="surveyq9"
													value="Investment Suggestions">B. Investment
												Suggestions <input type="checkbox" name="surveyq9"
													value="Tax help">C. Tax help
											</div>
										</div>
										<div id="question10" class="panel-body">
											<span class="help-block" style="text-align: left;">10.
												What suggestions do you have for our app?</span>
											<div class="col-lg-6" style="text-align: left;">
												<textarea cols="40" rows="5" name="surveyq10"></textarea>
											</div>
										</div>
										<input type="submit" class="btn btn-primary btn-block flat"
											name="action" value="survey" />
									</form>
								</div>
							</div>
						</div>
					</div>
					<!--right_div end-->

					<!-- here is the bottom_part -->
					<div class="col-lg-12" id="bottom_part"></div>
					<!--end bottom_part -->
				</div>
				<!-- end main_part -->
			</div>
			<!-- /.row -->
		</div>
		<!-- container -->
	</section>



	<!-- footer-->
	<script>
		$(function() {
			//$("#footer_content").load("footer.html");
		});
	</script>
	<div id="footer_content"></div>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="js/jquery.easing.min.js"></script>
	<script src="js/jquery.fittext.js"></script>
	<script src="js/wow.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/creative.js"></script>



	<!-- the following is for google chart -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript"
		src="js_finance_calculator/line_chart.js"></script>

	<!-- the excel algorithm -->
	<script src="js_finance_calculator/finance_calculator_excel.js"></script>
	<!-- import the event js -->
	<script src="js_finance_calculator/retire_event.js"></script>
	<script>
		//variables
		var contents = [ 'ed0', 'ed1', 'ed2', 'ed3', 'ed4', 'ed5', 'ed6', 'ed7' ];
		var cur = 0;
		var cur_income_value = 11000;
		var save_rates_value = 0.02;

		//elements
		var nextBtn = document.getElementById("Next");
		var preBtn = document.getElementById("Pre");
		var editor = document.getElementById("editor");

		addEvent();
	</script>

</body>

</html>
