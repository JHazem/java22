<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
  <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

	
		<div class="container">
		<h1>Save Travels</h1>
		
			<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vender</th>
					<th>Amount</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<div>
				<c:forEach var="expense" items="${expenses}">			
					<tr>
						<td>
							<a href="/expenses/${expense.id}">
								<c:out value="${expense.expense}"/>
							</a>
						</td>
						
						<td>${expense.vender}</td>
						<td>${expense.amount}</td>
						<td>${expense.description}</td>
						<td>
							<a href="/expenses/edit/${expense.id}"> edit </a>
	
				 		<button style="background-color:Red;">
				 			<a href="/expenses/delete/<c:out value="${expense.id}"/>">Delete</a>  						
	  					</button> 
					 	      
				       </td>
					</tr>
				</c:forEach>
				</div>
			</tbody>			
			</table>
			 
			 <!--   form expense information-->
			 <h2>Add an expense:</h2>
			<form:form action="/expenses/new" method="post" modelAttribute="newExpense">

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
			 
		</div>

</body>
</html>