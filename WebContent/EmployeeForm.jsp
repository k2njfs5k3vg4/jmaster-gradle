<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Employee.css">
<meta charset="UTF-8">
</head>
<body>

<form action="/jmaster-gradle/EmployeeServlet2" method="post">
<dl>
<dt>番号：</dt>
<dd><input type="number" name="code"></dd>
<dt>名前：</dt>
<dd><input type="text" name="name"></dd>
<dt>年齢：</dt>
<dd><input type="number" name="age"></dd>
<dt>電話番号：</dt>
<dd><input type="text" name="tel"></dd>
<dd><input type="submit" value="追加"></dd>
<dd><input type="hidden" name="action" value="add"></dd>
</dl>
</form>

<form action="/jmaster-gradle/EmployeeServlet2" method="post">
<dl>
<dt>更新するユーザ番号を<br>入力してください。</dt>
<dd><input type="number" name="code"><br><br></dd>
<dt>名前：</dt>
<dd><input type="text" name="name"></dd>
<dt>年齢：</dt>
<dd><input type="number" name="age"></dd>
<dt>電話番号：</dt>
<dd><input type="text" name="tel"></dd>

<dd><button class="button8" type="submit" value="更新">更新</button></dd>

<dd><input type="hidden" name="action" value="update"></dd>
</dl>
</form>

<form action="/jmaster-gradle/EmployeeServlet2" method="post">
<dl>
<dt>番号：</dt>
<dd><input type="number" name="code"></dd>
<dd><button class="button2" type="submit" value="削除">削除</button></dd>
<dd><input type="hidden" name="action" value="delete"></dd>
</dl>
</form>

<form action="/jmaster-gradle/EmployeeServlet2" method="post">
<dl>
<dt>あいまい検索：</dt>
<dd><input type="text" name="name"></dd>
<dd><input type="submit" value="検索"></dd>
<dd><input type="hidden" name="action" value="search"></dd>
</dl>
</form>

</body>
</html>