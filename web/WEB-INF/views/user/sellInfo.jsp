<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/semitest1/resources/css/auction.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	  <div id="post2">
    <nav id="bidList">
        <ul style="margin-top: 40px;">내거래목록
            <li><div class="list-sellList">판매중</div></li>
            <li><div class="list-purchaserList">구매중</div></li>
        </ul>
    </nav>
    <section id="auction-table2">
         <h2 style="color :#25bc74; border-bottom: 2px solid #25bc74;">판매중인 내역</h2>
         
         <c:forEach var="post" items="${requestScope.postList }">
         <div class="auction" id="${post.postNo }">
            <div class="sellimg1" ><img src="${ pageContext.servletContext.contextPath }/resources/thumbnail-image/${ post.imgList[0].thnFileName}"></div>
            <div id=sellimg2>
                <div >제목 : ${post.title }</div>
                <div>판매일시 : <fmt:formatDate value="${post.postedDate }" pattern="yyyy-MM-dd"/></div>
                <div> </div>
            </div>
            <div id=sellimg3>
            	<c:if test="${post.bidStatus eq '입찰중'}">
                <div>${post.bidStatus } </div>
                <div >입찰 종료일 </div>
                <div ><fmt:formatDate value="${post.bidEndDate }" pattern="yyyy-MM-dd hh:mm:ss"/> </div>
                </c:if>
                
                <c:if test="${post.bidStatus eq '종료'}">
                <div>${post.bidStatus } </div>
                <div>최고 투찰금액 : <fmt:formatNumber value="${post.bidList[0].bidPrice }" pattern="#,###"/> 원 </div>
                
                <!-- <div><input type="button" name="" id="post2-bid1" value="거래진행하기"></div> -->
                </c:if>
                
                <c:if test="${post.bidStatus eq '거래중'}">
                <div>${post.bidStatus } </div>
                <div>구매자 : thsdngjs0750005</div>
                <div><input type="button" name="" id="post2-bid2" value="거래완료" style="margin-right: 10px"></div>
                </c:if>

            </div>
        </div> 
        </c:forEach>
        
        <br>
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
					<button id="post2-pageButton"><c:out value="${ p }"/></button>
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
    
    </section>
</div>   
	
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	
	<script >
		$(".sellimg1").click(function(){
			var postNo = $(this).parent().attr("id");
			
			location.href="${pageContext.servletContext.contextPath}/post/detail?postNo=" + postNo;
		})
		
		const link = "${ pageContext.servletContext.contextPath }/user/mypage/sellinfo";

		$("#post2-pageButton").click(function() {
			var text = $(this).text();
			console.log(text);
			location.href = link + "?currentPage=" + text ;
		})

		
		$("#searchNextPage").click(function() {
			location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }";
		})
		
		$("#searchPrevPage").click(function() {
			location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }";
		})
		
		$("#searchMaxPage").click(function() {
			location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }";
		})
		
		$("#searchStartPage").click(function() {
			location.href = link + "?currentPage=1";
		})
		
	
		
		
		
		
			
		
			
	</script>
</body>
</html>