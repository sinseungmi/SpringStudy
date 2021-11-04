<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인을 체크하는 페이지</title>
	<c:if test="${login == '1'}">
		<style>
			h1 {
				color: blue;
			}	
		</style>
	</c:if>
	
	<c:if test="${login != '1'}">
		<style>
			h1 {
				color: red;
			}	
		</style>
	</c:if>
</head>
<body>

	<h1>로그인 상태따라 다르게 보인다</h1>

</body>
</html>