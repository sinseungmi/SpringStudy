<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>select</h3>

<c:forEach var="item" items="${iceList}">

     [번호] : ${item.ice_id}&nbsp; [이름] : ${item.ice_name}&nbsp; [가격] : ${item.price} <br>

</c:forEach>

</body>
</html>