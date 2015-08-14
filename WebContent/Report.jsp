<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="databeans.FormBean"%>
<%@ page import="databeans.CalculatorBean"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Retirement Calculator | Report</title>

<script src="js/Chart.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>

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
<link rel="stylesheet" type="text/css" href="css/sequences.css" />

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
				<a class="navbar-brand page-scroll" href="#page-top">Retirement Planner</a>
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
					<h2>Retirement Planner</h2>
					<hr>
					<!-- here is the top_content -->
					<div class="col-lg-6" id="top_content"></div>
					<!-- top_content end -->

					<!-- here is the left_chart -->
					<div class="col-lg-9" id="left_div">
						<div id="wrapper">
							<div id="tabContainer" class="panel panel-default">
								<div id="tabs" class="col-lg-9">
									<ul class="nav navbar-nav navbar-left" id="tabs">
										<li id="tabHeader_1"><a class="page-scroll">Summary</a></li>
										<li id="tabHeader_2"><a class="page-scroll">Graphic</a></li>
										<li id="tabHeader_3"><a class="page-scroll">Yearly
												Report</a></li>
										<li id="tabHeader_4"><a class="page-scroll">Survey</a></li>
									</ul>
								</div>
								<div class="panel-body" style = "padding: 8px;" id="tabscontent">
									<!--  <div class="panel-body" style = "padding: 8px;" id="tabpage_1" style="text-align: left;">-->
									<div class="panel-body" style = "padding: 8px;" id="tabpage_1">
										<br/><br /> <img id="img" src="${pic}" style="float: left;">

										<p align="left">
											You will run out of money at ${run_out} years old. This
											assumes annual retirement expenses of $<span
												id="retirement_spending"></span> which is
											${retirement_level}% of your last year's income of $<span
												id="lastyr_income"></span> .
										</p>
										<script>
											var retirement_spending = ${retirement_spending};
											var lastyr_income = ${lastyr_income};

											document
													.getElementById("retirement_spending").innerHTML = format(retirement_spending);
											document
													.getElementById("lastyr_income").innerHTML = format(lastyr_income);
										</script>

									</div>
									<!-- </div> -->
									<!-- pie chart -->
									<div class="panel-body" style = "padding: 8px;" id="tabpage_2">
									<br/>
									<br/>
						                <div class="panel panel-default" style = "text-align: left;">
						                    <p> <font color="#6698FF"><span>Inner Element:</span></font> Inner element is parent category of outer element, such as relationship between spending and education spending.</p>
						                    <p> <font color="#6698FF"><span>Percentage:</span></font> It indicates the percentage of current element in its source parent element.</p>
						                    <p> <font color="#6698FF"><span>Amount:</span></font> It indicates total amount of current element.</p>
						                </div>									
									
										<div class="panel-body" style = "padding: 8px;">
											<div id="main">
												<div id="sequence"></div>
												<div id="chart">
													<div id="explanation" style="visibility: hidden;">
														<span id="amount"></span><br /> <span id="percentage"></span><br />
														of visits begin with this sequence of pages
													</div>
												</div>
											</div>
											<div id="sidebar">
												<input type="checkbox" id="togglelegend"> Legend<br />
												<div id="legend" style="visibility: hidden;"></div>
											</div>
											<script type="text/javascript" src="js/sequences.js"></script>
											<script type="text/javascript">
												// Hack to make this example display correctly in an iframe on bl.ocks.org
												d3.select(self.frameElement).style("height","700px");
											</script>
										</div>
									</div>
									<!-- table start -->
									<div class="panel-body" style = "padding: 8px;" id="tabpage_3">
										<table class="table table-hover ">
											<tr>
												<td>Age</td>
												<td>Beginning Retirement Balance</td>
												<td>Investment Growth</td>
												<td>SSN &amp Pension</td>
												<td>Contributions at ${income_rate}% of Income</td>
												<td>Retire with ${retirement_level}& of Income</td>
												<td>Retirement Account Withdrawals</td>
												<td>Ending Retirement Balance</td>
											</tr>
											<c:forEach var="formBean" items="${formBeans}">
												<tr>
													<td>${formBean.age}</td>
													<td><fmt:formatNumber value="${formBean.beginretirementbalance}" type="currency" /></td>
													<td><fmt:formatNumber value="${formBean.investmentgrowth}" type="currency" /></td>
													<td><fmt:formatNumber value="${formBean.ssn}" type="currency" /></td>
													<td><fmt:formatNumber value="${formBean.saving}" type="currency" /></td>
													<td><fmt:formatNumber value="${formBean.retirementspend}" type="currency" /></td>
													<td><fmt:formatNumber value="${formBean.accountspending}" type="currency" /></td>
													<td><fmt:formatNumber value="${formBean.total}" type="currency" /></td>
												</tr>

											</c:forEach>
										</table>
									</div>
									<!-- survey -->
									<div class="panel-body" style = "padding: 8px;" id="tabpage_4">
										<!-- <div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseTwo"> survey </a>
								</h4>
							</div><div id="collapseTwo" class="panel-collapse collapse">-->
										<br/><br />
										<div class="panel-heading" style="text-align: left;">
											<p>Please help us do a quick survey with no more than 5
												minutes. You would have chance to win $10 Amazon gift card.
												Lucky draw will be on August 28, 2015. We would contact you
												with email address you have entered</p>
										</div>
										<div class="panel-body" style = "padding: 8px;" id="fund_list">
											<jsp:include page="error.jsp" />
											<form method="POST" action="survey.do">
												<div id="email" class="panel-body" style = "padding: 8px;">
													<span class="help-block" style="text-align: left;">Please
														provide us your email:</span>
													<div class="col-lg-6" style="text-align: left;">
														<input type="email" name="email"
															placeholder="example@abc.com">
													</div>
												</div>

												<div id="question1" class="panel-body" style = "padding: 8px;">
													<span class="help-block" style="text-align: left;">1.Currently,
														Do you have financial plan?</span>
													<div class="col-lg-6" style="text-align: left;">
														<label class="radio"> <input type="radio"
															name="surveyq1" value="Yes">A. Yes
														</label> <label class="radio"><input type="radio"
															name="surveyq1" value="No">B. No </label><label
															class="radio"><input type="radio" name="surveyq1"
															value="not really">B. Not really </label>
													</div>
												</div>
												<div id="question2" class="panel-body" style = "padding: 8px;">
													<span class="help-block" style="text-align: left;">2.Would
														you mind connecting your account to financial plan website
														to get financial services in return?</span>
													<div class="col-lg-6" style="text-align: left;">
														<label class="radio"><input type="radio"
															name="surveyq2" value="Yes, I am willing to">A.
															Yes, I am willing to </label> <label class="radio"><input
															type="radio" name="surveyq2"
															value="only well-known website or bank website">B.
															Well-known website or bank website</label> <label class="radio"><input
															type="radio" name="surveyq2"
															value="Only the website I trust">C. Only the
															website I trust</label> <label class="radio"><input
															type="radio" name="surveyq2" value="I won't">D.
															No, I won't</label>
													</div>
												</div>
												<div id="question3" class="panel-body" style = "padding: 8px;">
													<span class="help-block" style="text-align: left;">3.What
														kind of financial service are you looking for?</span>
													<div class="col-lg-6" style="text-align: left;">
														<textarea cols="70" rows="5" name="surveyq3"></textarea>
													</div>
												</div>
												<div id="question4" class="panel-body" style = "padding: 8px;">
													<span class="help-block" style="text-align: left;">4.
														What suggestions do you have for us?</span>
													<div class="col-lg-6" style="text-align: left;">
														<textarea cols="70" rows="5" name="surveyq4"></textarea>
													</div>
												</div>

												<input type="submit" class="btn btn-primary btn-block flat"
													name="action" value="submit" />
											</form>
										</div>
									</div>
									<!-- </div> -->



								</div>
                            </div>
						</div>
						<script src="js/tabs_old.js"></script>
						<script type="text/javascript">
							var _gaq = _gaq || [];
							_gaq.push([ '_setAccount', 'UA-1332079-8' ]);
							_gaq.push([ '_trackPageview' ]);

							(function() {
								var ga = document.createElement('script');
								ga.type = 'text/javascript';
								ga.async = true;
								ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
								var s = document.getElementsByTagName('script')[0];
								s.parentNode.insertBefore(ga, s);
							})();
						</script>

						<!-- this is the google chart-->
						<!--  <div class="panel panel-default">
							<div class="panel-body" style = "padding: 8px;">
								<div id="chart_div" style="height: 450px;"></div>

							</div>
						</div>-->


					</div>
                    <!-- left_chart end -->


					<!-- right_div start -->
					<div class="col-lg-3" id="right_div">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b>Suggestions for you</b>
							</div>
							<div class="panel-body" style = "padding: 8px;" style="text-align: left;">
								<p>
								<span style="text-align: left;">To help meet your goal, you may wish to do the
										following:</span>
								</p>
								<p>
									<span style="text-align: left;">1. Increase your rate of
										return before retirement from <font color="#6698FF">${rate_before}%
									</font> to <font color="#6698FF">${recommand_rate}% </font>.
									</span>
								</p>
								<p>
									<span style="text-align: left;">2. Reduce your
										retirement level to <font color="#6698FF">${recommand_retirement_level}%</font>
										of your final year's income.
									</span>
								</p>
								<p>
									<span style="text-align: left;">3.Increase contributions
										to <font color="#6698FF">${rec_saving_rate}%</font> of your
										income
									</span>
								</p>
								<p>
									<span style="text-align: left;">4. Delay your retirement
										until age <font color="#6698FF">${rec_retirement_age}</font>
									</span>
								</p>
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
