<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

  
<h1>Edit expense</h1>
<p><a href="/">Go Back</a></p> 
													 	 
	<form:form action="/expenses/${editExpense.id}" modelAttribute="editExpense" method="put" >
 
	    <p>
	        <form:label path="expense">ExpenseName:</form:label>
	        <form:errors path="expense" class="text-danger"/>
	        <form:input path="expense"/>
	    </p>
	    <p>
	        <form:label path="vender">Vender:</form:label>
	        <form:errors path="vender" class="text-danger"/>
	        <form:textarea path="vender"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount:</form:label>
	        <form:errors path="amount" class="text-danger"/>
	        <form:input path="amount"/>
	    </p>
	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description" class="text-danger"/>     
	        <form:input path="description"/>
	    </p>    
	    
	    <input type="submit" value="Submit"/>
	    
	   
	</form:form>


</body>
</html>