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
<title>Zelle Transfer</title>
</head>
<body>
	<div class="main-container container-fluid transfer">
		<form action="transfer" method="post">
			<h1>Select Recipient</h1>
			<p>All Recipients</p>
			<div class="new-contact">
				<a href="${pageContext.request.contextPath}/add-contact">New Contact</a>
			</div>
			<table>
				<c:forEach items="${contacts}" var="contact">
			        <tr class="contact-info" data-receiver-id="${contact.getUserId()}">
			            <td>${contact.getContactName()}</td>
			        </tr>
			    </c:forEach>
		    </table>
		</form>
	</div>
</body>
</html>