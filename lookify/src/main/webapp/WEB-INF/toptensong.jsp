<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <div id="container">
           <div>
               <h3>Top Ten Songs:</h3>
               <a href="/dashboard"><h3>Dashboard</h3></a>
           </div>
           <ul>
              <c:forEach items="${lookifies}" var="lookify">
                 <li>
                    <h3><c:out value="${lookify.rating}"/><a href="/lookifies/${lookify.id}"><c:out value="${lookify.name}"/></a> - <c:out value="${lookify.artist}"/></h3>
                 </li>
              </c:forEach>
           </ul>
        </div>

</body>
</html>