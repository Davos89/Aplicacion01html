package com.davos.aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.davos.Libro;

public class ControladorLibros extends HttpServlet {

	
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RequestDispatcher despachador = null;
			
			List<Libro> listaDeLibros = Libro.buscarTodos();
			List<String> listaDeCategorias = Libro.buscarTodasLasCategorias();
			
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			
			despachador = request.getRequestDispatcher("MostrarLibros.jsp");
			despachador.forward(request, response);
			
		}
	

}
