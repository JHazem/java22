    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>New Student</title>
</head>
<body>
      <div class="container">
 
      <div>
          <h1>New Student</h1>
                 
		         <form:form action="/students/add" method="post" modelAttribute="addNewStudent">                  
              <h2>
                  <form:label path="firstName">First Name:</form:label>
                  <form:input path="firstName"/>
              </h2>
              <h2>
                  <form:label path="lastName">Last Name:</form:label>
                  <form:input path="lastName"/>
              </h2>
              
              <input type="submit" value="Create"/>  
               <a href="/dorms/new"> Add Dormitory </a> 
                <a href="/show"> Go to Table </a> 
          </form:form>
      </div>
      <div>
      <div></div>
      		<form:errors path="addNewStudent"/>
       </div>
       
</body>
</html>       