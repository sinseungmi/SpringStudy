<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ������</title>
</head>
<body>

<h3># ��������</h3>

<ul>
	<li>�پ��� ȸ�������� �Է¹޴´� (���� ����)</li>
	<li>post������� ȸ�������� �Բ� ��û�ϸ� 
		������ ȸ�� ������ ������ data/user/ �ؿ� ���� ���·� �����Ѵ�</li>
	<li>���� �̸��� �ߺ��� ������ �ʵ��� �����ؾ��Ѵ�</li>
	<li>������ ������ �ִ� ��� ȸ������ ���� �������� �Ѿ���Ѵ�</li>
	<li>ȸ�����Կ� �����ϸ� ȸ������ ������������ 5�ʰ� ������ �� �ٽ� Ȩ���� �̵��Ѵ�</li>
</ul>

<hr>

�̰��� ȸ�� ������ �Է��ϼ���

<form action="/practice/user/memberinfo" method="post" accept-charset="utf-8">
	<ul>
		<li>���̵� : <input type="text" name="id"></li>
		<li>��й�ȣ : <input type="password" name="pw"></li>
		<li>�̸��� : <input type="email" name="email"></li>
		<li>�̸� : <input type="text" name="name"></li>
		<li>���� : <input type="text" name="age"></li>
		<li>������� : <input type="date" name="birthday"></li>	
		<li><input type="submit" value="���"></li>
	</ul>
</form>



</body>
</html>









