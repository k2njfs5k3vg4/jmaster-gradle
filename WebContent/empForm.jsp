<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<!-- </body> -->
<!-- </html> -->

<form action="/jmaster-gradle/ItemServlet" method="post">
追加：名前<input type="text" name="name">
年齢<input type="text" name="age">
電話<input type="text" name="tel">
<input type="submit" value="追加">
<input type="hidden" name="action" value="add">
</form>