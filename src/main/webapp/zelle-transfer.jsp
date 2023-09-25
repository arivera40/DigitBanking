<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap.css">
</head>
<meta charset="ISO-8859-1">
<title>Zelle Transfer</title>
</head>
<body>
	<div class="main-container container-fluid transfer">
		<form method="post">
			<h1>Send</h1>
			<h2>${contact.getContactName()}</h2>
			<div class="form-container">
			  	<div class="form-input">
					<label for="amount">Amount</label>
					<input type="text" id="amount" name="amount" required>
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