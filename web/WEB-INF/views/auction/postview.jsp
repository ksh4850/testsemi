<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>

	<jsp:include page="../common/header.jsp"></jsp:include>

 	<div class="post">
        <h1 >게시글제목</h1>
        <hr>
        <!-- width="350px" height="350px" style="margin-top: 25px;  -->
        <div id="post1-main">
            <div id="post1-main-img">
                 <img src="sample/image/flower1.PNG" id="post1-img" >
            </div>

            <div id="post1-main-info">

                <div class="post1-info" >
                    <label>경매 남은 시간 :</label>
                    <div id="bidTime" style="font-size: 35px;"></div>
                </div>
                <div class="post1-info" style="overflow-y:scroll;">
                    <!-- width:350px; height:80px; -->
                    <div id="bidPrice"></div>
                </div>
                <div class="post1-info">
                    <form action="">
                        <label style="font-size: 25px;">희망금액 : </label><input type="text" name="">
                        <button type="submit" style="width: 150px;">투찰하기</button>
                    </form>
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
                정부는 코로나19 백신 접종이 본격화됨에 따라 다음 달부터 접종 뒤 이상반응을 호소하는 사람들을 위한 '백신 휴가'를 도입하기로 했습니다.

                정부는 오늘(28일) 중앙재난안전대책본부(중대본) 회의를 열어 백신 휴가 활성화 방안을 확정했습니다.

                중대본에 따르면 다음달 1일부터 접종 후 이상반응이 나타난 접종자는 의사 소견서 없이도 신청만으로 휴가를 받을 수 있습니다.

                통상 접종을 받은 후 10∼12시간 이내에 이상반응이 나타나는 점을 고려해 접종 다음 날 하루를 휴가로 부여하고, 이상반응이 있을 때는 추가로 1일을 더 사용할 수 있습니다.

                총 이틀을 사용할 수 있는 셈입니다.

                이는 일반적인 접종 후 이상반응이 2일 이내에 호전되며, 만약 48시간 이상 지속될 경우에는 의료기관에 방문해야 한다는 원칙에 따른 것입니다.

                또 접종 당일에도 접종에 필요한 시간에 대해서는 공가·유급휴가 등을 적용하도록 권고했습니다.
                출처 : SBS 뉴스 

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
            date2 = new Date(2021-03-31);

            var date1 = new Date();
            // var date2 = new Date("2019-09-06 12:03:13");
            var date2 = new Date("2021-04-04 18:25:50 ");

            var test = (date2.getTime() - date1.getTime())/1000;

            // $("#bidTime").html(h + ":" + m +":" + s);

                var intervalID = window.setInterval(function(){


                    var h= Math.floor((test / ( 60 * 60) ));
                    var m = Math.floor((test % ( 60 * 60)) /  60);
                    var s = Math.floor(test %  60);
                    $("#bidTime").html(h + ":" + m +":" + s);
                    test--;
                    setTimeout(function(){
                        clearInterval(intervalID);
                        // area2.innerHTML = "종료!";
                        $("#bidTime").html("경매 종료 ");
                    },test*1000);
                },1000);
            
        })
        $(function(){

            var size = 10;
            var price = 1000;
            for(var i = 0 ; i < size ; i++ ){
                var bidPrice = "<p> 금액 :" + price + "</p>";
            $("#bidPrice").append(bidPrice).css("font-size", "15px");
            }
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