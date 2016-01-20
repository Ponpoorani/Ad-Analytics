function myFunction() {
	$.ajax({
		url : "http://localhost:8181/AdAnalysis/TestServlet?data=Poo",
		type : "POST",
		crossDomain : true,
		data : "Poorani",
		async : false,
		success : function(frmS) {
			name = String(frmS);

		},
		error : function(frmS) {
			alert('error');
		}
	});
	return name;
}

function axisData(advId) {
	jQuery.support.cors = true;
	var data2 = [];
	$.ajax({
		url : "http://localhost:8181/AdAnalysis/GetJSONArrayBids?advId="
				+ advId,
		type : "POST",
		data : "Poorani",
		crossDomain : true,
		async : false,
		success : function(frmS) {
			data2 = frmS.listVal;
		},
		error : function(frmS) {
			alert('error');
		}
	});
	return data2;
}

function pieChartData() {
	jQuery.support.cors = true;
	var data2 = [];
	var advId = document.getElementById("advId").value;
	var pageId = document.getElementById("pageId").value;
	var selection = document.getElementById("sectorDrpDown").value;
	jQuery.support.cors = true;
	$.ajax({
		url : "http://localhost:8181/AdAnalysis/GetPieChartData?advId=" + advId
				+ "&pageId=" + pageId,
		type : "POST",
		crossDomain : true,
		data : {
			advId : advId,
			pageId : pageId,
			selection : selection
		},
		async : false,
		success : function(frmS) {
			data2 = frmS.keyVal;
		},
		error : function(frmS) {
			alert('error');
		}
	});
	return data2;
}

function predictUser() {
	var advId = document.getElementById("advId").value;
	var region = document.getElementById("sectorDrpDown").value;
	var adType = document.getElementById("adTypeDrpDown").value;
	var gender = document.getElementById("genderDrpDown").value;

	var autoI = 0;
	var eduI = 0;
	var litI = 0;
	var newsI = 0;
	var entI = 0;

	if (document.getElementById("autoMobileCheckBox").checked) {
		autoI = 1;
	}
	if (document.getElementById("educationCheckBox").checked) {
		eduI = 1;
	}
	if (document.getElementById("literatureCheckBox").checked) {
		litI = 1;
	}
	if (document.getElementById("newsCheckBox").checked) {
		newsI = 1;
	}
	if (document.getElementById("entertainmentCheckBox").checked) {
		entI = 1;
	}

	var label;
	jQuery.support.cors = true;
	$.ajax({
		url : "http://localhost:8181/AdAnalysis/PredictUser",
		type : "POST",
		dataType : "json",
		crossDomain : true,
		data : {
			advId : advId,
			region : region,
			adType : adType,
			gender : gender,
			autoI : autoI,
			eduI : eduI,
			litI : litI,
			newsI : newsI,
			entI : entI
		},
		async : false,
		success : function(frmS) {
			label = frmS.label;
		},
		error : function(frmS) {
			alert('error' + frmS.responseText);
		}
	});
	if (label == 1) {
		document.getElementById("predictLabel").value = "Yes , Viewer is potential candidate to click an Advertisement"
		document.getElementById("predictLabel").style.color = "green";
	} else {
		document.getElementById("predictLabel").value = "Sorry, Viewer is not potential candidate to click an Advertisement , Good Luck Next Time"
		document.getElementById("predictLabel").style.color = "red";
	}
}

function getTp() {

	// generate an array of random data
	var data = [];
	data.push(345);
	data.push(2100);
	data.push(345);
	data.push(345);
	return data;
}

function checkLoader(a) {
	if (null != a && 'null' != a) {
		drawBarChart(a);
	}
}

function drawBarChart(a) {
	var advId;
	if (null == document.getElementById("advId")
			|| 'null' == document.getElementById("advId")) {
		advId = a;
	} else {
		advId = document.getElementById("advId").value;
	}
	$('#container').highcharts({
		chart : {
			type : 'column',
			margin : [ 50, 50, 100, 80 ]
		},
		title : {
			text : 'Advertiser Analysis for Day'
		},
		xAxis : {
			categories : [ 'Bids/Day', 'Impressions', 'Clicks', 'Converts' ],
			labels : {
				rotation : -45,
				align : 'right',
				style : {
					fontSize : '13px',
					fontFamily : 'Verdana, sans-serif'
				}
			}
		},
		yAxis : {
			min : 0,
			title : {
				text : 'Total Count / Day'
			}
		},
		legend : {
			enabled : false
		},
		tooltip : {
			pointFormat : 'Total Count: <b>{point.y:.1f} </b>',
		},
		series : [ {
			name : 'Count',
			data : axisData(advId),
			dataLabels : {
				enabled : true,
				rotation : -90,
				color : '#FFFFFF',
				align : 'right',
				x : 4,
				y : 10,
				style : {
					fontSize : '13px',
					fontFamily : 'Verdana, sans-serif',
					textShadow : '0 0 3px black'
				}
			}
		} ]
	});
}

function adGeneralControl() {

	document.getElementById("container").style.visibility = "hidden";
	document.getElementById("sector").style.visibility = "hidden";
	document.getElementById("sectorDrpDown").style.visibility = "hidden";
	document.getElementById("pageId").value = "bar";
	document.getElementById("headerText").value = "Day Inspection: Bids-->Impressions-->Clicks-->Converts";

}

function adCategoryControl() {
	document.getElementById("container").style.visibility = "hidden";
	document.getElementById("sector").style.visibility = "";
	document.getElementById("sectorDrpDown").style.visibility = "";
	document.getElementById("headerText").value = "Region Wise Analysis";

	document.getElementById("pageId").value = "cat";

}

function adRegionControl() {
	document.getElementById("container").style.visibility = "hidden";
	document.getElementById("sector").style.visibility = "";
	document.getElementById("sectorDrpDown").style.visibility = "";
	document.getElementById("headerText").value = "Ad Category Wise Analysis";

	document.getElementById("pageId").value = "reg";

}

function drawChart() {

	var pageId = document.getElementById("pageId").value;
	if (pageId == 'bar') {
		drawBarChart();
	} else {
		drawPieChart();
	}
	document.getElementById("container").style.visibility = "";

}

function drawPieChart() {
	$('#container').highcharts({
		chart : {
			plotBackgroundColor : null,
			plotBorderWidth : null,
			plotShadow : false
		},
		title : {
			text : 'Percentage Analysis of an Advertiser'
		},
		tooltip : {
			pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : 'pointer',
				dataLabels : {
					enabled : true,
					color : '#000000',
					connectorColor : '#000000',
					format : '<b>{point.name}</b>: {point.percentage:.1f} %'
				}
			}
		},
		series : [ {
			type : 'pie',
			name : 'Percentage',
			data : pieChartData()
		} ]
	});
}
