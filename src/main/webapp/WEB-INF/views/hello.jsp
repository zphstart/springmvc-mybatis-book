<%--
  Created by IntelliJ IDEA.
  User: 26793
  Date: 2022/9/11
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Getting Started</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    hello,say
    ${time}
    <br>
    <c:forEach items="${list}" var="user" begin="0">
        ${index} - ${user.username}-${user.password}<br>
    </c:forEach>

</body>
</html>
