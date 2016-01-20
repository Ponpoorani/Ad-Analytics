<%@page import="com.helper.RegionHelper"%>
<%@page import="com.servlets.AdvertiserLayer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>BullsEye- Insigthful Algorithms</title>



<!-- jQuery -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>



<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">



<!-- Custom Fonts -->
<link href="font-awesome-4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="js/highcharts.js"></script>
<script src="js/modules/exporting.js"></script>
<script type="text/javascript" src="js/scriptFunctions.js"></script>

</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<form>

				<table>
					<tr>
						<td><a class="navbar-brand"
							style="width: 160px; height: 48px;">Advertiser Id </a></td>

						<td><select id="advId" style="width: 80px; height: 22px;">
								<option>1458</option>
								<option>3358</option>
								<option>3386</option>
								<option>3427</option>
								<option>3476</option>
						</select></td>

						<td><a id="sector" class="navbar-brand"
							style="width: 90px; height: 48px;"> Region </a></td>
						<td><select id="sectorDrpDown"
							style="width: 110px; height: 22px;">
								<%
									RegionHelper rh = new RegionHelper();
									List<String> regions = rh.getRegions();
									for (String str : regions) {
								%>
								<option><%=str%></option>
								<%
									}
								%>
						</select></td>
						<td><a id="sector" class="navbar-brand"
							style="width: 90px; height: 48px;"> Gender </a></td>
						<td><select id="genderDrpDown"
							style="width: 50px; height: 22px;">
								<option>M</option>
								<option>F</option>
						</select></td>
						<td><a id="sector" class="navbar-brand"
							style="width: 140px; height: 48px;"> Ad Format </a></td>
						<td><select id="adTypeDrpDown"
							style="width: 120px; height: 22px;">
								<option>0(Fixed Slot)</option>
								<option>1(Pop Up)</option>
								<option>2(BackGround)</option>
								<option>3(Floating)</option>
								<option>4(NA)</option>
						</select></td>
						<td>
						<td><input type="button" onclick="predictUser()"
							value="Click To Analyze" style="margin-left: 50px; color: green">
						</td>
					</tr>
					<tr>
						<td><a id="sector" class="navbar-brand"
							style="width: 130px; height: 48px;"> Auto Mobile </a> <input
							id="autoMobileCheckBox" type="checkbox" style="margin-top: 15px;">
						</td>
						<td><a id="sector" class="navbar-brand"
							style="width: 110px; height: 48px;"> Education </a> <input
							id="educationCheckBox" type="checkbox" style="margin-top: 15px;">
						</td>
						<td><a id="sector" class="navbar-brand"
							style="width: 110px; height: 48px;"> Literature </a> <input
							id="literatureCheckBox" type="checkbox" style="margin-top: 15px;">
						</td>
						<td><a id="sector" class="navbar-brand"
							style="width: 70px; height: 48px;"> News </a> <input
							id="newsCheckBox" type="checkbox" style="margin-top: 15px;">
						</td>
						<td><a id="sector" class="navbar-brand"
							style="width: 140px; height: 48px;"> Entertainment </a> <input
							id="entertainmentCheckBox" type="checkbox"
							style="margin-top: 15px;"></td>
						<td></td>
					</tr>

				</table>
			</form>
		</div>

		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 id="headerText" class="page-header">
							<small>Target Right Viewer with Bullseye</small>
						</h1>
					</div>

					<div id="container"
						style="min-width: 310px; height: 400px; margin: 0 auto">
						<b>
						<input id="predictLabel" style="width: 1000px; height: 33px" class="navbar-brand"
							value="Predict if Viewer could find intrest in Advertisement using Naive Bayes Classification">
						</b>
					</div>

					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
	</div>
</body>

</html>