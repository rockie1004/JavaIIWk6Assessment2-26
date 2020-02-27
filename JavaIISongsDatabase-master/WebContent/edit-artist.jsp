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
<title>Edit Artist</title>
</head>
<h1>Edit an Artist</h1>
<body>
<form action ="editArtistServlet" method="post">
Artist: <input type ="text" name ="artistName" value="${artistToEdit.artistName}">
<input type ="hidden" name ="id" value="${artistToEdit.id}">
<input type = "submit" value= "Save Edited Artist">
</form>
</body>
</html>