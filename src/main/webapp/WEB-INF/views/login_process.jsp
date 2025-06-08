<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
</head>

<body>
	성공!

		 <p><strong>${loginMember.name}님</strong> 
		로그인 완료.</p>
		<form action="${pageContext.request.contextPath}/MainPage" method="get">
		    <button type="submit">메인 화면 가기 </button>
		</form>
		 
</body>
</html>
