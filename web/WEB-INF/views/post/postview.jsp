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

<style type="text/css">
	
    
</style>
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
                	<c:if test="${requestScope.postDTO.seller.no ne sessionScope.loginUser.no and empty requestScope.userBidInfo }">
	                    <div id="bid1">
	                        <label style="font-size: 25px;">희망금액 : </label><input type=text id="userbidPrice">
	                        <button type="button" id="bidBtn" style="width: 150px;">투찰하기</button>
	                    </div>
	                    <div id="bid2" style="display:none;">
	                        <label style="font-size: 25px;">투찰 금액 : ${ requestScope.userBidInfo.bidPrice } </label><br>
	                        <button type="button" id="bidcancelBtn1" style="width: 200px;">취소하기</button>
	                    </div>
                    </c:if>
                    <c:if test="${requestScope.postDTO.seller.no ne sessionScope.loginUser.no and !empty requestScope.userBidInfo }">
                    	<div id="bid1" style="display:none;">
	                        <label style="font-size: 25px;">희망금액 : </label><input type=text id="userbidPrice">
	                        <button type="button" id="bidBtn" style="width: 150px;">투찰하기</button>
	                    </div>
	                    <div id="bid2">
	                        <label style="font-size: 25px;">투찰 금액 : ${ requestScope.userBidInfo.bidPrice } </label><br>
	                        <button type="button" id="bidcancelBtn1" style="width: 200px;">취소하기</button>
	                    </div>
                    </c:if>
                    <c:if test="${ requestScope.postDTO.seller.no eq sessionScope.loginUser.no }">
                    	<div class="post1-info"> 
                			<button id="postDetailUpdataBtn">게시물 수정하기</button>
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
          
                    <c:if test="${ requestScope.postDTO.seller.no ne sessionScope.loginUser.no }">
	                   	<textarea align="center"  cols="80" rows="3" id="comment-area" style="margin-top:30px;"></textarea>
	                    <div>
	                    <table align="center">
	                            <tr>
	                            <td ><div >비공개 여부 : </div></td>
	                            <td><input type="checkbox" id="commentSecret" value="Y"></td>
	                            <td style="padding-left: 350px;"><div id="counter" >0/100 </div></td>
	                            <td><input type="button" id="commentRegistBtn" value="댓글작성"></td> 
	                            </tr>
	                   </table>
	                   </div>
	               	</c:if>
	               		<br>
	               		
	                    <table align="center" >
	                        <tr>
	                            <th width="100px">답변상태 </th>
	                            <th width="700px" align="center" style="padding-left: 350px;"> 내용 </th>
	                            <th width="100px"> 작성일 </th>
	                         </tr>
	                    </table>
					
					
						<div id="kkk">
                       <c:forEach var="inquiry" items="${requestScope.postDTO.inquiryList}">
                       
                       <c:if test="${ requestScope.postDTO.seller.no ne sessionScope.loginUser.no }">
                       
                       		<c:if test="${inquiry.secretStatus eq 'Y' and sessionScope.loginUser.no ne inquiry.purchaser.no  }">
                       			 <div class="post1-comment" >
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" > <strong> 비밀글입니다.</strong>  </div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
                       			</div>
                       		</c:if>
                       		
                       		
                       		
                       		<c:if test="${inquiry.secretStatus eq 'Y' and sessionScope.loginUser.no eq inquiry.purchaser.no }">
		                        <div class="post1-comment" >
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" > ${inquiry.purchaser.id} : ${inquiry.inquiryDetails}</div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">
		                            <div class="post1-comment-resonse" >
		                                <div id="w2" >ㄴ  : ${inquiry.response}</div>
		                                <div id="w3">${inquiry.responseDate}</div>
		                            </div> 
		                            </c:if>
		                        </div> 
		                    </c:if>
                       		
                       		
                       		<c:if test="${inquiry.secretStatus eq 'N' }">
		                        <div class="post1-comment" >
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" >${inquiry.purchaser.id} : ${inquiry.inquiryDetails}</div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">
		                            <div class="post1-comment-resonse" >
		                                <div id="w2" >ㄴ  : ${inquiry.response}</div>
		                                <div id="w3">${inquiry.responseDate}</div>
		                            </div> 
		                            </c:if>
		                        </div> 
		                    </c:if>
		                    
		                    </c:if>
		                    
		                   <c:if test="${ requestScope.postDTO.seller.no eq sessionScope.loginUser.no }">
								 <div class="post1-comment" >
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" >${inquiry.purchaser.id} : ${inquiry.inquiryDetails}</div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">
		                            <div class="post1-comment-resonse" >
		                                <div id="w2" >ㄴ  : ${inquiry.response}</div>
		                                <div id="w3">${inquiry.responseDate}</div>
		                            </div> 
		                            </c:if>
		                            <c:if test="${inquiry.responseStatue eq 'N' }">
		                            <div class="post1-comment-resonse1" >
                                		<div  id="res1">답변 작성 : <input type="text" class="responseDetail" size="60"><input type="button" name="${inquiry.inquiryNo }" id="reponseRegistBtn" value="작성하기"></div>
                           			 </div> 
		                            </c:if>
		                        </div> 
					
						</c:if>
		                    
					</c:forEach>
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
			    				
			    					
			    					if(data != "" ){
				    					$("#bid1").css("display","none");
				    					$("#bid2").css("display","block");
				    					$("#bidPrice").html("");
				    					for(var i = 0 ; i < data.length ; i++){
				    						$("#bidPrice").append("투찰금액 : "+data[i].bidPrice+ "<br>"); 
				    					}

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
        
        /* $(".post1-comment").on("click",function(){
                      
                    if($(this).children(".post1-comment-resonse").css("display") == "none"){
                        $(this).children(".post1-comment-resonse").css("display","inline");
                      }else{
                            $(this).children(".post1-comment-resonse").css("display","none");
                      }

                       if($(this).children(".post1-comment-resonse1").css("display") == "none"){
                        $(this).children(".post1-comment-resonse1").css("display","inline");
                      } 

      	}) */
      	
      	$(document).on("click",".post1-comment",function(){
            
            if($(this).children(".post1-comment-resonse").css("display") == "none"){
                $(this).children(".post1-comment-resonse").css("display","inline");
              }else{
                $(this).children(".post1-comment-resonse").css("display","none");
              }

               if($(this).children(".post1-comment-resonse1").css("display") == "none"){
                $(this).children(".post1-comment-resonse1").css("display","inline");
              } 

			})

       
      
    
      //댓글추가 
      $("#commentRegistBtn").click(function(){
    	  var postNo = "${requestScope.postDTO.no}";
    	  var postUserNo ="${ requestScope.postDTO.seller.no}"
	      var loginUserNo ="${sessionScope.loginUser.no}";
	      var Detail = $("#comment-area").val();
	      var Secret = $("#commentSecret:checked").val();
	        
      	 $.ajax({
  				url: "${ pageContext.servletContext.contextPath }/post/insertComment",
  				type: "get",
  				data: {postNo : postNo,
  					loginUserNo : loginUserNo,
  					   Detail : Detail, 
  					   Secret : Secret},
  			  success: function(data){
  				  
  				  
  				
      			
      			
		    	$("#kkk").html("");			
      			for(var i = 0 ; i <data.length  ; i++){
			  			
			  			var responseStatue = "";
			  			
			  			if(data[i].responseStatue == 'Y'){
			  				responseStatue = "답변 완료"
			  			}else{
			  				responseStatue = "답변 미완료"
			  			}
			  			
			  			//포스 주인이 아니고 비밀 상태이고 
			  			if( data[i].secretStatus == 'Y'){
			  				/* console.log(loginUserNo);
			  				console.log(data[i].purchaser.no); */
				  				//로그인한 회원이 글쓴이가 아니면!
				  				if(loginUserNo != data[i].purchaser.no){
				  					$("#kkk").append('<div class="post1-comment"><div id="q1">' + responseStatue + 
				  							'</div><div id="q2"> <strong>비밀글입니다.</strong> </div> <div id="q3">' + data[i].inquiryDate + '</div>');
				  				
				  				//로그인한 회원이 글쓴이가 이면!
				  				}else{
				  					
				  					var x = '<div class="post1-comment-resonse" ><div id="w2" > ㄴ :'+ data[i].response + '</div>' + '<div id="w3">' + data[i].responseDate + '</div></div></div>';
				  					
		  				  			//답변인경우
		  				  			if(data[i].responseStatue == "Y"){
		  				  				$("#kkk").append('<div class="post1-comment"><div id="q1">' + responseStatue +'</div><div id="q2">'+
					  						data[i].purchaser.id + ' : ' + data[i].inquiryDetails +'</div>' +
			  				  				'<div id="q3">'+ data[i].inquiryDate +'</div>' + x  + '<div>');
				  					}else{
				  						$("#kkk").append('<div class="post1-comment"><div id="q1">' + responseStatue +'</div><div id="q2">'+
						  						data[i].purchaser.id + ' : ' + data[i].inquiryDetails +'</div>' +
				  				  				'<div id="q3">'+ data[i].inquiryDate +'</div>');
			  						}
		  				  			
			  				   }		
	  				  			
			  			}else{
			  				
			  				var x = '<div class="post1-comment-resonse" ><div id="w2" > ㄴ :'+ data[i].response + '</div>' + '<div id="w3">' + data[i].responseDate + '</div></div></div>';
			  				
			  				if(data[i].responseStatue == "Y"){
  				  				$("#kkk").append('<div class="post1-comment"><div id="q1">' + responseStatue +'</div><div id="q2">'+
			  						data[i].purchaser.id + ' : ' + data[i].inquiryDetails +'</div>' +
	  				  				'<div id="q3">'+ data[i].inquiryDate +'</div>' + x  + '<div>');
		  					}else{
		  						$("#kkk").append('<div class="post1-comment"><div id="q1">' + responseStatue +'</div><div id="q2">'+
				  						data[i].purchaser.id + ' : ' + data[i].inquiryDetails +'</div>' +
		  				  				'<div id="q3">'+ data[i].inquiryDate +'</div>');
	  						}
			  				
			  				
			  			}
			  			
			  			
			  		}


				},
  				error: function(error){
  					console.log(error);
  				}
  			}); 
      })
		
      //답글 
       $(document).on("click","#reponseRegistBtn",function(){
      				/* location.href="${ pageContext.servletContext.contextPath }/post/updateCommentResponse"; */
      				
      		var postNo = "${requestScope.postDTO.no}";
      		var postUserNo ="${ requestScope.postDTO.seller.no}";
      		var loginUserNo ="${sessionScope.loginUser.no}";
      		var responseDetail = $(".responseDetail").val();
      		var inquiryNo = $(this).attr("name");
      		
      		
      		$.ajax({
  				url: "${ pageContext.servletContext.contextPath }/post/updateCommentResponse",
  				type: "get",
  				data: {postNo : postNo,
  					   userNo : loginUserNo,
  					 responseDetail : responseDetail,
  					inquiryNo : inquiryNo},
  			  success: function(data){
  				  
  				  
  			/* 	$(document).on("click",".post1-comment",function(e){
                    
                    if($(this).children(".post1-comment-resonse").css("display") == "none"){
                        $(this).children(".post1-comment-resonse").css("display","inline");
                      }else{
                            $(this).children(".post1-comment-resonse").css("display","none");
                      }

                       if($(this).children(".post1-comment-resonse1").css("display") == "none"){
                        $(this).children(".post1-comment-resonse1").css("display","inline");
                      } 

      			}) */
      			
      			
		    				
  				  		/* $("#kkk").html("");
  				  		
  				  		for(var i = 0 ; i <data.length ; i++){
  				  			
  				  			var responseStatue = "";
  				  			
  				  			if(data[i].responseStatue == 'Y'){
  				  				responseStatue = "답변 완료"
  				  			}else{
  				  				responseStatue = "답변 미완료"
  				  			}
  				  			
  				  		//로그인 유저번호 , 포스트 만든 유저번호 가 같으면	
  				  		if(loginUserNo == postUserNo ){
  				  			$("#kkk").append('<div class="post1-comment"><div  id="q1">' + responseStatue +
  				  				'</div><div  id="q2" >'+ data[i].purchaser.id + ' : ' + data[i].inquiryDetails +
  				  				'</div><div id="q3">'+ data[i].inquiryDate +'</div>');
  				  			//답변인경우
  				  			if(data[i].responseStatue == "Y"){
	  				  			$("#kkk").append('<div id="w2" >ㄴ  :'+ data[i].response + '</div>' +
	                             '<div id="w3">' + data[i].responseDate + '</div></div>');
	  				  		//미답변인경우
  				  			}else{
	  				  			$("#kkk").append('<div class="post1-comment-resonse1" >'+
	                     		  '<div  id="res1">답변 작성 : <input type="text" id="responseDetail" size="60"><input type="button" id="reponseRegistBtn" value="작성하기"></div></div></div>');
  				  			}
  				  			
  				  		}
  				  			
  				  			
  				  		}

  				  		} */
	
	    				},
  				error: function(error){
  					console.log(error);
  				}
  			}); 
      		
     }) 


    </script> 
</body>
</html>