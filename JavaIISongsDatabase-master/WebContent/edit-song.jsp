<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style type="text/css">
td
{
    padding:0 15px;
}
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Song</title>
</head>
<h1>Edit a Song</h1>
<body>
<form action ="editSongServlet" method="post">
Artist: <input type ="text" name ="artist" value="${songToEdit.artist}">
Song Title: <input type ="text" name ="title" value="${songToEdit.title}">
<input type ="hidden" name ="id" value="${songToEdit.id}">
<input type = "submit" value= "Save Edited Song">
</form>
</body>
</html>