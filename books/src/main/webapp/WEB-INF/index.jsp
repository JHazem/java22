<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
		
	<h1 id ="container">All Books</h1>
	
		<div class="container">
			<table class ="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Language</th>
					<th>#Pages</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">			
					<tr>
						<td>${book.id}</td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td>${book.description}</td>
						<td>${book.language}</td>
						<td>${book.numberOfPages}</td>
						
						
						<!-- delete -->				
						<td>
						    <form action="/books/${book.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
							</form>
						</td>
						
						<!-- Edit -->
						<td>
						    <form action="/books/${book.id}" method="get">
							    <input type="submit" value="Edit">
							</form>
						</td>
					
						
					</tr>

				</c:forEach>
				
				
			</tbody>			
			</table>
		</div>
 <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>