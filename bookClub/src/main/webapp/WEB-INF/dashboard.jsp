<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

  <div class="container">
  
  <h1> Welcome,  <c:out value="${user.name}"/></h1>
  
  
		<a href="/logout">logout</a></br>
		<a href="/books/new">1111 Add Book to my shelf</a>
		
		
     <table class="table">
        <thead>
            <tr>
	              <th>ID</th>
	              <th>Title</th>
	              <th>Auther Name</th>
	              <th>Posted By</th>
            </tr>
        </thead>
        
    	<tbody>
            <c:forEach items="${books}" var="book">
            <tr> 
            
                <td><c:out value="${book.id}"/></td>
                <td> <a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
                <td><c:out value="${book.autherName}"/></td>
                <td><c:out value="${book.user.name}"/></td>
             </tr>
             </c:forEach>
     
         </tbody>
      
     </table>
  </div>
 
</body>
</html>












