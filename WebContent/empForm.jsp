<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form action="/jmaster-gradle/ItemServlet" method="post">
追加：名前<input type="text" name="name">
年齢<input type="text" name="age">
電話<input type="text" name="tel">
<input type="submit" value="追加">
<input type="hidden" name="action" value="add">
</form>


<form action="/jmaster-gradle/ItemServlet" method="post">
削除：code<input type="text" name="code">
番のレコードを<input type="submit" value="削除">
<input type="hidden" name="action" value="delete">
</form>

<form action="/jmaster-gradle/ItemServlet" method="post">
検索：age<input type="text" name="age">
歳以下の社員を<input type="submit" value="検索">
<input type="hidden" name="action" value="search">
</form>