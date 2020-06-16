<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Employees</title>
</head>
<body>

	<form action="/jmaster-gradle/EmployeeServlet" method="post">
		<table border="1">
			<tr>
				<td>NO</td>
				<td>従業員名</td>
				<td>年齢</td>
				<td>電話番号</td>
				<td>削除</td>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.code}</td>
					<td>${employee.name}</td>
					<td>${employee.age}</td>
					<td>${employee.tel}</td>
					<td>
						<input type="hidden" name="code" value="${employee.code}">
						<input type="hidden" name="action" value="delete">
						<input type="submit" value="削除">
					</td>
				</tr>

			</c:forEach>

		</table>
	</form>
	<form action="/jmaster-gradle/EmployeeServlet" method="post">
		<h1>従業員追加</h1>
		NO : <input type="text" name="code"><br>
		従業員名 : <input type="text" name="name"><br>
		年齢 : <input type="text" name="age"><br> 電話番号 : <input type="text" name="tel"><br>
		<input type="hidden" name="action" value="add"> <input type="submit" value="提出">
	</form>

</body>
</html>