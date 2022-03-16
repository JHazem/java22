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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
		
		<div class="container">
		<h1>All languages</h1>
	
			<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="language" items="${languages}">			
					<tr>
						<td>
							<a href="/languages/${language.id}">
								<c:out value="${language.name}"/>
							</a>
						</td> 
						
						<td>${language.creator}</td>
						<td>${language.version}</td>
						
						
						<!-- delete -->				
						<td>
							<a href="/languages/delete/<c:out value="${language.id}"/>">Delete</a>
							<a href="/languages/edit/${language.id}"> Edit </a>
						  <%-- 
						    	 - - give us Delete icon - -
						    <form action="/languages/${language.id}" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input type="submit" value="Delete">
						    </form> 
						    --%> 						
						</td>
					</tr>
				</c:forEach>
				
			</tbody>			
			</table>
			
			<form:form action="/languages/new" method="post" modelAttribute="addNew">
				<div>
					<form:label path ="name"> Name</form:label>
					<form:errors path ="name" class="text-danger"/>
					<form:input path="name"/>
				</div>
				
				<div>
					<form:label path ="creator">Creator</form:label>
					<form:errors path ="creator" class="text-danger"/>
					<form:input path="creator"/>
				</div>
				
				<div>
					<form:label path ="version">Version</form:label>
					<form:errors path ="version" class="text-danger"/>
					<form:input path="version"/>
				</div>
	
	
				<input type="submit" value="send"/>
			</form:form>
	
			
		</div>
	   	
 <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>