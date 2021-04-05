<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/semitest1/resources/css/auction.css">
<title>Insert title here</title>
</head>
<body>
		
		
		<jsp:include page="../common/header.jsp"></jsp:include>
		
		<div id ="post5"> 
    <nav id="post5-category">
        <div class="post5-category-list">패션의류/잡화</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">가전/전자</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">유아용품</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">자동차용품</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">도서</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">반려동물용품</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">스포츠용품</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">생활용품</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">가구/인테리어</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>
        <div class="post5-category-list">기타</div>
        <div class="contents1">
            <div>옷</div>
            <div>가방</div>
            <div>시계</div>
        </div>

    </nav>
    <section id="post5-list">


    </section>
    </div>
    <br clear="both">
    
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    
     <script>

    $(function(){
            $(".post5-category-list").click(function(){
           
            //2.display속성으로 해보기ㅏ
            if($(this).next().css("display") == "none" ){
                $(this).next().slideDown();
            }else{
                $(this).next().slideUp();
            }

        })
        })

        $(function(){
        	
        	

        for(var i = 0 ; i < 6 ;i++){
        var title = "진짜진짜 사용 몇번안한 컴퓨터 팔라여 많은 문의 부탁드려요";
        var post5Img = "sample/image/river2.PNG"
      
        var postList =  "<div class=\"post5-product\">" +
            "<img src=\"" + post5Img +"\" >" +
            "<div class=\"post5-title\">"+ title +"</div></div>";
       
            $("#post5-list").append(postList);
            // console.log(sellHtml);

        }

    })



    </script>
    
		
</body>
</html>