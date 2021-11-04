<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 페이지</title>
</head>
<body>

<h3># 연습문제</h3>

<ul>
	<li>다양한 회원정보를 입력받는다 (생일 포함)</li>
	<li>post방식으로 회원정보와 함께 요청하면 
		전달한 회원 정보를 서버의 data/user/ 밑에 파일 형태로 저장한다</li>
	<li>파일 이름은 중복이 생기지 않도록 조심해야한다</li>
	<li>누락된 정보가 있는 경우 회원가입 실패 페이지로 넘어가야한다</li>
	<li>회원가입에 성공하면 회원가입 성공페이지를 5초간 보여준 후 다시 홈으로 이동한다</li>
</ul>

<hr>

이곳에 회원 정보를 입력하세요

<form action="/practice/user/memberinfo" method="post" accept-charset="utf-8">
	<ul>
		<li>아이디 : <input type="text" name="id"></li>
		<li>비밀번호 : <input type="password" name="pw"></li>
		<li>이메일 : <input type="email" name="email"></li>
		<li>이름 : <input type="text" name="name"></li>
		<li>나이 : <input type="text" name="age"></li>
		<li>생년월일 : <input type="date" name="birthday"></li>	
		<li><input type="submit" value="등록"></li>
	</ul>
</form>



</body>
</html>









