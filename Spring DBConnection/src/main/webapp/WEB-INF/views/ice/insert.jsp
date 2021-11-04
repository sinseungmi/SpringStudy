<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>insert</h3>

<form action="/dbpractice/createIce" method="post">
	아이스크림 이름 : <input type="text" name="ice_name"> <br>
	아이스크림 가격 : <input type="text" name="price"> <br>
	<input type="submit" value="전송">
</form>

</body>
</html>