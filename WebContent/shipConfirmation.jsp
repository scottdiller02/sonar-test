<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipment Confirmation JSP</title>
</head>
<body>

	<table border='1'>
		<c:forEach var="item" items="${sessionScope.shipItems}">
			<tr>
				<td>${item}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>&nbsp&nbsp
	<div id="shippedBy">Your order was shipped by employee number: <span id="empId">${employee}</span></div>
	<br>
	<div>The total cost of your shipment was: $<span id="totalCost">${total}</span></div>
	
<br><br>&nbsp&nbsp
<form name='home' action="index.html" >
  <input type='submit' value="Home">
</form>

</body>
</html>