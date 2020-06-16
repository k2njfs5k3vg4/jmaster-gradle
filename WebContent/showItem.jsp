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
</table><br>

<form action="/jmaster-gradle/EmployeeServlet" method="post">
社員番号：<input type="text" name="input_code"><br>
名前：<input type="text" name="input_name"><br>
年齢：<input type="text" name="input_age"><br>
電話番号<input type="text" name="input_tel"><br>
<input type="hidden" name="action" value="add_info">
<input type="submit" value="追加">
</form><br>

<form action="/jmaster-gradle/EmployeeServlet" method="post">
削除する番号：<input type="text" name="input_code"><br>
<input type="hidden" name="action" value="delete_info">
<input type="submit" value="削除">
</form><br>

<form action="/jmaster-gradle/EmployeeServlet" method="post">
社員番号：<input type="text" name="input_code"><br>
名前：<input type="text" name="input_name"><br>
年齢：<input type="text" name="input_age"><br>
電話番号<input type="text" name="input_tel"><br>
<input type="hidden" name="action" value="update_info">
<input type="submit" value="社員情報の更新">
</form><br>

</body>
</html>
