<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.davos.Libro"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Libros</title>
</head>
<body>
	<form action="MostrarLibros.jsp">
		<select name="categoria">
			<%
				List<String> listaDeCategorias = null;
			listaDeCategorias = (List<String>) request.getAttribute("listaDeCategorias");
			%>

			<option value="seleccionar">seleccionar</option>
			<%
				for (String categoria : listaDeCategorias) {

				if (categoria.equals(request.getParameter("categoria"))) {
			%>
			<option value="<%=categoria%>" selected><%=categoria%></option>
			<%
				} else {
			%>
			<option value="<%=categoria%>"><%=categoria%></option>
			<%
				}
			}
			%>

		</select> <input type="submit" value="filtrar" />
	</form>

	<%
		List<Libro> listaDeLibros = (List<Libro>)request.getAttribute("listaDeLibros");

	
	for (Libro libro : listaDeLibros) {
	%>
	<br />
	<%=libro.getIsbn()%>
	<%=libro.getTitulo()%>
	<%=libro.getCategoria()%>
	<a href="BorrarLibro.do?isbn=<%=libro.getIsbn()%>">Borrar</a>
	<a href="FormularioEditarLibro.do?isbn=<%=libro.getIsbn()%>">Editar</a>
	<br />
	<%
		}
	%>

	<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>