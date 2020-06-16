<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>

<h1>一件、データベースに追加しました。</h1>
<table border="1">
<tr><td>NO.</td><td>社員名</td><td>年齢</td><td>電話番号</td></tr>

<c:forEach items="${emp}" var="emp">
<tr><td>${emp.code}</td><td>${emp.name}</td><td>${emp.age}</td><td>${emp.tel}</td></tr>
</c:forEach>

</table>

</body>
</html>