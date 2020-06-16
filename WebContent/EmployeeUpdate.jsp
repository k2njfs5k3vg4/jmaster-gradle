<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String codeString = request.getParameter("code");
	String name = request.getParameter("name");
	String ageString = request.getParameter("age");
	String tel = request.getParameter("tel");

	int code = Integer.parseInt(codeString);
	int age = Integer.parseInt(ageString);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Show All Employees</title>
</head>
<body>
	<div class="container">
		<div class="alert alert-dark">
			<h1>従業員更新</h1>
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
						<td><%=code%><input type="hidden" name="code"
							value="<%=code%>"></td>
						<td><input type="text" name="name" value="<%=name%>"></td>
						<td><input type="text" name="age" value="<%=age%>"><br></td>
						<td><input type="text" name="tel" value="<%=tel%>"></td>
						<td><input type="hidden" name="action" value="update">
							<input class="btn btn-success" type="submit" value="提出">
						</td>
					</tr>

				</tbody>
			</table>
		</form>

	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>