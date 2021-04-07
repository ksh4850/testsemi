<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semitest1/resources/css/hreaderFooter.css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/semitest1/resources/js/event.js"></script>
<title>Insert title here</title>
</head>
<body>
	 <div id="container">
        <div class="topMargin"></div>
		<c:if test="${empty sessionScope.loginUser}">
        <div id="mainHeader">
        
            <img class="mainHeaderImg" src="/semitest1/resources/image/mainHeader.png">
            <div class="search"> 
                <input id="searchInput" type="search" width="300px">
                <button id="searchBtn" type="submit"> &nbsp;</button>
            </div>
            <div class="btn">
                <input type="button" id="loginBtn"  >
                <input type="button" id="regstBtn" >
            </div>
        </div>
        </c:if>
        <c:if test="${!empty sessionScope.loginUser}">
       	<div id="mainHeader">
        
            <img class="mainHeaderImg" src="/semitest1/resources/image/mainHeader2.png">
            <div class="search"> 
                <input id="searchInput" type="search" width="300px">
                <button id="searchBtn" type="submit"> &nbsp;</button>
            </div>
            <div class="btn">
                <input type="button" id="logoutBtn"  >
                <input type="button" id="myPageBtn" >
            </div>
        </div>	
        </c:if>
        
        
        <br>
        
        <div align="center">
            <table class="category">
                <tr>
                    <td><img src="/semitest1/resources/image/fashion.jpg" id="L0001" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/homeAppliances.jpg" id="L0002" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/baby.jpg" id="L0003" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/car.jpg" id="L0004" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/book.jpg" id="L0005" class="main-category"></td>
                </tr>
                <tr>
                    <td><img src="/semitest1/resources/image/pet.jpg" id="L0006" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/sports.jpg" id="L0007" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/life.jpg" id="L0008" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/interior.jpg" id="L0009" class="main-category"></td>
                    <td><img src="/semitest1/resources/image/etc.jpg" id="L0010" class="main-category"></td>
            </table>
        </div> 
        <br>

        <div id="footer">
            <img src="/semitest1/resources/image/FOOTER.png" class="footerImg">
                <div class="footerMiddle">
                    <div><input type="button" id="noticeBtn" onclick="location.href='notice.html'"></div>
                    <div><input type="button" id="csBtn" onclick="location.href='cs.html'"></div>
                    <div><input type="button" id="FAQBtn" onclick="location.href='FAQ.html'"></div>
                </div>
                <div class="company">
                    <div><input type="button" id="companyInfoBtn" onclick="location.href='companyInfo.html'"></div>
                    <div><input type="button" id="termsBtn" onclick="location.href='terms.html'"></div>
                    <div><input type="button" id="personalInfoBtn" onclick="location.href='personalInfo.html'"></div>
                    <div><input type="button" id="GSPTermsBtn" onclick="location.href='GPSTerms.html'"></div>


                </div>
        </div>


    </div>
  <script>
    	$(function(){
    		/* $("#regstBtn").click(function(){
    			location.href="/semitest1/user/regist";
    		})
    		
    		$("#loginBtn").click(function(){
    			location.href="/semitest1/user/login";
    		}) */
    		
    		
    		 $(".main-category").click(function(){
                 var lcategory = $(this).attr("id");
                 console.log(lcategory);
                 
                 location.href="${pageContext.servletContext.contextPath}/post/list/l?lcategory=" + lcategory;
             })

    		
    		
    		
    	})
    	
    </script> 
</body>
</html>