<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/behaviors.js"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap.css">
</head>
<meta charset="ISO-8859-1">
<title>Zelle Add Contact</title>
</head>
<body>
	<div class="main-container container-fluid add-contact">
		<form method="post">
			<h1>Add Contact</h1>
			<div class="form-container">
			  	<div class="form-input">
					<label for="contact_name">Contact Name</label>
					<input type="text" id="contact_name" name="contact_name" required>
				</div>
				
				<div class="form-input">
					<label for="email">Email</label>
					<input type="text" id="email" name="email" required>
				</div>
				
				<div class="form-input">
					<label for="phone_number">Phone Number</label>
					<input type="text" id="phone_number" name="phone_number" required>
				</div>
				
				<div class="form-action">
					<button type="button" id="webform-back">Back</button>
				</div>
			  	
				<div class="form-action">
					<button type="submit" id="webform-submit">Send</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>