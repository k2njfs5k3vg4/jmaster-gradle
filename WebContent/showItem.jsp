<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show emp all</title>
</head>
<body>

<jsp:include page="empForm.jsp"/>
<hr>

<table border="1">

<tr><td>code</td><td>name</td><td>age</td><td>tel</td></tr>
<c:forEach items="${emps}" var="emps">

<tr><td>${emps.code}</td><td>${emps.name}</td><td>${emps.age}</td><td>${emps.tel}</td></tr>

</c:forEach>



</table>



</body>
</html>