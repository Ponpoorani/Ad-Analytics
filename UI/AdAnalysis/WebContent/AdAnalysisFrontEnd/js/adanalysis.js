
function axisData() {
			$.ajax({
				url : "http://localhost:8181/AdAnalysis/GetJSONArrayBids?data=Poo",
				type : "POST",
				data : "Poorani",
				async: false,
				success : function(frmS) {
//					alert('I have success');
//					alert(frmS);
					return frmS.listVal;
//					alert(frmS.listVal);
//					var json = JSON.parse(frmS);
//					document.write(json)
//					alert(json);
//					list = json.listVal;	
//					document.write(list);
				},
				error : function(frmS) {
					alert('error');
				}
			});
//			return list;
		};
		
	
