<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form action="/jmaster-gradle/EmployeeServlet2" method="post">
番号：<input type="number" name="code"><br>
名前：<input type="text" name="name"><br>
年齢：<input type="number" name="age"><br>
電話番号：<input type="text" name="tel"><br>
<input type="submit" value="追加">
<input type="hidden" name="action" value="add">
</form>

<form action="/jmaster-gradle/EmployeeServlet2" method="post">
番号：<input type="number" name="code"><br>
<input type="submit" value="削除">
<input type="hidden" name="action" value="delete">
</form>

<form action="/jmaster-gradle/EmployeeServlet2" method="post">
あいまい検索：<input type="text" name="name"><br>
<input type="submit" value="検索">
<input type="hidden" name="action" value="search">
</form>

</body>
</html>