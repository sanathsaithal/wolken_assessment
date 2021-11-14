<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="save"><button type="button" class="btn btn-outline-info">Insert Mobile Details</button></a>
<a class="navbar-brand" href="getByPrice"><button type="button" class="btn btn-outline-info">Get By Price</button></a>
<a class="navbar-brand" href="getByBrand"><button type="button" class="btn btn-outline-info">Get By Brand</button></a>
<a class="navbar-brand" href="updatePriceByModelNo"><button type="button" class="btn btn-outline-info">Update Price By Model No</button></a>
<a class="navbar-brand" href="updateAvailabilityByModel"><button type="button" class="btn btn-outline-info">Update Availability By ModelName</button></a>
<a class="navbar-brand" href="home"><button type="submit" class="btn btn-outline-info">HOME</button></a>
</nav>
<div class="container">
<table class="table table-striped">
<tr>
	<th>BrandName</th>
	<th>ModelNo</th>
	<th>ModelName</th>
	<th>Type</th>
	<th>RAM</th>
	<th>ROM</th>
	<th>Price</th>
	<th>Availability</th>
	</tr>
	<c:forEach var="item" items="${list}">
	<tr>
	<td>${item.brandName}</td>
	<td>${item.modelNo}</td>
	<td>${item.modelName}</td>
	<td>${item.type}</td>
	<td>${item.ram}</td>
	<td>${item.rom}</td>
	<td>${item.price}</td>
	<td>${item.availability}</td>
	</tr>
	</c:forEach>
	</table>
	
</div>
</body>
</html>

