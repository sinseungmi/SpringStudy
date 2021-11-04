<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>delete</h3>

<form action="/dbpractice/deleteIce" method="post">
	삭제할 아이스크림 이름 : <input type="text" name="ice_name">
	<input type="submit" value="전송">
</form>


</body>
</html>