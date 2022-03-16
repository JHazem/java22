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
	 <h3> Change <c:out value="${babyName.babyName}"/></h3></br> 
	<div class="container">
	
	<form:form action="/babyNames/${babyName.id}" modelAttribute="babyName" class="form" method="post">
			<!-- <input type="hidden" name="_method" value="put"/> -->
			<form:hidden path="user"   name="_method" value="${babyName.user.id}"/>
				
				<div class="form-row">
				
				<%--   <c:out value="${error}"/>   --%>
				
				<form:label path="babyName" for="babyName">Baby Name:</form:label>
			 	<form:errors path="babyName" class="error"/>
				<form:input path="babyName" type="text" class="form-control"/>
			</div>
			
			 <!-- Select Form  -->
	         	 <h5>
	               <form:label  path="gender"> Gender: </form:label>
	                 <form:select  path="gender"> 
	                        <form:option value="male">Male </form:option> 
	                        <form:option value="femal">Female </form:option> 
	                        <form:option value="other">Other </form:option> 
 
	           		</form:select>
	            </h5>  
				<!--  /Select Form -->
			
			<div class="form-row">
				<form:label path="origin" for="origin">Origin:</form:label>
				<form:errors path="origin" class="error"/>
				<form:textarea path="origin" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label path="meaning" for="meaning">Meaning:</form:label>
				<form:errors path="meaning" class="error"/>
				<form:textarea path="meaning" class="form-control"/>
			</div>
						
			<div></br></br>
			<button><a href="/babyNames">Cancel</a></button>
			
				<input type="submit" value="Submit" >
			</div>
			 </form:form>
		</div></br></br>
 				<div >
 			<button style="background-color:Red;" >
				<a href="/babyNames/delete/<c:out value="${babyName.id}"/>">Delete</a>  <!-- Delete Link -->						
	  		</button>
			</div>	
</div>
</body>
</html>