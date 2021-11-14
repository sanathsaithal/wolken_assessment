<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/js/script.js"/>"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
<a class="navbar-brand" href="home"><button type="submit" class="btn btn-outline-info">HOME</button></a>
</nav>
	<div class="container">
		<form action="byPrice" method="post">

			<div class="form-group row">
				<div class="col-md-7 col-12">
					<h3>Search for mobile phone by your range</h3>


					<div class="form-group row">
					<div class="col-4">
						<label>Enter price: </label>
					</div>
					<div class="col">
						<input type="number" name="price"
							class="form-control-sm form-control"
							placeholder="Enter price"
							onblur="validatePrice()">
					</div>
					<div class="col"><label class="lblErr" id="errPrice"></label></div>
				</div>

					<div class="form-group row">
						<div class="col-5">
							<button type="submit" class="btn btn-outline-primary size" onclick="validateField()">SEARCH</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>