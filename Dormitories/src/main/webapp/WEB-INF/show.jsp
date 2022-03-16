    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Dormitory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<div class= "container">
							 	 
							 	<h1><c:out value="${dorm.dormName}"/></h1>
							              
									<form action="/dorms/addStudent/${dorm.id}" method="post">
							           <h2>
							               <label> Students1111: </label>
							                 <select name="student">
							                     <c:forEach items="${students}" var="s">
							                        <option value="${s.id}">
							                        	<c:out value="${s.firstName}"/>
							                        </option>
							               		 </c:forEach>
							           		</select>
							            </h2>  
							            <input type="submit" value="Add"/>         
							         </form>  
								 					         
       <div>
        <table class="table"> 
        <thead>
           <tr>
             <th>Full Name</th>
             <th>Action</th>
           </tr>
       </thead>
       <tbody>
           <c:forEach items="${dormStudent}" var="student">
          
           <tr>
               <th>
                <c:out value="${student.firstName}"/>
                <c:out value="${student.lastName}"/></th>
                <th>
        		<a href="/students/delete/<c:out value="${student.id}"/>">remove</a>  						
               
               </th>
            </tr>
          
            </c:forEach>
         </tbody>
   		 </table>
             <a href="/dorms/new"> Add Dormitory </a>
            <a href="/students/new"> Add New Student </a>
        </div>
<div>
 
</body>
</html>