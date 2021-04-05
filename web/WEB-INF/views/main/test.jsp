<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form id="test" action="${ pageContext.servletContext.contextPath }/testservlet" method="post">
	
		<input type ="text" name="userId">
		
		<button type="submit" >버튼</button>
	</form>
</body>
</html>