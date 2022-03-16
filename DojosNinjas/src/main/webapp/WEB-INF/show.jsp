<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninjas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

  <div id="container">
  <h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
     <table class="table">
        <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dojo.ninjas}" var="ninja">
            <tr>
                <td><c:out value="${ninja.firstName}"/></td>
                <td><c:out value="${ninja.lastName}"/></td>
                <td><c:out value="${ninja.age}"/></td>
             </tr>
             </c:forEach>
         </tbody>
     </table>
  </div>

</body>
</html>