<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
</style>
</head>
<body>

<c:if test="${login }">
	<h3>�α��� ����</h3>
</c:if>
<c:if test="${not login }">
	<h3>�α��� ����</h3>
</c:if>

<a href="./check">�α��� ���ο� ���� �ٸ��� ���̴� �������� ����</a>

</body>
</html>






















