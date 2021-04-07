<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
            <div class="post5-s-category" id ="S0001">옷</div>
            <div class="post5-s-category" id ="S0002">가방</div>
            <div class="post5-s-category" id ="S0003">시계</div>
        </div>
        <div class="post5-category-list">가전/전자</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0004">컴퓨터</div>
            <div class="post5-s-category" id ="S0005">청소기</div>
            <div class="post5-s-category" id ="S0006">냉장고</div>
        </div>
        <div class="post5-category-list">유아용품</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0007">유모차/카시트</div>
            <div class="post5-s-category" id ="S0008">장난감</div>
            <div class="post5-s-category" id ="S0009">유아의류</div>
        </div>
        <div class="post5-category-list">자동차용품</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0010">타이어</div>
            <div class="post5-s-category" id ="S0011">블랙박스</div>
            <div class="post5-s-category" id ="S0012">세차도구</div>
        </div>
        <div class="post5-category-list">도서</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0013">유아도서</div>
            <div class="post5-s-category" id ="S0014">학습</div>
            <div class="post5-s-category" id ="S0015">소설</div>
        </div>
        <div class="post5-category-list">반려동물용품</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0016">반려동물 의류</div>
            <div class="post5-s-category" id ="S0017">반려동물 장난감</div>
            <div class="post5-s-category" id ="S0018">사료</div>
        </div>
        <div class="post5-category-list">스포츠용품</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0019">자전거</div>
            <div class="post5-s-category" id ="S0020">축구/야구/농구</div>
            <div class="post5-s-category" id ="S0021">등산/낚시/캠핑</div>
        
        </div>
        <div class="post5-category-list">생활용품</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0022">욕실용품</div>
            <div class="post5-s-category" id ="S0023">주방용품</div>
            <div class="post5-s-category" id ="S0024">거실용품</div>
        
        </div>
        <div class="post5-category-list">가구/인테리어</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0025">침대/침구</div>
            <div class="post5-s-category" id ="S0026">책상/의자</div>
            <div class="post5-s-category" id ="S0027">수납품</div>
        </div>
        
        <div class="post5-category-list">기타</div>
        <div class="contents1">
            <div class="post5-s-category" id ="S0028">티켓/쿠폰/상품권</div>
            <div class="post5-s-category" id ="S0029">핸드메이드</div>
            <div class="post5-s-category" id ="S0030">기타</div>
        
        </div>

    </nav>
    <section id="post5-list">
    	<c:if test="${empty sessionScope.loginUser}">
	    	<div style="float: right;">
	            <input type="button" id="createPostBtn"  value="게시물 등록하기" hidden>
	        </div> 
        </c:if>
        <br clear="both">
        <c:if test="${!empty sessionScope.loginUser}">
	    	<div style="float: right;">
	            <input type="button" id="createPostBtn"  value="게시물 등록하기" >
	        </div> 
        </c:if>
        <br clear="both">
    	
		<c:forEach var="post" items="${requestScope.postList }">
		<div class="post5-product">
            <img src="/semitest1/resources/image/book.jpg"  width="175px" height="175px">
            <div class="post5-title">${ post.title}</div>
        </div> 
	</c:forEach>
    </section>
    
     <br clear="both"> 
     
    <div class="post5-pagingArea" align="center">
			<button id="searchStartPage"><<</button>
			
			<c:if test="${ requestScope.pageInfo.pageNo == 1 }">
				<button disabled><</button>
			</c:if>
			<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
				<button id="searchPrevPage"><</button>
			</c:if>
			
			<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
				<c:if test="${ requestScope.pageInfo.pageNo eq p }">
					<button disabled><c:out value="${ p }"/></button>
				</c:if>
				<c:if test="${ requestScope.pageInfo.pageNo ne p }">
					<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
				</c:if>
			</c:forEach>
			
			<c:if test="${ requestScope.pageInfo.pageNo == requestScope.pageInfo.maxPage }">
				<button disabled>></button>	
			</c:if>
			<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
				<button id="searchNextPage">></button>
			</c:if>
			
			<button id="searchMaxPage">>></button>
	</div><!-- paginArea end-->
    
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
      		  
      		  $('.post5-s-category').click (function(){
            		console.log($(this).attr("id"));
            		var scategory = $(this).attr("id");
            	location.href="${pageContext.servletContext.contextPath}/post/list/s?scategory=" + scategory;	
         	})

         	
      		  
       	})
       	
       	const link = "${ pageContext.servletContext.contextPath }/post/list/l";
		
		/* 원하는 페이지 클릭시 실행되는 콜백 함수 */
		function pageButtonAction(text) {
			 location.href = link + "?currentPage=" + text + "&lcategory=${requestScope.postList[0].category.ctgLCode }" ;
			 
			
			
		}
		
		if(document.getElementById("searchStartPage")){
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function(){
				location.href = link + "?currentPage=1";
			}
		}
		
		if(document.getElementById("searchMaxPage")){
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}
		
		if(document.getElementById("searchPrevPage")){
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }";
			}
		}
		
		if(document.getElementById("searchNextPage")){
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }";
			}
		}
        


    </script>
    
		
</body>
</html>