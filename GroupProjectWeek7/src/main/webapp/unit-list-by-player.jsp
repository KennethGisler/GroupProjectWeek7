<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player Lists</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.listName}</h2></td>
				</tr>
				<tr><td colspan="3">List Date: ${currentlist.dateAdded}</td></tr>
				<tr><td colspan="3">Player: ${currentlist.player.playerName}</td></tr>
				<c:forEach var="currentUnit" items="${currentlist.roster}">
					<tr>
						<td></td><td colspan="3">
							${currentUnit.unitName}, ${currentUnit.unitType}, ${currentUnit.unitCost}
						</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList">
		<input type="submit" value="delete" name="doThisToList">
		<input type="submit" value="add" name="doThisToList">
	</form>
	
	<form action="addUnitsForListServlet">
    <input type="submit" value="Create a new List" />
	</form>
	
	<form action="startApp.html">
    <input type="submit" value="Insert a new unit" />
	</form>
</body>
</html>