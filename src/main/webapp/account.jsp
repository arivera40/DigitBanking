<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accounts</title>
</head>
<body>
	<table>
	    <tr>
	        <th>Account Type</th>
	        <th>Balance</th>
	    </tr>
	    <c:forEach items="${accounts}" var="account">
	        <tr>
	            <td>${account.getAccountType()}</td>
	            <td>${account.getBalance()}</td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>