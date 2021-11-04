<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</style>
</head>
<body>

<c:if test="${login }">
	<h3>로그인 성공</h3>
</c:if>
<c:if test="${not login }">
	<h3>로그인 실패</h3>
</c:if>

<a href="./check">로그인 여부에 따라 다르게 보이는 페이지로 가기</a>

</body>
</html>






















