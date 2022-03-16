    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Student</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

  <div class="container">
  <h1><c:out value="${student.name}"/></h1>
     <div>
     
              <form action="/showstudent" method="post" modelAttribute="newStudent">
                 <h2>
                     <label path="lesson"> Classes: </label>
                       <select path="lesson">
                           <c:forEach items="${lessons}" var="c">
                             <option value="${c}">
                             	<c:out value="${c.name}"/>
                             </option>
                    		 </c:forEach>
                 		</select>
                  </h2>                  
             
                  <input type="submit" value="Add"/>         
              </form>
     
     
                <h3>Your Schedule</h3>
                
                <table class="table">
				<thead>
					<tr>
						<th>Class Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				<div>
					<c:forEach var="lesson" items="${lessons}">			
					<tr>
						<td>
							<%-- <a href="/lessons/${lesson.id}"> --%>
								<c:out value="${lesson.lesson}"/>
							<!-- </a> -->
						</td>
						
						<td>${lesson.name}</td> 
						<td> 
						
				 			<a href="/lesson/delete/{id}<c:out value="${lesson.id}"/>">Drop</a>  						
	  					 
				       </td>
					</tr>
				</c:forEach>
				</div>
			</tbody>			
			</table>
                  
       </div>         
   </div>        
</body>
</html>