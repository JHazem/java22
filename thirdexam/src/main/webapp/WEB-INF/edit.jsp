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
	 <h3> Change <c:out value="${song.songTitle}"/></h3></br> 
	<div class="container">
	
	<form:form action="/songs/${song.id}" modelAttribute="song" class="form" method="post">
			<!-- <input type="hidden" name="_method" value="put"/> -->
			<form:hidden path="user"   name="_method" value="${song.user.id}"/>
				<div class="form-row">
				
				<%--   <c:out value="${error}"/>   --%>
				
				<form:label path="songTitle" for="songTitle">Song Name:</form:label>
			 	<form:errors path="songTitle" class="error"/>
				<form:input path="songTitle" type="text" class="form-control"/>
			</div>
			
		 <!-- Number of coll -->
			<form:hidden path="coll"   name="_method" value="${song.coll}"/>
		 
		 
			<div class="form-row">
				<form:label path="genre" for="genre">Genre:</form:label>
				<form:errors path="genre" class="error"/>
				<form:textarea path="genre" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label path="lyrics" for="lyrics">Add your lyrics:</form:label>
				<form:errors path="lyrics" class="error"/>
				<form:textarea path="lyrics" class="form-control"/>
			</div>
						
			<div></br></br>
			 <a href="/songs" class="btn btn-primary">Cancel</a> 
			
				<input type="submit" value="Submit" class="btn btn-primary">
			</div>
			 </form:form>
		</div></br></br>
 				<div >
 			<button style="background-color:Red;" >
				<a href="/songs/delete/<c:out value="${song.id}" />" >Delete</a>   						
	  		</button>
			</div>	
</div>
</body>
</html>