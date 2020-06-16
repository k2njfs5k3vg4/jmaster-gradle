<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>社員情報</title>
<style>
h1{
	text-align:center;
	padding-top:20px;
	padding-bottom:20px;
	color:#FFFFFF;
	background-color:#000033;
	margin:0px;
}
.wrapper{
	display: flex;
	text-align:center;
}
form{
	margin-left:auto;
	margin-right:auto;
}
.table_center{
	width: 50%;
	text-align:center;
	margin:auto;
	padding-top:20px;
}
table{
	vertical-align: middle;
	margin-left:auto;
	margin-right:auto;

}
input{
  margin:10px;
}
</style>
</head>
<body>
<h1>社員情報確認ページ</h1>
<div class="table_center">
<table class="table table-striped" border="1">
<tr><td>社員番号</td><td>名前</td><td>年齢</td><td>電話番号</td></tr>
<c:forEach items="${employees}" var="employee">
<tr><td>${employee.code}</td><td>${employee.name}</td><td>${employee.age}</td><td>${employee.tel}</td></tr>
</c:forEach>
</table><br>
</div>

<div class="wrapper">
<form action="/jmaster-gradle/EmployeeServlet" method="post">
<h2>社員の追加</h2>
社員番号：<input type="text" name="input_code"><br>
名前　　：<input type="text" name="input_name"><br>
年齢　　：<input type="text" name="input_age"><br>
電話番号：<input type="text" name="input_tel"><br>
<input type="hidden" name="action" value="add_info">
<input class="btn btn-outline-primary w-75"  type="submit" value="追加">
</form><br>

<form action="/jmaster-gradle/EmployeeServlet" method="post">
<h2>社員の削除</h2>
削除する社員番号：<input type="text" name="input_code"><br>
<input type="hidden" name="action" value="delete_info">
<input class="btn btn-outline-danger w-75" type="submit" value="削除">
</form><br>

<form action="/jmaster-gradle/EmployeeServlet" method="post">
<h2>社員情報の更新</h2>
社員番号：<input type="text" name="input_code"><br>
名前　　：<input type="text" name="input_name"><br>
年齢　　：<input type="text" name="input_age"><br>
電話番号：<input type="text" name="input_tel"><br>
<input type="hidden" name="action" value="update_info">
<input type="submit" class="btn btn-outline-warning w-75" value="更新">
</form><br>
</div>

</body>
</html>
