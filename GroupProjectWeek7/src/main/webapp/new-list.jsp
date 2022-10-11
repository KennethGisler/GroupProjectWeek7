<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
	<form action ="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br />
		List Date: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">,
		<input type="text" name="year" placeholder="yyyy" size="4">
		Player Name: <input type="text" name="playerName"><br />
		Army: <input type="text" name="army"><br />
		
		Available Units:<br />
		<select name="allItemsToAdd" multiple size="6" style="width: 300px">
			<c:forEach items="${requestScope.allItems}" var="currentItem">
				<option value="${currentItem.id}">${itemToEdit.unitName} | ${itemToEdit.unitType} | ${itemToEdit.unitCost}</option>
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Create List and Add Items">
	</form>
	
	<form action="startApp.html">
    <input type="submit" value="Go add new units instead." />
	</form>
</body>
</html>