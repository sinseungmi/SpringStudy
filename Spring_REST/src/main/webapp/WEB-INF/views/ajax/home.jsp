<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2># Ajax�� ����غ��ô�</h2>

<ul>
	<li>�������� ��� �ε�ǰ� �� �Ŀ� ������ �����͸� ��û�� �� �ֽ��ϴ�</li>
	<li>�������� �ٽ� �ε��� �ʿ���� ������Ʈ �� �� �ֽ��ϴ�</li>
	<li>��׶���� ������ �����͸� ������ �� �ֽ��ϴ�</li>
</ul>

<hr>

<div id="test">
	<h4>�޾ƿ� �����͸� �̰��� ����� ����.</h4>
</div>

<ul id="testList">
	<li>������ ����ִ� ����Ʈ</li>
</ul>

<button onclick="loadStr()">/getStr ��������</button> <br>
<button id="sampleAsyncBtn">/getloadSample ��������</button> <br>
<button id="asyncJsonDataBtn">/asyncJsonDataBtn��������</button> <br>

<!-- ������ �ٸ� �ڿ��� ����� ���� servlet-context�� �ڿ� ��θ� ����ؾ��Ѵ�. -->
<script src="<%=request.getContextPath() %>/resources/js/ajax_home.js"></script>
           <!-- �̰� ������ c:url�� -->
</body>
</html>











