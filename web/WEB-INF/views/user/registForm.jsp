<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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
        }
       
    </style>
</head>
<body>
    <div class="post">
        <h2 style="text-align:center; border-bottom: 3px solid yellowgreen; padding-bottom: 10px; padding-left: 0px;">회원가입</h2>
        <form action="${ pageContext.servletContext.contextPath }/user/regist" method="post"> 
            <table class="table-set">
                <tr>
                    <td ><label >아이디 : </label></td>
                    <td><input type="text" id="userId" name="userId" required></td>
                    <td><input type="button" id="idCheck" value="아이디 중복확인"></td>
                </tr>
                <tr>
                    <td ><label >비밀번호 : </label></td>
                    <td><input type="password" id="userPwd" name="userPwd" required></td>
                </tr>
                <tr>
                    <td ><label >비밀번호 확인: </label></td>
                    <td><input type="password" id="pwd2" required></td>
                    <td><label id="pwdresult" style="font-size: 8px;"></label></td>
                </tr>
                <tr>
                    <td ><label >이름 : </label></td>
                    <td><input type="text" id="userName" name="userName" required></td>
                </tr>
                <tr>
                    <td ><label >연락처 : </label></td>
                    <td><input type="tel" id="userMobile" name="userMobile" required></td>
               </tr>
                <tr>
                    <td ><label >이메일 : </label></td>
                    <td><input type="email" id="email" name="email" required></td>
                </tr>
                <tr>
					<td>우편번호</td>
					<td><input type="text" name="zipCode" id="zipCode" readonly></td>
					<!--readonly는 텍스트에서는 값만 받겠다!!  -->
					<td><input type="button" value="검색" class="btn btn-yg" id="searchZipCode"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address1" id="address1" readonly></td>
					<td></td>
				</tr>	
				<tr>
					<td>상세주소</td>
					<td><input type="text" name="address2" id="address2"></td>
					<td></td>
				</tr>

            </table>

            <div align="center" style="font-size: 15px; margin-top: 20px;">
                <input type="reset" value="돌아가기" id="resetRegistBtn">
                <input type="submit" value="회원 가입" id="submitRegistBtn">
            </div>
        </form>
    </div>

    <script>

       $(function(){
    	   $("#resetRegistBtn").click(function(){location.href="${ pageContext.servletContext.contextPath }/index.jsp"
    		   })
    	   
        $("#pwd2").change(function(){
                if($("#userPwd").val() != $(this).val()){
                    $("#pwdresult").html("비밀번호 일치하지 않습니다.").css("color","red");
                }else{
                    $("#pwdresult").html("");
                    $(this).focus().css("background","white");
                }
            })
            
       

            $("#userPwd").change(function(){
                if($("#pwd2").val() != $(this).val()){
                    $("#pwdresult").html("비밀번호 일치하지 않습니다.").css("color","red");

                }else{
                    $("#pwdresult").html("");
                    $(this).focus().css("background","white");
                }
            })
            
            <!--  다음 우편번호 api <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> -->
    		
    			const $searchZipCode = document.getElementById("searchZipCode");
    			const $goMain = document.getElementById("goMain");
    			
    			$searchZipCode.onclick = function(){
    				
    				new daum.Postcode({
    					oncomplete : function(data){
    						document.getElementById("zipCode").value = data.zonecode;
    						document.getElementById("address1").value = data.address;
    						document.getElementById("address2").focus();
    					}
    				}).open();

    				//창을 띄우는것
    			}
            
            
       })
    </script>
</body>
</html>