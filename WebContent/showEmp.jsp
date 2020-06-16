<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>従業員</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"></head>
<body>
<div class="container">
	<div class="alert alert-dark">
			<h1>従業員一覧</h1>
		</div>
	<table border="1" class="table table-dark">
		<thead class="thead-dark">
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
						<form action="/jmaster-gradle/EmployeeServlet" method="post">
						<input class="btn btn-primary" type="hidden" name="code" value="${employee.code}">
						<input class="btn btn-primary" type="hidden" name="action" value="delete">
						<input class="btn btn-danger" type="submit" value="削除">
						</form>
					</td>
					<td><a class="btn btn-primary" href="/jmaster-gradle/EmployeeUpdate.jsp?code=${employee.code}&name=${employee.name}&age=${employee.age}&tel=${employee.tel}">更新</a></td>
				</tr>

			</c:forEach>

		</tbody>
		</table>


	<div class="alert alert-dark">
		<h1>従業員追加</h1>
	</div>
	<form action="/jmaster-gradle/EmployeeServlet" method="post">

		<table border="1" class="table table-dark">

		<thead class="table-dark">
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
					<input type="hidden" name="action" value="add"> <input class="btn btn-success" type="submit" value="追加">
					</td>
				</tr>

		</tbody>
		</table>
	</form>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
</body>
</html>