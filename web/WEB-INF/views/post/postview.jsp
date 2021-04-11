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
                	<c:if test="${empty requestScope.userBidInfo }">
	                    <div id="bid1">
	                        <label style="font-size: 25px;">희망금액 : </label><input type=text id="userbidPrice">
	                        <button type="button" id="bidBtn" style="width: 150px;">투찰하기</button>
	                    </div>
	                    <div id="bid2" style="display:none;">
	                        <label style="font-size: 25px;">투찰 금액 : ${ requestScope.userBidInfo.bidPrice } </label><br>
	                        <button type="button" id="bidcancelBtn1" style="width: 200px;">취소하기</button>
	                    </div>
                    </c:if>
                    <c:if test="${!empty requestScope.userBidInfo }">
                    	<div id="bid1" style="display:none;">
	                        <label style="font-size: 25px;">희망금액 : </label><input type=text id="userbidPrice">
	                        <button type="button" id="bidBtn" style="width: 150px;">투찰하기</button>
	                    </div>
	                    <div id="bid2">
	                        <label style="font-size: 25px;">투찰 금액 : ${ requestScope.userBidInfo.bidPrice } </label><br>
	                        <button type="button" id="bidcancelBtn1" style="width: 200px;">취소하기</button>
	                    </div>
                    </c:if>
                 
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
                <form action="#">
                    <textarea  cols="80" rows="3" id="comment-area" style="margin-top:30px;"></textarea>
                    <div>
                        <table>
                            <td style="padding-left: 680px;"><div id="counter" >0/100 </div></td>
                            <td><input type="submit" value="댓글작성"></td>
                        </table>
                    </div>
                </form>
                <!-- <div class="post1-comment" >작성자 : 내용</div> -->
                <!-- <div id="comment1" width="350px" style="margin-top: 10px; border-bottom: 1px solid black; font-size: 25px; text-align: left; padding-left: 200px;" >작성자 : 내용</div> -->
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
        
        
        $("#bidBtn").click(function(){
        	
        	
        	
	        	if(${empty sessionScope.loginUser}){
	        		alert("로그인후 사용해주세요");
	        	}else{
		        	var postNo = "${requestScope.postDTO.no}";
		        	var userNo ="${sessionScope.loginUser.no}";
		        	var bidPrice = $("#userbidPrice").val();
			        	if(bidPrice == ""){
			        		alert("투찰금액을 입력해주세요")
			        	}else{
			        		if(Number(${requestScope.postDTO.minPrice}) < Number(bidPrice)){
			        			
			        			$.ajax({
			    				url: "${ pageContext.servletContext.contextPath }/bid/insert",
			    				type: "get",
			    				data: {postNo : postNo,
			    					   userNo : userNo,
			    					   bidPrice: bidPrice},
			    				success: function(data){
			    				
			    					$("#bid1").css("display","none");
			    					$("#bid2").css("display","block");
			    					$("#bidPrice").html("");
			    					for(var i = 0 ; i < data.length ; i++){
			    						$("#bidPrice").append("투찰금액 : "+data[i].bidPrice+ "<br>"); 
			    					}

			    					
			    				},
			    				error: function(error){
			    					console.log(error);
			    				}
			    			}); 
			        			
			        			
			        			
			        		}else{
			        			alert("최소 금액 보다 높게 투찰해주세요!!!")
			        		}
			        		
			        		
				        	
		        		}
		            	
		        	
		        	}
            })
            
             $("#bidcancelBtn1").click(function(){
            	var postNo = "${requestScope.postDTO.no}";
		        var userNo ="${sessionScope.loginUser.no}";
		        
            	 $.ajax({
	    				url: "${ pageContext.servletContext.contextPath }/bid/cancel",
	    				type: "get",
	    				data: {postNo : postNo,
	    					   userNo : userNo,
	    					  },
	    				success: function(data){
	    					
	    					$("#bid1").css("display","block");
	    					$("#bid2").css("display","none");
	    					$("#bidPrice").html("");
	    					for(var i = 0 ; i < data.length ; i++){
	    						$("#bidPrice").append("투찰금액 : "+data[i].bidPrice+ "<br>"); 
	    					}

	    					
	    				},
	    				error: function(error){
	    					console.log(error);
	    				}
	    			}); 
            	 
            	 
            	 
            	 
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

        $(function(){
            var user = ['사람1','사람2','사람3','사람4','사람5'];
            var text1 = ['문의 합니다.','물어볼께요','하이요','그냥요','바보'];
            var text2 = ['물건쩌러',null,'완전',null,'쩌러'];
            var comment = "<div class=\"post1-comment\" >"+ user[i] + " : " + text1[i] +"</div>";
            var comment1 = "<div class=\"post1-comment\" > ㄴ " + text2 +"</div>";
            
            for(var i = 0 ; i < 5 ; i++){
                $("#post1-comment-info").append("<div class=\"post1-comment\" >"+ user[i] + " : " + text1[i] +"</div>").css("color","black");
                if(text2[i] != null){
                    $("#post1-comment-info").append("<div class=\"post1-comment\" > ㄴ " + text2[i] +"</div>").css("color","black");
                }
            }

                console.log(text2);

        })



    </script> 
</body>
</html>