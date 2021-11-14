<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
<a class="navbar-brand" href="home"><button type="submit" class="btn btn-outline-info">HOME</button></a>
</nav>
<div class="container">
<form action="updateAvailabilityByModelName" method="post">
<div class="form-group row">
				<div class="col-md-7 col-12">
					<h3>Update Availability for particular Model name </h3>


					<div class="form-group row">
						<div class="col-4">
							<label>Enter Model Name: </label>
						</div>
						<div class="col">
							<input type="text" name="modelName"
								class="form-control-sm form-control"
								placeholder="Enter model name">
						</div>
					</div>
					<div class="form-group row">
					<div class="col-4">
						<label>Enter Availability: </label>
					</div>
					<div class="col">
                            <input type="radio" id="available1" name="availability" value="true">
                            <label for="contactChoice1">Available</label>
                            <input type="radio" id="available2" name="availability" value="false">
                            <label for="contactChoice2">Stock empty</label> 
				</div>
				</div>

					<div class="form-group row">
						<div class="col-5">
							<button type="submit" class="btn btn-outline-primary size">Save</button>
						</div>
					</div>
				</div>
			</div>
</form>
</div>
</body>
</html>