<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/semitest1/resources/css/auction.css">
</head>
<body>

		<jsp:include page="../common/header.jsp"></jsp:include>

	     <div class="post2">
        <h2 style="text-align:left; border-bottom: 1px solid #25bc74; padding-bottom: 10px; padding-left: 100px;"  >게시글 작성</h2>
        <form action="${ pageContext.servletContext.contextPath }/post/regist" method="post" encType="multipart/form-data"> 
            <table class="table-set">
             	    <tr>
                    <td ><label>카테고리 목록 : </label></td>
                    <td >
                        <select name="lCategory"  > 
                            <option  value="L0000" aria-checked="">대분류</option>
                            <option value="L0001">패션의류/잡화</option>
                            <option value="L0002">가전/전자</option>
                            <option value="L0003">유아용품</option>
                            <option value="L0004">자동차용품</option>
                            <option value="L0005">도서</option>
                            <option value="L0006">반려동물 용품</option>
                            <option value="L0007">스포츠용품</option>
                            <option value="L0008">생활용품</option>
                            <option value="L0009">가구/인테리어</option>
                            <option value="L0010">기타</option>
                        </select>
                        <select name=sCategory> 
                            <option value="" aria-checked="">소분류</option>
                            <option value="s0001">옷</option>
                            <option value="s0002">신발</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td ><label >게시물 제목 : </label></td>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <td ><label style="padding-bottom: 250px;">게시물 내용 : </label></td>
                    <td><textarea name="details" id="" cols="30" rows="10" required></textarea></td>
                </tr>
                <tr>
                    <td ><label >미개봉 여부 : </label></td>
                    <td><input type="checkbox" name="unOpenedchk" value="Y" width="30px" height="30px" ></td>
                </tr>
                <tr>
                    <td ><label >최소 입찰가 : </label></td>
                    <td><input type="number" name="minPrice" step="100" required></td>
                </tr>
                <tr>
                    <td colspan="2" style="font-size: 15px; color: red;"><li>입찰일로 부터 72시간 동안 투찰이 진행됩니다.</li></td>
                </tr> 
                <tr> 

                    <td>첨부사진 :</td>
                    <td><input type="file" style="font-size:15px;" id="imgfile" name="imgfile" multiple></td>
                </tr> 
            </table>
            <div style="display: inline-block; margin-left: 200px;">
              

            </div>
            <div align="center" style="font-size: 15px; margin-top: 20px;">
                <input type="reset" value="게시물 등록 취소" >
                
            </div>
            <button type="submit">게시물 등록</button>
        </form>
    </div>
    
     <jsp:include page="../common/footer.jsp"></jsp:include>
     
     
</body>
</html>