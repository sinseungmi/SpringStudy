<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2># Ajax를 사용해봅시다</h2>

<ul>
	<li>페이지가 모두 로드되고 난 후에 서버로 데이터를 요청할 수 있습니다</li>
	<li>페이지를 다시 로딩할 필요없이 업데이트 할 수 있습니다</li>
	<li>백그라운드로 서버로 데이터를 전송할 수 있습니다</li>
</ul>

<hr>

<div id="test">
	<h4>받아온 데이터를 이곳에 출력할 예정.</h4>
</div>

<ul id="testList">
	<li>아직은 비어있는 리스트</li>
</ul>

<button onclick="loadStr()">/getStr 가져오기</button> <br>
<button id="sampleAsyncBtn">/getloadSample 가져오기</button> <br>
<button id="asyncJsonDataBtn">/asyncJsonDataBtn가져오기</button> <br>

<!-- 서버의 다른 자원을 사용할 때는 servlet-context의 자원 경로를 사용해야한다. -->
<script src="<%=request.getContextPath() %>/resources/js/ajax_home.js"></script>
           <!-- 이게 싫으면 c:url써 -->
</body>
</html>











