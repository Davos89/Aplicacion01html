<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.davos.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Book</title>
</head>
<body>


	<%
		String isbn = request.getParameter("isbn");
	Libro libro = new Libro(isbn);
	libro.borrar();
	response.sendRedirect("MostrarLibros.jsp");
	%>

</body>
</html>