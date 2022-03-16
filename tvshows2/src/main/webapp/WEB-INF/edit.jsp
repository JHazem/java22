<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous">
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

<div class="container"></br>
	 <h3> <c:out value="${tvshow.show}"/></h3></br>
	  <button><a href="/logout">logout</a></button>
	 <button><a href="/tvshows">3333 Back to Dashboard  </a></button></br></br>

	<div class="container">
	<form:form action="/tvshows/${tvshow.id}" modelAttribute="tvshow" class="form" method="post">
			<input type="hidden" name="_method" value="put"/>
			<form:hidden value="${tvshow.user.id}" path="user"/>
				<div class="form-row">
				
		        <c:out value="${error}"/>  
				<form:label path="show" for="show">Title:</form:label>
			 	<form:errors path="show" class="error"/>
				<form:input path="show" type="text" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label path="netWork" for="netWork">NetWork:</form:label>
				<form:errors path="netWork" class="error"/>
				<form:input path="netWork" type="text" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label path="description" for="description">Description:</form:label>
				<form:errors path="description" class="error"/>
				<form:textarea path="description" class="form-control"/>
			</div>
						
			<div></br></br>
			<button><a href="/tvshows">Cancel</a></button>
			
				<input type="submit" value="Submit" >
			</div>
			 </form:form>
		</div></br></br>
 				<div >
 			<button style="background-color:Red;" >
				<a href="/tvshows/delete/<c:out value="${tvshow.id}"/>">Delete</a>  <!-- Delete Link -->						
	  		</button>
			</div>	
</div>
</body>
</html>