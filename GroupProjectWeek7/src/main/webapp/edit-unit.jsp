<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Unit</title>
</head>
<body>
	<form action="editUnitServlet" method="post">
	Unit Name: <input type="text" name="unitName" value="${unitToEdit.unitName}">
	Unit Type: <input type="text" name="unitType"value="${unitToEdit.unitType}">
	Unit Cost: <input type="text" name="unitCost"value="${unitToEdit.unitCost}">
	<input type="hidden" name="id" value="${unitToEdit.id}">
	<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>