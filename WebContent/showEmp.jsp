<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Employee</title>
</head>
<body>

<table border="1">
<tr><td>NO.</td><td>社員名</td><td>年齢</td><td>電話番号</td></tr>

<c:forEach items="${emp}" var="emp">
<tr><td>${emp.code}</td><td>${emp.name}</td><td>${emp.age}</td><td>${emp.tel}</td></tr>
</c:forEach>

</table>


<input type="button" value="内容変更" onclick="clickBtn1()" />


<div id="p1">

<form action="/jmaster-gradle/UpdateServlet" method="post">
変更したい人の番号<br>
NO.<input type = number name = "code"><br>
変更部分を記入してください<br>
名前：<input type = text name = "name" >
年齢：<input type = number name = "age" >
電話番号：<input type = text name = "tel" >
<input type=submit value="登録">
</form>

</div>

<script>
//初期表示は非表示
document.getElementById("p1").style.display ="none";

function clickBtn1(){
	const p1 = document.getElementById("p1");

	if(p1.style.display=="block"){
		// noneで非表示
		p1.style.display ="none";
	}else{
		// blockで表示
		p1.style.display ="block";
	}
}
</script>


</body>
</html>