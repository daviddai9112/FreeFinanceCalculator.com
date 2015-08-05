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
					<div class="col-lg-12" id="top_content">
						<div class="panel panel-default">
							<div class="panel-body">
								<div id="forecast_img" class="col-lg-2">
									<img id="img" src="img/sun.png" style="float: center;">
								</div>
								<div id="text"
									style="font-size: 25px; color: #D1D0CE; float: left; font-family: Arial"
									class="col-lg-10">
									You will run out of money at ${run_out} years old.
									<div id="text"
										style="font-size: 20px; color: #D1D0CE; font-family: Arial; text-align: left;">

										You're in <font color="#6698FF">excellent shape</font>. Your
										average income in retirement is expected to exceed spending
										goals, so you probably won't need to draw meaningfully on your
										portfolio.
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- top_content end -->



					<!-- here is the left_chart -->
					<div class="col-lg-4" id="left_chart">
						<div class="panel panel-default">
							<div class="panel-body">
								<div id="chart_div" style="height: 450px;"></div>
								<!-- this is the google chart-->
							</div>
						</div>
					</div>
					<!-- left_chart end -->


					<!-- right_div start -->
					<div class="col-lg-4" id="right_div">

						<!-- the way to directly go to some page -->
						<!--  
						<div class="col-lg-8">&nbsp;</div>
						<div class="dropdown col-lg-4">
							<a class="dropdown-toggle" aria-haspopup="true" role="button"
								data-toggle="dropdown" href="#" aria-expanded="false">GO TO<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic info</a></li>
							</ul>
						</div>
						-->
						<!-- the way to directly go to some page end-->




						<div id="editor"></div>

					</div>
					<!--right_div end-->
					<!--form-->
					<div class="col-lg-8">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseTwo"> show table </a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
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






	<div id="store">
		<input type="hidden" value="50000" id="store_money_saved"> <input
			type="hidden" value="100000" id="store_income"> <input
			type="hidden" value="30" id="store_cur_age"> <input
			type="hidden" value="67" id="store_retire_age"> <input
			type="hidden" value="0.05" id="store_saving_rate"> <input
			type="hidden" value="0.05" id="store_income_increase_rate"> <input
			type="hidden" value="1" id="store_pension"> <input
			type="hidden" value="1" id="store_pension_age"> <input
			type="hidden" value="1" id="store_pension_amount"> <input
			type="hidden" value="1" id="store_eligible_SSN"> <input
			type="hidden" value="1" id="store_SSN_age"> <input
			type="hidden" value="1" id="store_SSN_amount"> <input
			type="hidden" value="1" id="store_partner_eligible"> <input
			type="hidden" value="1" id="store_partner_pension"> <input
			type="hidden" value="1" id="store_partner_pension_age"> <input
			type="hidden" value="1" id="store_partner_pension_amount"> <input
			type="hidden" value="1" id="store_partner_eligible_SSN"> <input
			type="hidden" value="1" id="store_partner_SSN_age"> <input
			type="hidden" value="1" id="store_partner_SSN_amount"> <input
			type="hidden" value="1" id="store_dependent"> <input
			type="hidden" value="1" id="store_pay_college"> <input
			type="hidden" value="1" id="store_pay_wedding">
	</div>




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
