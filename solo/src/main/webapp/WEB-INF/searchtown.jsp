<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html xmlns:th="http//www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	     <table class="table">
	        <thead>
	            <tr>
		               <th>Id</th>
		              <th>Title</th>
		              <th>Writer name</th>
		              <th>Comment</th> 
		              <th>Actions</th>
	            </tr>
	        </thead>
	     		 <!-- Body of table -->
	    	<tbody>
	    	
 	 	<div>&nbsp;</div>
		
		<div> 
		 	 <form th:action="@{/}">
		 	 	<input type = "hidden" name = "sortField" th:value="${sortField}" />
		 		Search By: 
		 		<input type="text" name = "keyword" th:value="${keyword}" required  />
		 		&nbsp;
		 		<input type="submit" value="search"/>
		 		&nbsp;
		 		<input type="buttton" value="clear" onclick="clearSearch"/>
	 		</form>
	 	</div> 
	 	
 
	           <%--  <c:forEach items="${myStories}" var="story">   --%>
	                     <!-- To fill information inside the table -->
	              
	            <tr> <!--  5:31 -->
	                <td th:each="story : ${listStories}">
 	               	<td th:text="story : ${listStories.id}">Id</td>
 	                <td th:text="story : ${listStories.title}"> Title</td> 
 	                <td th:text="story : ${listStories.content}"> Content</td> 
 	                <td> </td>
	                <td>
		                <a href="/stories/delete/<c:out value="${story.id}"/>">Delete</a> 
                   	    <a href="/stories/${story.id}/edit"> edit</a> 
	                 </td>
			            
	           	 </tr>
	             </td>
	            <%-- </c:forEach> --%>
	     
	         </tbody>
	      
	     </table>
  </div>  
  
 <script type = "text/javascript">
	function clearSearch(){
	window.location = ''; }
</script>   
</body>
</html>