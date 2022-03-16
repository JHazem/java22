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
  
  
		<button><a href="/books/new">1111 Add Book to my shelf</a></button>
		<button><a href="/logout">logout</a></button>
		
		  <!-- header table -->
     <table class="table">
        <thead>
            <tr>
	              <th>ID</th>
	              <th>Title</th>
	              <th>Auther Name</th>
	              <th>Posted By</th>
            </tr>
        </thead>
     		 <!-- Body of table -->
    	<tbody>
            <c:forEach items="${books}" var="book">           <!-- To fill information inside the tavle -->
            <tr> 
            
                <td><c:out value="${book.id}"/></td>
                <td> <a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>  <!-- title Link -->
                <td><c:out value="${book.autherName}"/></td>
                <td><c:out value="${book.user.name}"/></td>
                <td>
				 		<button style="background-color:lightGray;">
				 			 <a href="/books/${book.id}/edit"> edit</a> 	<!-- Link refer to edit page -->					
	  					</button> 
	  					
	  					<button style="background-color:Red;">
				 			<a href="/books/delete/<c:out value="${book.id}"/>">Delete</a>  <!-- Delete Link -->						
	  					</button> 
				</td>	 	 
             </tr>
             
            </c:forEach>
     
         </tbody>
      
     </table>
  </div>
 
</body>
</html>












