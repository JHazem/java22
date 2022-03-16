<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" >

</head>
<body>

	<div>
		<label for="">Your Gold:${number}</label>
	
	</div></br>
	
	<div class="row">
			<div class="clearfix">
			
					<div class = "box">
						<h3>Farm</h3>
						<p>(earns 10-20 gold)</p>
						<form action="/farm" method="post">
							<input name="farm" type="submit" value="Find Gold!"/>
						</form>
					</div> 
				
					<div  class = "box">
						<h3>Cave</h3>
						<p>(earns 5-10 gold)</p>
						<form action="cave" method="post">
							<input type="submit" value="Find Gold!"/>
						</form>
					</div>
				
					<div class = "box">
						<h3>House</h3>
						<p>(earns 2-5 gold)</p>
						<form action="house" method="post">
							<input type="submit" value="Find Gold!"/>
						</form>
					</div>
				
					<div class = "box">
						<h3>Casino!</h3>
						<p>(earns 0-50 gold)</p>
						<form action="casino" method="post"> 
							<input type="submit" value="Find Gold!"/>
						</form>
					</div></br>
			</div>	
		<div>
		<h3>Activities:</h3>
			
			<c:forEach var="activity" items="${activities}">
				<h3> 
				<c:out value="${activity}"/>
				</h3>
			</c:forEach>
		
		</div>
	
	</div>

</body>
</html>