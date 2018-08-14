<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipment JSP</title>
<script>
function sendInfo(){  
	
var to =  document.createShipment.toCities.value;
var from = document.createShipment.fromCities.value;
var url = 'CitiesServlet?fc=' + from + '&tc=' + to;

	
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
} else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  


try {  
	
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  

}catch(e)  {  
alert("Unable to connect to server");  
}  
}  
  
function getInfo(){  
		
  if (request.readyState==4) {
     var val=request.responseText;  
    
     document.getElementById('miles').innerHTML=val;  
    }
}
</script>
</head>
<body>

	<h3>Check the items that you want to include in this shipment.</h3>
	<br>

	<form name='createShipment' action="ShippingServlet" method="Post">

		<table border='1'>
			<c:forEach var="item" items="${sessionScope.items}">
				<tr>
					<td><input id="checkedRows" name="checkedRows" type="checkbox"
						value="${item.upc}"></td>
					<td>${item.upc}</td>
					<td>${item.description}</td>
					<td>${item.price}</td>
					<td>${item.weight}</td>
					<td>${item.shippingType}</td>
				</tr>
			</c:forEach>
		</table>
		<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <br> <select
			id="availableEmployees" name="availableEmployees">
			<c:forEach var="employees" items="${employees}">
				<option value="${employees.empId}">${employees.firstName}   ${employees.lastName}</option>
			</c:forEach>
		</select> <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

		<h3>Ship From:</h3>
		<select id="fromCities" name="fromCities">
			<c:forEach items="${cities}" var="city" begin='0' end='2'>
				<option value="${city}">${city}</option>
			</c:forEach>
		</select>
		<h3>Ship To:</h3>
		<select id="toCities" name="toCities" onChange="sendInfo();">
			<c:forEach var="city" items="${cities}">
				<option value="${city}">${city}</option>
			</c:forEach>
		</select> 
		<br> &nbsp&nbsp&nbsp<span>This shipment will travel: <mark id="miles">XXXX</mark> miles!</span><br><br><br>
		<input type='submit' value="Create Shipment">
	</form>
</body>
</html>