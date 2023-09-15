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
<title>Account Deposit</title>
</head>
<body>
	<div class="main-container container-fluid Deposit">
		<form action="deposit" method="post">
			<h1>Deposit</h1>
			<p>Please fill out the fields below to make a deposit.</p>
			<div class="form-container">
				<div class="form-input">
					<label for="selectedAccount">Select a Bank Account</label>
					<select name="selectedAccount" id="selectedAccount">
					    <c:forEach items="${accounts}" var="account">
					      <option value="${account.getAccountId()}">${account.getAccountType()}</option>
					    </c:forEach>
				  	</select>
			  	</div>
			  	
			  	<div class="form-input">
					<label for="amount">Amount</label>
					<input type="text" id="amount" name="amount" required>
				</div>
			  	
				<div class="form-action">
					<button type="submit">Deposit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>