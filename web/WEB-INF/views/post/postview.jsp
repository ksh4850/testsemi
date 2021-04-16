<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/semitest1/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css">
<link rel="stylesheet" href="/semitest1/resources/bootstrap-3.3.2-dist/css/bootstrap.css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/semitest1/resources/css/auction.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

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
                 <img src="${ pageContext.servletContext.contextPath }/resources/thumbnail-image/${ postDTO.imgList[0].thnFileName}" id="post1-img" >
                   <div id="post1-img-left"></div>
                 <div id="post1-img-right"><i  class="xi-angle-right-thin xi-4x"></i></div>
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
		                            <div  id="q2" > <i class="xi-lock xi-x"></i><strong> 비밀글입니다.</strong>  </div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
                       			</div>
                       		</c:if>
                       		
                       		
                       		
                       		<c:if test="${inquiry.secretStatus eq 'Y' and sessionScope.loginUser.no eq inquiry.purchaser.no }">
		                        <div class="post1-comment" id="${inquiry.inquiryNo }" >
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" > ${inquiry.purchaser.id} : ${inquiry.inquiryDetails} &nbsp;<ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins></div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">
		                            <div class="post1-comment-resonse" >
		                                <div id="w2" >ㄴ  : ${inquiry.response} </div>
		                                <div id="w3">${inquiry.responseDate}</div>
		                            </div> 
		                            </c:if>
		                        </div> 
		                    </c:if>
                       		
                       		
                       		<c:if test="${inquiry.secretStatus eq 'N' and sessionScope.loginUser.no ne inquiry.purchaser.no }">
		                        <div class="post1-comment" id="${inquiry.inquiryNo }">
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" >${inquiry.purchaser.id} : ${inquiry.inquiryDetails} </div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">
		                            <div class="post1-comment-resonse" >
		                                <div id="w2" >ㄴ  : ${inquiry.response} </div>
		                                <div id="w3">${inquiry.responseDate}</div>
		                            </div> 
		                            </c:if>
		                        </div> 
		                    </c:if>
		                   
		                    <c:if test="${inquiry.secretStatus eq 'N' and sessionScope.loginUser.no eq inquiry.purchaser.no }">
		                        <div class="post1-comment" id="${inquiry.inquiryNo }">
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" >${inquiry.purchaser.id} : ${inquiry.inquiryDetails} &nbsp;<ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins></div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">
		                            <div class="post1-comment-resonse" >
		                                <div id="w2" >ㄴ  : ${inquiry.response} </div>
		                                <div id="w3">${inquiry.responseDate}</div>
		                            </div> 
		                            </c:if>
		                        </div> 
		                    </c:if>
		                    
		                    </c:if>
		                    
		                   <c:if test="${ requestScope.postDTO.seller.no eq sessionScope.loginUser.no }">
								 <div class="post1-comment" id="${inquiry.inquiryNo }">
		                            <div  id="q1">
		                            <c:if test="${inquiry.responseStatue eq 'N' }">미답변</c:if>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">답변 완료</c:if>
		                            </div>
		                            <div  id="q2" >${inquiry.purchaser.id} : ${inquiry.inquiryDetails} </div>
		                            <div id="q3">${inquiry.inquiryDate}</div>
		                            <c:if test="${inquiry.responseStatue eq 'Y' }">
		                            <div class="post1-comment-resonse" >
		                                <div id="w2" >ㄴ  : ${inquiry.response} &nbsp;<ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins></div>
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
	
		var postimg = 0;
		var postimglength = Number(${fn:length(postDTO.imgList)});
		
		
			var n = 0;
			var imglist = []; 
			<c:forEach var="img" items="${postDTO.imgList}">

				imglist[n]= "${img.thnFileName}";
				
				
				n++;
			</c:forEach>
		
		
		
		
		
		
	        $("#post1-img-left").click(function(){	
	            
				postimg -= 1 ;
				
				
				 $("#post1-img").attr("src"," ${ pageContext.servletContext.contextPath }/resources/thumbnail-image"+ imglist[postimg]);
	            if(postimg == 0 || postimg < 0 ){
	                $("#post1-img-left").html("");
	            }

	            if(postimg == postimglength-2){
	                $("#post1-img-right").html('<i class="xi-angle-right-thin xi-4x"></i>');
	            } 

	            
	            
			});
			
			$("#post1-img-right").click(function(){

	            

				postimg += 1 ;
				
				$("#post1-img").attr("src"," ${ pageContext.servletContext.contextPath }/resources/thumbnail-image"+imglist[postimg]);
		           
				if(postimg == 1  ){
	                $("#post1-img-left").html('<i  class="xi-angle-left-thin xi-4x"></i>');
	            }

	            if(postimg == postimglength-1){
	                $("#post1-img-right").html("");
	            } 

				
				
			});
		
		
		
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
                
                
               //댓글작성 숫자
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
        
        //투찰하기 
        $("#bidBtn").click(function(){
        	

	        	if(${empty sessionScope.loginUser}){
	        		alert("로그인후 사용해주세요");
	        	}else{
		        	var postNo = "${requestScope.postDTO.postNo}";
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
			    				
			    					alert("bidPrice원을 투찰 했습니다.");
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
            
            //투찰취소 AJAX
             $("#bidcancelBtn1").click(function(){
            	var postNo = "${requestScope.postDTO.postNo}";
		        var userNo ="${sessionScope.loginUser.no}";
		        
            	 $.ajax({
	    				url: "${ pageContext.servletContext.contextPath }/bid/cancel",
	    				type: "get",
	    				data: {postNo : postNo,
	    					   userNo : userNo,
	    					  },
	    				success: function(data){
	    					
	    						alert("투찰을 취소 했습니다.");
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
            
		
      	//댓글창 클릭하면 보이게
      	$(document).on("click",".post1-comment",function(e){
      			
      			 e.stopPropagation();
      		 
            if($(this).children(".post1-comment-resonse").css("display") == "none"){
                $(this).children(".post1-comment-resonse").css("display","inline");
               
              }else{
                $(this).children(".post1-comment-resonse").css("display","none");
                
              }
            
            if($(this).children(".post1-comment-resonse1").css("display") == "none"){
                $(this).children(".post1-comment-resonse1").css("display","inline");
              }
		})
		
		//댓글 삭제 ajax
	    $(document).on('click','#comment-delete' ,function(e){
		   
	    	 e.stopPropagation(); 
	    	
		   
			var postNo = "${requestScope.postDTO.postNo}";
			var inquiryNo =  $(this).parents(".post1-comment").attr("id"); 

			
			 $.ajax({
 				url: "${ pageContext.servletContext.contextPath }/post/deletecommet",
 				type: "get",
 				data: {postNo : postNo,
 					inquiryNo : inquiryNo
 					  },
 				success: function(data){
 					
 				  	alert("댓글을 삭제 했습니다.");
 	  				
      				console.log(data);
      			
		    	$("#kkk").html("");	
		    	
      			  for(var i = 0 ; i <data.length  ; i++){
      				 
      				commentRegistappend(data[i]);
	
			  		}  
	    					
	    					
 					
 				},
 				error: function(error){
 					console.log(error);
 				}
 			});
			
		
			 
		})
		//댓글 수정 
		 $(document).on('click','#comment-update' ,function(e){
		   
	    	e.stopPropagation();
	    	
		   
			var postNo = "${requestScope.postDTO.postNo}";
			var detailvalue = $(this).parents("#q2").text();
			var lastidx = detailvalue.lastIndexOf('/') - 2;
			var idx = detailvalue.indexOf(':') + 1 ;
			var value = detailvalue.substring(idx,lastidx);
		
			
			
			
			 $(this).parent().html('댓글 수정 : <input type="text" size="30" id="updateDteil" value="' + value + '"><input type="button"  id="commentUpdatebtn" value="수정하기">')
			 $("#q2").css("padding-bottom","0").css("padding-top","0"); 
			
			
			 $('#commentUpdatebtn').click(function(){
				var postNo = "${requestScope.postDTO.postNo}";
				var inquiryNo =  $(this).parents(".post1-comment").attr("id");
				var updateDetail =  $(this).parent().children("#updateDteil").val();
				
				 $.ajax({
	 				url: "${ pageContext.servletContext.contextPath }/post/updatecommetDetail",
	 				type: "get",
	 				data: {postNo : postNo,
	 					inquiryNo : inquiryNo,
	 					updateDetail :updateDetail
	 					  },
	 				success: function(data){
	 					
	 				  	alert("댓글을 수정 했습니다.");
	 	  				
	      				
	      			
			    	$("#kkk").html("");	
			    	
	      			  for(var i = 0 ; i <data.length  ; i++){
	      				 
	      				commentRegistappend(data[i]);
		
				  		}  
		    					
		    					
	 					
	 				},
	 				error: function(error){
	 					console.log(error);
	 				}
	 			}); 
			 
		 	});
			
			$('#q2').click(function(e){
				e.stopPropagation();
				
			});
			
			 
		}) 
		
		
			
		 $('.post1-comment-resonse').on('click', function(e){
			    
				 e.stopPropagation();
		}); 
        
       /*  $('.post1-comment-resonse1').on('click', function(e){
			 e.stopPropagation();
			 
		});  */
        
        
        
      
    
      //댓글추가  ajax
      $("#commentRegistBtn").click(function(){
    	  var postNo = "${requestScope.postDTO.postNo}";
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
  				  
  				  	alert("댓글을 달았습니다.");
  				
      				console.log(data);
      			
		    	$("#kkk").html("");	
		    	
      			  for(var i = 0 ; i <data.length  ; i++){
      				 
      				commentRegistappend(data[i]);
	
			  		}  
				},
  				error: function(error){
  					console.log(error);
  				}
  			}); 
      })
      
      
		
      //답글 ajax
       $(document).on("click","#reponseRegistBtn",function(e){
    	    e.stopPropagation();
      				
      		var postNo = "${requestScope.postDTO.postNo}";
      		var postUserNo ="${ requestScope.postDTO.seller.no}";
      		var loginUserNo ="${sessionScope.loginUser.no}";
      		var responseDetail = $(this).parent().find(".responseDetail").val();
      	  
      	    console.log(responseDetail);
      	    console.log(postNo);
      		
      		var inquiryNo = $(this).attr("name");
      		
      		
      		$.ajax({
  				url: "${ pageContext.servletContext.contextPath }/post/updateCommentResponse",
  				type: "get",
  				data: {postNo : postNo,
  					   userNo : loginUserNo,
  					  responseDetail : responseDetail, 
  					inquiryNo : inquiryNo},
  			  success: function(data){
  
  						alert("답글을 달았습니다.");	
  				  		$("#kkk").html("");
  				  		
  				  		for(var i = 0 ; i <data.length ; i++){
  				  			
  				  			var responseStatue = "";
  				  			
  				  			if(data[i].responseStatue == 'Y'){
  				  				responseStatue = "답변 완료"
  				  			}else{
  				  				responseStatue = "답변 미완료"
  				  			}
  				  			
  				  		//로그인 유저번호 , 포스트 만든 유저번호 가 같으면	
  				  		if(loginUserNo == postUserNo ){
  				  			
  				  			
  				  		var x = '<div class="post1-comment-resonse" ><div id="w2" > ㄴ답변 :'+ data[i].response + '&nbsp; <ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins></div>'
  				  			+ '<div id="w3">' + data[i].responseDate + '</div></div></div>';
                            
                            var  q = '<div class="post1-comment-resonse1" >'+ '<div  id="res1">답변 작성 : <input type="text" id="responseDetail" size="60">'
                            	    +'<input type="button" id="reponseRegistBtn" value="작성하기"></div></div></div>';
                   		  
  				 
  				  			//답변인경우
  				  			if(data[i].responseStatue == "Y"){
  				  				$("#kkk").append('<div class="post1-comment" id="'+data[i].inquiryNo +'"><div  id="q1">' + responseStatue +
  	  				  				'</div><div  id="q2" >'+ data[i].purchaser.id + ' : ' + data[i].inquiryDetails +
  	  				  				'</div><div id="q3">'+ data[i].inquiryDate +'</div>' + x  );
	  				  		//미답변인경우
  				  			}else{
  				  				$("#kkk").append('<div class="post1-comment" id="'+data[i].inquiryNo +'"><div  id="q1">' + responseStatue +
  	  				  				'</div><div  id="q2" >'+ data[i].purchaser.id + ' : ' + data[i].inquiryDetails +
  	  				  				'</div><div id="q3">'+ data[i].inquiryDate +'</div>' + q );
  				  			}
  				  			
  				  		}
  				  			
  				  			
  				  		}
  				  	
	
	    				},
  				error: function(error){
  					console.log(error);
  				}
  			}); 
      		
     })
     
     function commentRegistappend(data){
			  var postNo = "${requestScope.postDTO.postNo}";
	    	  var postUserNo ="${ requestScope.postDTO.seller.no}"
		      var loginUserNo ="${sessionScope.loginUser.no}";
		      var Detail = $("#comment-area").val();
		      var Secret = $("#commentSecret:checked").val();
			
	   			 var responseStatue = "";
	  			
	  			if(data.responseStatue == 'Y'){
	  				responseStatue = "답변 완료"
	  			}else{
	  				responseStatue = "답변 미완료"
	  			}
	  			
	  			//포스 주인이 아니고 비밀 상태이고 
	  			 if( data.secretStatus == 'Y'){
	  				
		  				//로그인한 회원이 글쓴이가 아니면!
		  				if(loginUserNo != data.purchaser.no){
		  					$("#kkk").append('<div class="post1-comment" id="' + data.inquiryNo +'"><div id="q1">' 
		  									+ responseStatue + '</div><div id="q2"><i class="xi-lock xi-x"></i> <strong>비밀글입니다.</strong> </div> <div id="q3">'
		  									+ data.inquiryDate + '</div>');
		  				
		  				//로그인한 회원이 글쓴이가 이면!
		  				}else{
		  					
		  					var x = '<div class="post1-comment-resonse" ><div id="w2" > ㄴ :'+ data.response + '</div>'
		  							+ '<div id="w3">' + data.responseDate + '</div></div></div>';
		  					
  				  			//답변인경우
  				  			if(data.responseStatue == "Y"){
  				  				$("#kkk").append('<div class="post1-comment" id="'+data.inquiryNo +'"><div id="q1">' 
  				  								+ responseStatue +'</div><div id="q2">'+data.purchaser.id + ' : ' + data.inquiryDetails 
  				  								+'&nbsp;<ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins></div>' +
	  				  							'<div id="q3">'+ data.inquiryDate +'</div>' + x  + '<div>');
		  					}else{
		  						$("#kkk").append('<div class="post1-comment"><div id="q1">' + responseStatue +'</div><div id="q2">'+
				  						data.purchaser.id + ' : ' + data.inquiryDetails +'&nbsp;<ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins> </div>' 
				  						+ '<div id="q3">'+ data.inquiryDate +'</div>');
	  						}
  				  			
	  				   }		
				  			
	  			} else{
	  				
	  				if(loginUserNo != data.purchaser.no){
	  					
			  				var x = '<div class="post1-comment-resonse" ><div id="w2" > ㄴ :'+ data.response + '</div>' + '<div id="w3">' 
			  						+ data.responseDate + '</div></div></div>';
			  				
			  				if(data.responseStatue == "Y"){
  				  				$("#kkk").append('<div class="post1-comment" id="'+data.inquiryNo +'"><div id="q1">' + responseStatue 
  				  								+'</div><div id="q2">' + data.purchaser.id + ' : ' + data.inquiryDetails +'</div>' 
	  				  							+ '<div id="q3">'+ data.inquiryDate +'</div>' + x  + '<div>');
		  					}else{
		  						$("#kkk").append('<div class="post1-comment" id="'+data.inquiryNo +'"><div id="q1">' + responseStatue 
		  								+'</div><div id="q2">'+ data.purchaser.id + ' : ' + data.inquiryDetails +'</div>' +
		  				  				'<div id="q3">'+ data.inquiryDate +'</div>');
	  						}
			  				
			  				
			  				
	  				}else{
	  					
	  					var x = '<div class="post1-comment-resonse" ><div id="w2" > ㄴ :'+ data.response + '</div>' + '<div id="w3">' 
	  						  + data.responseDate + '</div></div></div>';
		  				
		  				if(data.responseStatue == "Y"){
				  				$("#kkk").append('<div class="post1-comment" id="'+data.inquiryNo +'"><div id="q1">' + responseStatue 
				  								+ '</div><div id="q2">'+ data.purchaser.id + ' : ' + data.inquiryDetails +' &nbsp;<ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins> </div>' 
				  								+ '<div id="q3">'+ data.inquiryDate +'</div>' + x  + '<div>');
	  					}else{
	  						$("#kkk").append('<div class="post1-comment" id="'+data.inquiryNo +'"><div id="q1">' + responseStatue +'</div><div id="q2">'+
			  						data.purchaser.id + ' : ' + data.inquiryDetails +' &nbsp;<ins id="comment-update">수정</ins>/<ins id="comment-delete">삭제</ins></div>' +
	  				  				'<div id="q3">'+ data.inquiryDate +'</div>');
  						}
	  					
	  					
	  					
	  				}
	  				
	  			}  
			
		};
     
     
     
    </script> 
</body>
</html>