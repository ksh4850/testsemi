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
        <form action=""  > 
            <table class="table-set">
                <tr>
                    <td ><label>카테고리 목록 : </label></td>
                    <td >
                        <select > 
                            <option value="" aria-checked="">대분류</option>
                            <option value="">의류</option>
                            <option value="">전자제품</option>
                        </select>
                        <select > 
                            <option value="" aria-checked="">소분류</option>
                            <option value="">옷</option>
                            <option value="">신발</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td ><label >게시물 제목 : </label></td>
                    <td><input type="text" required></td>
                </tr>
                <tr>
                    <td ><label style="padding-bottom: 250px;">게시물 내용 : </label></td>
                    <td><textarea name="" id="" cols="30" rows="10" required></textarea></td>
                </tr>
                <tr>
                    <td ><label >미개봉 여부 : </label></td>
                    <td><input type="checkbox" width="30px" height="30px" ></td>
                </tr>
                <tr>
                    <td ><label >최소 입찰가 : </label></td>
                    <td><input type="number" step="100" required></td>
                </tr>
                <tr>
                    <td colspan="2" style="font-size: 15px; color: red;"><li>입찰일로 부터 72시간 동안 투찰이 진행됩니다.</li></td>
                </tr>
                <tr>

                    <td>첨부사진 :</td>
                    <td><input type="file" style="font-size:15px;" id="imgfile"></td>
                </tr>
            </table>
            <div style="display: inline-block; margin-left: 200px;">
                <img src="sample/image/flower3.PNG" alt="1" width="150px" height="150px" >
                <img src="sample/image/flower3.PNG" alt="1" width="150px" height="150px" >
                <img src="sample/image/flower3.PNG" alt="1" width="150px" height="150px" >
                <img src="sample/image/flower3.PNG" alt="1" width="150px" height="150px" >
                <img src="sample/image/flower3.PNG" alt="1" width="150px" height="150px" >

            </div>
            <div align="center" style="font-size: 15px; margin-top: 20px;">
                <input type="reset" value="게시물 등록 취소" >
                <input type="submit" value="게시물 등록" >
            </div>
        </form>
    </div>
    
    
    
     <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>