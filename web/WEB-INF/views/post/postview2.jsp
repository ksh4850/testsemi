<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/semitest1/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
<link rel="stylesheet" href="/semitest1/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
<link rel="stylesheet" href="/semitest1/resources/bootstrap-3.3.2-dist/js/bootstrap.js">
<link rel="stylesheet" href="/semitest1/resources/bootstrap-3.3.2-dist/js/npm.js"> 
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/semitest1/resources/css/auction.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<jsp:include page="../common/header.jsp"></jsp:include>

 	<div class="post">
        <h1 > ${ requestScope.postDTO.title}</h1>
        <hr>
        <!-- width="350px" height="350px" style="margin-top: 25px;  -->
        <div id="post1-main">
            <div id="post1-main-img">
                 <img src="${ pageContext.servletContext.contextPath }/resources/thumbnail-image/${ postDTO.img[0].thnFileName}" id="post1-img" >
            </div>

            <div id="post1-main-info">

                <div class="post1-info" >
                    <label>경매 남은 시간 :</label>
                    <div id="bidTime" style="font-size: 35px;"></div>
                </div>
                <div class="post1-info" style="overflow-y:scroll;">
                    <!-- width:350px; height:80px; -->
                    <div id="bidPrice" style="font-size: 15px;">
                    	<c:forEach var="bid" items="${requestScope.postDTO.bidList}">
                    		금액 : ${bid.bidPrice }<br>
                    	</c:forEach>
                    </div>
                </div>
                <div style="font-size: 25px; margin-top: 20px;">
                    최소 입찰 금액 : ${requestScope.postDTO.minPrice}
                </div>
                <div class="post1-info"> 
                	<button id="postDetailUpdataBtn">게시물 수정하기</button>
                </div>
                

            </div>
        </div>

        <br clear="both">
        <div id="post1-product-comment">
            <ul class="nav nav-tabs nav-justified" id="post1-product-bar">
                <li onclick="test3();" style="font-size: 20px;" class="post1-product" id="post1-product-btn">상품정보</li>
                <li onclick="test4()"  style="font-size: 20px;"class="post1-product" id="post1-comment-btn">상품문의</li>
            </ul>
            <div  width="1000px"  style="border: 1px solid #25bc74; text-align: left;" id="post1-product-info">
               <pre>
                ${ requestScope.postDTO.details} 
               </pre>
            </div>
            <div hidden style="border: 1px solid#25bc74;" id="post1-comment-info">
          
                    
               		<br>
                    <table align="center" >
                        <tr>
                            <th width="100px">답변상태 </th>
                            <th width="700px" align="center" style="padding-left: 350px;"> 내용 </th>
                            <th width="100px"> 작성일 </th>
                         </tr>
                    </table>

                       
                        <div class="post1-comment" >
                            <div  id="q1">답변완료</div>
                            <div  id="q2" >내용 : 가나다라마바사아자차가타바이ㅣ이이이이ㅣ이</div>
                            <div id="q3">2021/04/13</div>
                            <div class="post1-comment-resonse" >
                                <div id="w2" >ㄴ  : 가나다라마바사아자차가타바이ㅣ이이이이ㅣ이</div>
                                <div id="w3">2021/04/13</div>
                            </div> 
                        </div> 

                         <div class="post1-comment">
                            <div  id="q1">답변완료</div>
                            <div  id="q2" >내용 : 가나다라마바사아자차가타바이ㅣ이이이이ㅣ이</div>
                            <div  id="q3">2021/04/13</div>
                            <div class="post1-comment-resonse1" >
                                <div  id="res1">답변 작성 : <input type="text" size="60"><input type="button" value="작성하기"></div>
                            </div> 
                        </div>
                        
                        
                        <br clear="both">
            </div>
        </div>
        
       </div>
        
        <jsp:include page="../common/footer.jsp"></jsp:include>

	
	<script>
        function test3(){
            $("#post1-comment-info").hide();
            $("#post1-product-info").show();
            $("#post1-product-btn").css("background" ,"#25bc74")
            $("#post1-comment-btn").css("background" ,"white")
            

        }

        function test4(){
            $("#post1-product-info").hide();
            $("#post1-comment-info").show();
            $("#post1-comment-btn").css("background" ,"#25bc74")
            $("#post1-product-btn").css("background" ,"white")
        }

        $(function(){
        	
            date = new Date();

            var date1 = new Date();
            
            var date2 =  new Date("${requestScope.postDTO.bidEndDate}");
            
           

            var bidTime = (date2.getTime() - date1.getTime())/1000;


                var intervalID = window.setInterval(function(){


                    var h= Math.floor((bidTime / ( 60 * 60) ));
                    var m = Math.floor((bidTime % ( 60 * 60)) /  60);
                    var s = Math.floor(bidTime %  60);
                    $("#bidTime").html(h + ":" + m +":" + s);
                    bidTime--;
                    setTimeout(function(){
                        clearInterval(intervalID);
                        // area2.innerHTML = "종료!";
                        $("#bidTime").html("경매 종료 ");
                    },bidTime*1000);
                },1000);
                
           
            
        })
        
        $("#postDetailUpdataBtn").click(function(){
        	location.href="${ pageContext.servletContext.contextPath }/post/update?postNo=${ requestScope.postDTO.no} ";
        })
        
        
            
			
        $(function(){
 
            $("#comment-area").keyup(function(){
               
                var inputLength =$(this).val().length;
                $("#counter").text(inputLength+"/100");

                var remain = 100 - inputLength;

                if(remain >= 0){
                    $("#counter").parent().css("color","black");
                }else{
                    $("#counter").parent().css("color","red");
                }
            })
            
            
        })

        $(".post1-comment").click(function(){
                      
                    if($(this).children(".post1-comment-resonse").css("display") == "none"){
                        $(this).children(".post1-comment-resonse").css("display","inline");
                      }else{
                            $(this).children(".post1-comment-resonse").css("display","none");
                      }

                      if($(this).children(".post1-comment-resonse1").css("display") == "none"){
                        $(this).children(".post1-comment-resonse1").css("display","inline");
                      }

                 })


    </script> 
</body>
</html>