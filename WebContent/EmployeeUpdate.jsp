<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setContentType("text/html; charset=UTF-8");
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
<title>Show All Employees</title>
</head>
<body>
	<h1>従業員更新</h1>
	<form action="/jmaster-gradle/EmployeeServlet" method="post">
		No : <%=code %><input type="hidden" name="code" value="<%=code %>"><br>
		従業員名 : <input type="text" name="name" value="<%=name %>"><br>
		年齢 : <input type="text" name="age" value="<%=age %>"><br>
		電話番号 : <input type="text" name="tel" value="<%=tel %>"><br>
		<input type="hidden" name="action" value="update"> <input type="submit" value="提出">
	</form>

</body>
</html>