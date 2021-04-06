<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>로그인</title>
    <style>
         
        .post{
            margin-left: auto;
            margin-right: auto;
            width: 1100px;      
            /* text-align: left;  */
            /* margin-top: 20px; */
            font-size: 25px;
        }
        .table-set {
            margin-left: 200px;
           /* padding-bottom: 50px; */
            font-size: 20px;
        }
        .table-set td{
            padding-top: 10px;
            padding-left: 60px;
        }
        
        .login-input-text{
            width: 300px;
            height: 30px;
            border-color: ##25bc74;
        }

        .login-btn{
            width: 300px;
            height: 30px;

            margin-top: 20px;
            margin-left: 35px;

            background-color: #25bc74;
            color: white;
            border-radius: 10px;
            font-size: 15px;
        }
       
    </style>
</head>
<body>
    <div class="post">
        <h2 style="text-align:center; border-bottom: 3px solid #25bc74; padding-bottom: 10px; padding-left: 0px;">로그인</h2>
        <form action="${pageContext.servletContext.contextPath }/user/login" method="post"> 
            <table class="table-set">
                <tr>
                    <td ><label >아이디 : </label></td>
                    <td><input type="text" required class="login-input-text" name="userId"></td>
                </tr>
                <tr>
                    <td ><label >비밀번호 : </label></td>
                    <td><input type="password" required class="login-input-text" name="userPwd"></td>
                </tr>
            </table>
		<div align="center" style="font-size: 15px; margin-top: 20px;">
         	<div id="id-pwd-search">
             	<a href="">아이디 찾기</a> &nbsp;&nbsp;/&nbsp;&nbsp;<a href="">비밀번호 찾기</a> 
            </div>
                <button type="submit" class="login-btn" >로그인</button><br>
                <button type="button" class="login-btn" id="login-regist">회원가입</button>
            </div>
        </form>
    </div>
    
    <script>
    	$(function(){
    		
    		$("#login-regist").click(function(){
    			location.href="/semitest1/user/regist";
    		})
    		
    		
    	})
    	
    
    </script>

</body>
</html>