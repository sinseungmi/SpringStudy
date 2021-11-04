<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p>${market }</p>
<p>${market.fruit }</p>
<p>${market.fruit.name }</p>

</body>
</html>
