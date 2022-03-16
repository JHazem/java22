    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>New Dojo</title>
</head>
<body>
   <div id="container">
      <div>
          <h1>New Dojo</h1>
          <form:form action="/newdojo1" method="post" modelAttribute="addNewDojo">                  
              <h2>
                  <form:label path="name">Name:</form:label>
                  <form:input path="name"/>
              </h2>
              <input type="submit" value="Create"/>         
          </form:form>
      </div>
      <div>
      		<form:errors path="addNewDojo"/>
       </div>
	</div>
</body>
</html>





