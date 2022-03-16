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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
</br> 
<div class="container">

	<h1>Create an Story</h1>
	
		 <a href="/home" class="btn btn-primary"> Home </a> 
		 <a href="/logout" class="btn btn-primary">logout</a> 
	 <a href="/stories" class="btn btn-primary">Back </a> 
	<div class="container">
		<form:form action="/stories" modelAttribute="addNewStory" class="form" method="post">
			<form:hidden path="user" value= "${thisUser.id}"/>
			
			<div class="form-row">
				<form:label  path="title" for="title">Title:</form:label>
			 	<form:errors path="title" class="error"/>
				<form:input  path="title" type="text" class="form-control"/>
			</div>
			
	 
			<div class="form-row">
				<form:label  path="content" for="content">Story Content:</form:label>
				<form:errors path="content" class="error"/>
				<form:input  path="content" type="text" class="form-control"/>
			</div></br>
			
			<div>
				<h4>
                    <label name="myplace"> Choose Place: </label>
                      <select name="myplace">
                          <c:forEach items="${places}" var="d">
                             <option value="${d.id}">
                             	<c:out value="${d.placeName}"/>
                             </option>
                    		 </c:forEach>
                		</select>     or
                		<a href="/places/new" style = "position:relative; left:30px; top:2px;" class="btn btn-primary">   Add place </a>
                 </h4> 
			
			</div>
			<div>
				  <label for="posted" >Posted Date:</label>
				  <input type="date" id="birthday" name="posted">
				  
				</div></br>
				 
				
 			<div>
				 <a href="/stories" class="btn btn-primary">Cancel</a> 
				<input type="submit" value="submit" class="btn btn-primary" >
			</div>
			 </form:form>
	</div> 
</div>




</body>
</html>



















