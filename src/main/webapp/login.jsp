<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Digit Banking Login</title>
</head>
<body>
	<div class="main-container container-fluid registration">
		<form action="login" method="post">
			<h1>DigitBanking Login!</h1>
			<p>Please fill out the fields below to login.</p>
			<div class="form-container">
				<div class="form-input">
					<label for="email">Email</label>
					<input type="text" id="email" name="email" required>
				</div>
				<div class="form-input">
					<label for="***REMOVED***">Password</label>
					<input type="***REMOVED***" id="***REMOVED***" name="***REMOVED***" required>
				</div>
				<div class="form-action">
					<button type="submit">Login</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>