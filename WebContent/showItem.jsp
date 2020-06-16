<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><td>社員番号</td><td>名前</td><td>年齢</td><td>電話番号</td></tr>
<c:forEach items="${employees}" var="employee">
<tr><td>${employee.code}</td><td>${employee.name}</td><td>${employee.age}</td><td>${employee.tel}</td></tr>
</c:forEach>
</table>

</body>
</html>
