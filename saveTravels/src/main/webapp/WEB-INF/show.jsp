<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>

</head>
<body>
	<div>
		<p><a href="/expenses">Go Back</a></p> 
	</div>
	
	<div>
		<h1>Expense Details</h1>
		
		<p>Expense Name: <c:out value="${expense.expense}"/></p>
		<p>Expense Description: <c:out value="${expense.description}"/> </p>
		<p>Vender: <c:out value="${expense.vender}"/></p>
		<p>Amount Spent: <c:out value="${expense.amount}"/> </p>
		
		
	</div>

</body>
</html>