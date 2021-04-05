<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semitest1/resources/css/hreaderFooter.css">
<title>Insert title here</title>
</head>
<body>
	 <div id="container">
        <div class="topMargin"></div>

        <div id="mainHeader">
            <img class="mainHeaderImg" src="/semitest1/resources/image/mainHeader.png">
            <div class="search"> 
                <input id="searchInput" type="search" width="300px">
                <button id="searchBtn" type="submit"> &nbsp;</button>
            </div>
            <div class="btn">
                <input type="button" id="loginBtn" onclick="location.href='login.html'">
                <input type="button" id="regstBtn" onclick="location.href='regist.html'">
            </div>
        </div>
        
        <br>
        
        <div align="center">
            <table class="category">
                <tr>
                    <td><img src="/semitest1/resources/image/fashion.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/homeAppliances.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/baby.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/car.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/book.jpg" id="ctgimg"></td>
                </tr>
                <tr>
                    <td><img src="/semitest1/resources/image/pet.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/sports.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/life.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/interior.jpg" id="ctgimg"></td>
                    <td><img src="/semitest1/resources/image/etc.jpg" id="ctgimg"></td>
                </tr>
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
</body>
</html>