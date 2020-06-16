<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrapの使い方</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form action="/jmaster-gradle/EmployeeServlet" method="post">
	<table border="1" class="table table-striped">
		<thead class="thead-light">
			<tr>
				<th scope="col">NO</th>
				<th scope="col">従業員名</th>
				<th scope="col">年齢</th>
				<th scope="col">電話番号</th>
				<th scope="col">削除</th>
				<th scope="col">更新</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.code}</td>
					<td>${employee.name}</td>
					<td>${employee.age}</td>
					<td>${employee.tel}</td>
					<td>
						<input class="btn btn-primary" type="hidden" name="code" value="${employee.code}">
						<input class="btn btn-primary" type="hidden" name="action" value="delete">
						<input class="btn btn-danger" type="submit" value="削除">
					</td>
					<td><a class="btn btn-primary" href="/jmaster-gradle/EmployeeUpdate.jsp?code=${employee.code}&name=${employee.name}&age=${employee.age}&tel=${employee.tel}">更新</a></td>
				</tr>

			</c:forEach>
		</tbody>
		</table>
	</form>


	<form action="/jmaster-gradle/EmployeeServlet" method="post">

		<table border="1" class="table table-striped">
		<thead class="thead-light">
			<tr>
				<th scope="col">NO</th>
				<th scope="col">従業員名</th>
				<th scope="col">年齢</th>
				<th scope="col">電話番号</th>
				<th scope="col">追加</th>
			</tr>
		</thead>
		<tbody>

				<tr>
					<td><input type="text" name="code"></td>
					<td> <input type="text" name="name"></td>
					<td><input type="text" name="age"><br></td>
					<td> <input type="text" name="tel"></td>
					<td>
					<input type="hidden" name="action" value="add"> <input class="btn btn-primary" type="submit" value="追加">
					</td>
				</tr>

		</tbody>
		</table>
	</form>
</div>


<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>