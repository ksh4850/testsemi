<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www." %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	 <form id="test" action="${ pageContext.servletContext.contextPath }/testservlet" method="post">
	
		<input type ="text" name="userId">
		
		<button type="button" id="test">버튼</button>
		
		
	</form> 
	 --%>
	<!-- <input type="button" onclick="test()"> -->
	<%-- <c:out value="하이"></c:out> --%>
	
	<!-- <script>
	
		function test(){
			/* <c:set var="test1" value="개꿀때기" scope=request></c:set> */
			location.href="${ pageContext.servletContext.contextPath }/testservlet";
		}
	</script>  -->
	
</body>
</html>