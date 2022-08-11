<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
        <th>id</th>
        <th>username</th>
        <th>age</th>
        <th>grade</th>
    </thead>
    <tbody>
        <c:forEach var="mem" items="${memberList}">
        <tr>
            <td>${mem.id}</td>
            <td>${mem.username}</td>
            <td>${mem.age}</td>
            <td>${mem.grade}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>