<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>update</h3>

<form action="/dbpractice/updateIce" method="post">
	수정할 아이스크림 이름 : <input type="text" name="ice_name"> <br>
	아이스크림 이름 수정 : <input type="text" name="change_name"> <br>
	아이스크림 가격 수정 : <input type="text" name="price"> <br>
	<input type="submit" value="등록">
</form>
</body>
</html>