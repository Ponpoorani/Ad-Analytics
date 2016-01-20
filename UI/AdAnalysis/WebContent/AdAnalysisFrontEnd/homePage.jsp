<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function myfun(a){
	alert('he he u changed bad act' + a);
}
</script>
</head>
<body>
	<form>
	<p><%=request.getParameter("name")%></p>
	
		<select style="width: 101px; " onchange="myfun('<%=request.getParameter("name")%>');">
		<%
		List<String> tpList = new ArrayList<String>();
		tpList.add("Poorani");
		tpList.add("Amir");
		tpList.add("Krishna");
		tpList.add("Mayur");
		
		String my = "y";
		for(String str:tpList){%>
		<option><%=str%></option>
		<%}
		 %>
		
		</select>
	</form>


	</body>
</html>