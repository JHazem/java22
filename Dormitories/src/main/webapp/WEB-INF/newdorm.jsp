    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>New Dormitories</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
   <div class="container">
      <div>
          <h1>Dormitories</h1>
           
          <form:form action="/new/dorms" method="post" modelAttribute="addNewDorm">                  
              <h2>
                  <form:label path="dormName">Name:</form:label>
                  <form:input path="dormName"/>
              </h2>
              <input type="submit" value="Create"/>  
              <a href="/students/new"> Add New Student </a> 
              <a href="/show"> Go to Table </a>     
          </form:form>
      </div>
      <div>
      		<form:errors path="addNewDorm"/>
       </div>
	</div>
</body>
</html>