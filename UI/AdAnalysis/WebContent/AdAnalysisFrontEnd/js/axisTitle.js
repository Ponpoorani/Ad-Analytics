function myFunction() {
	$.ajax({
		url : "http://localhost:8181/AdAnalysis/TestServlet?data=SBagul",
		type : "POST",
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

function axisData() {
	var data2 = [];
	$.ajax({
		url : "http://localhost:8181/AdAnalysis/GetJSONArrayBids?data=Poo",
		type : "POST",
		data : "Poorani",
		async : false,
		success : function(frmS) {
			alert(frmS.listVal);
			data2 = frmS.listVal;
		},
		error : function(frmS) {
			alert('error');
		}
	});
	var data = [];
	data.push(345);
	data.push(2100);
	data.push(345);
	data.push(345);
	return data2;
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
