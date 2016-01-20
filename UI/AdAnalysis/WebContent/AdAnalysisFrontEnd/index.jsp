<%@page import="com.servlets.AdvertiserLayer"%>
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

<title>BullsEye DSP - Target Right Viewers</title>



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
							style="width: 335px; height: 48px;">Please select advertiser
								Id to Analyze</a></td>
			
						<td><select id="advId" style="width: 181px; height: 22px;">
								<option>null</option>
								<%
									AdvertiserLayer adv = new AdvertiserLayer();
									for (String str : adv.getIds()) {
								%>
								<option><%=str%></option>
								<%
									}
								%>


						</select></td>
						
						<td><a id="sector" class="navbar-brand"
							style="width: 175px; height: 48px; visibility: hidden">Sector to Analyze</a></td>
						<td><select id="sectorDrpDown" style="width: 140px; height: 22px; visibility: hidden">
							<option>Bids</option>
							<option>Impressions</option>
							<option>Clicks</option>
							<option>Converts</option>
						</select></td>
					
						<td>
							<input type="button" onclick="drawChart()"  value="Click To Analyze" style="margin-left: 50px; color: green">
						</td>
					</tr>
				</table>
			</form>
		</div>

		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li><a onclick="adGeneralControl()"><i
						class="fa fa-fw fa-bar-chart-o"></i> Bar Chart</a></li>
				<li><a onclick="adRegionControl()"> <i
						class="fa fa-fw fa-dashboard"></i> Region Wise Distribution
				</a></li>
				<li><a onclick="adCategoryControl()"><i
						class="fa fa-fw fa-dashboard"></i> Category Wise Distribution</a></li>
				<li><a href="naiveBayes.jsp" target="_blank"><i class="fa fa-fw fa-edit"></i>
						Insightful Algorithms</a></li>
			</ul>
		</div>
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
						style="min-width: 310px; height: 400px; margin: 0 auto"></div>
					<div>
						<form>
							<input id="pageId" style="width: 90px; height: 33px" type="hidden"
								value="bar">
						</form>
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