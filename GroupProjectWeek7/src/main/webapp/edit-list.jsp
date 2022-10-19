<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
	<form action="editListDetailServlet" method="post">
		<input type="hidden" name="id" value="${listToEdit.id}">
		List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br />
		List Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
		<input type="text" name="day" placeholder="dd" size="4" value="${date}">
		<input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
		
		Player Name: <input type="text" name="playerName" value="${listToEdit.player.playerName}"><br />
		Army: <input type="text" name="army" value="${listToEdit.player.army}"><br />
		
		Available Units:<br />
		
		<select name="allUnitsToAdd" multiple size="6" style="width: 300px">
			<c:forEach items="${requestScope.allUnits}" var="currentUnit">
				<option value="${currentUnit.id}">${currentUnit.unitName} | ${currentUnit.unitType} | ${currentUnit.unitCost}</option>
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Edit List and Add Units">
	</form>
	
	<form action="startApp.html">
    <input type="submit" value="Go add new units instead." />
	</form>
</body>
</html>