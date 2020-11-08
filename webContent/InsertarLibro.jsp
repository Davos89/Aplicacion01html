<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- sentencias de import necesarias para jdbc-->
<%@ page import="com.davos.Libro"%>

<%
	
//1Lee la información que proviene de FormularioInsertarLibro.html usando el objeto request de JSP.
	
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	Libro libro= new Libro(isbn,titulo,categoria);
	libro.insertar();
	
	response.sendRedirect("MostrarLibros.jsp");

%>