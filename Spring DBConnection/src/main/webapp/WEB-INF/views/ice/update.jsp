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
	������ ���̽�ũ�� �̸� : <input type="text" name="ice_name"> <br>
	���̽�ũ�� �̸� ���� : <input type="text" name="change_name"> <br>
	���̽�ũ�� ���� ���� : <input type="text" name="price"> <br>
	<input type="submit" value="���">
</form>
</body>
</html>