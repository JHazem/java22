    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>New Classes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

   <div class="container">
      <div>
          <h1>Classes</h1>
           
          <form:form action="/cshowlesson" method="post" >                  
              <h2>
                  <form:label path="lessonName">Name:</form:label>
                  <form:input path="lessonName"/>
              </h2>
              <input type="submit" value="Create"/>  
 
          </form:form>
      </div>
      <div>
      		<form:errors path="addNewDorm"/>
       </div>
	</div>
</body>
</html>