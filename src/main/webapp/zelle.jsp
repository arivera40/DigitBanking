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
		<h1>Select Recipient</h1>
		<p>All Recipients</p>
		<div class="new-contact">
			<a href="${pageContext.request.contextPath}/zelle/add-contact">New Contact</a>
		</div>
		<form method="post">
			<table>
				<c:forEach items="${contacts}" var="contact">
			        <tr class="contact-info">
			            <td>
			            	<button type="button"
			            		name="contact_id"
			            		value="${contact.getContactId()}"
								data-receiver-id="${contact.getReceiverId()}">
			            		${contact.getContactName()}
			            	</button>
			            </td>
			        </tr>
		        </c:forEach>
	        </table>
			<input type="hidden" name="contact_name" value="">
			<input type="hidden" name="contact_id" value="">
			<input type="hidden" name="receiver_id" value="">
        </form>
	</div>
</body>
</html>