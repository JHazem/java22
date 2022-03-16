<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
  <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Lender Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
	<div class="container">
 <!-- change variable to login user -->
	<h3>Hello ${thisUser.name}  welcome to ..</h3>
	
		<h1>The Book Borker!</h1>
		
			<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Auther Name</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<div>
					<c:forEach var="book" items="${books}">	
					
						<tr>
							<td>
								<a href="/books/borrow/${books.id}">
									<c:out value="${book.name}"/>
								</a>
							</td>
						 
							    <td>99 ${book.id}</td>
								<td>88 ${book.title}</td>
								<td>77 ${book.auther}</td>
								<td>66 ${book.owner}</td>
							  
							<td><a href="/books/borrow/${book.bookId}"> borrow 11</a></td>
							
							<%--  <td>
								<a href="/books/edit/${book.id}"> edit </a>
		
					 		<button style="background-color:Red;">
					 			<a href="/books/delete/<c:out value="${book.id}"/>">Delete</a>  						
		  					</button> 
					     	 </td>
					     	 
						 	 --%>      
						</tr>
					</c:forEach>
				</div>
			</tbody>			
			</table>
	</div>
	
	
	<!-- Borrow Book table -->
	
	
</body>
</html>