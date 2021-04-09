<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	(function(){
		const successCode = "${ requestScope.successCode }";
		
		var successMessage = "";
		var movePath = "";
		
		switch(successCode){
			case "insertMember" :
				successMessage = "회원 가입에 성공하셨습니다!";
				movePath = "${ pageContext.servletContext.contextPath }/index.jsp";
				break;
				
			case "updateMember" :
				successMessage = "회원정보 수정에 성공하셨습니다!";
				movePath = "${ pageContext.servletContext.contextPath }/index.jsp";
				break;
				
			case "deleteMember" :
				successMessage = "회원정보 탈퇴에 성공하셨습니다!";
				movePath = "${ pageContext.servletContext.contextPath }/index.jsp";
				break;
			
			case "login" :
				successMessage = "로그인 되었습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/index.jsp";
				break;
			case "PostRegist" :
				successMessage = "게시물이 등록 되었습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/post/list?scategory=${requestScope.scategory}";
				break;	
		}
		
		alert(successMessage);
		
		location.replace(movePath);
		//뒤로가 안되기!!
	})();

		
	</script>
</body>
</html>