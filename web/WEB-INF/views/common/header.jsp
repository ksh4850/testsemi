<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semitest1/resources/css/hreaderFooter.css">
<script src="/semitest1/resources/js/event.js"></script>
<title>Insert title here</title>
</head>
<body>

	<c:if test="${empty sessionScope.loginUser }">
	   <div id="container">
        <!-- <div class="topMargin"></div> -->
    <div id="mainHeader">
        <img class="mainHeaderImg" src="/semitest1/resources/image/HEADER.png">
        <div class="header-search"> 
            <input id="header-searchInput" type="search" width="300px">
            <button id="header-searchBtn" type="submit"> &nbsp;</button>
        </div>
        <div class="header-btn">
            <input type="button" id="loginBtn" >
            <input type="button" id="regstBtn" >
        </div>
    </div>
    </div>
    </c:if>
    <c:if test="${!empty sessionScope.loginUser }">
	   <div id="container">
        <!-- <div class="topMargin"></div> -->
    <div id="mainHeader">
        <img class="mainHeaderImg" src="/semitest1/resources/image/HEADER2.png">
        <div class="header-search"> 
            <input id="header-searchInput" type="search" width="300px">
            <button id="header-searchBtn" type="submit"> &nbsp;</button>
        </div>
        <div class="header-btn">
            <input type="button" id="logoutBtn" >
            <input type="button" id="myPageBtn" >
        </div>
    </div>
    </div>
    </c:if>
    
    <script >
    	
    </script>
</body>
</html>