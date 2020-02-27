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
<title>Artist List</title>
</head>
<h1>Artist List</h1>
<body>
<a href = "viewAllSongsServlet">Go to song list</a><br />

<form method ="post" action ="artistNavigationServlet">
<table>
<c:forEach items="${requestScope.allArtists}" var="currentitem">
<tr>
<td><input type="radio" name ="id" value="${currentitem.id}"></td>
<td>${currentitem.artistName}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value ="edit" name="doThisToItem">
<input type="submit" value="delete" name="doThisToItem">
</form>

</body>
</html>