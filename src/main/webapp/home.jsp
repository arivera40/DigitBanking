<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DigitBanking Home</title>
</head>
<body>
    <header>
        <!-- Header content -->
        <div class="header-sec">
        	<div class="account-tools">
        		
        	</div>
        	<div class="logo-sec">
        		<h1 class="logo">
        			DigitBanking
        		</h1>
        	</div>
        </div>
    </header>
    
    <nav>
    	<div class="nav-menu">
    		<!-- Navigation links (CTA buttons) -->
    		<div class="nav-item account-btn">
    			<a href="ProfileServlet">Account</a>
    		</div>
    		<div class="nav-item deposit-btn">
	        	<a href="AccountsServlet">Deposit</a>
	        </div>
	        <div class="nav-item withdraw-btn">
	        	<a href="TransactionsServlet">Withdraw</a>
	        </div>
	        <div class="nav-item transfer-btn">
	        	<a href="TransactionsServlet">Transfer</a>
	        </div>
        <!-- Add more links as needed -->
    	</div>
    </nav>
    
    <main>
        <!-- Main content area -->
        <div class="main-container container-fluid home">
        	<h1>Welcome back Andy!</h1>
        	<div class="two-col">
        		<div class="left-col">
        			<div class="savings-icon">
        				icon
        			</div>
        			<div class="savings-btn">
        				Open Savings Account Now!
        			</div>
        		</div>
        		<div class="right-col">
        			<p>
        				Open a savings account with us and receive monthly deposits of 3% of your total savings!
        			</p>
        		</div>
        	</div>
       	</div>
        <!-- Display user-specific information or actions -->
    </main>
    
</body>
</html>