package com.davos;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/arquitecturajava?serverTimezone=GMT-3";
	private static final String USUARIO = "root";
	private static final String CLAVE = "manu20";

	public int modificarRegistro(String consultaSQL) throws ClassNotFoundException, SQLException{

		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
		} catch (ClassNotFoundException e) {

			System.out.println("Error driver" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error de SQL" + e.getMessage());
			throw e;
		} finally {

			if (sentencia != null) {
				try {
					sentencia.close();
				} catch (SQLException e) {
				}
			}

			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
				}
			}
		}
		return filasAfectadas;
	}

	public List<T> seleccionarRegistros(String consultaSQL, Class clase) throws ClassNotFoundException, SQLException{

		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos = new ArrayList<T>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);

			while (filas.next()) {
				T objeto = (T) Class.forName(clase.getName()).getDeclaredConstructor().newInstance();
				Method[] metodos = objeto.getClass().getDeclaredMethods();

				for (int i = 0; i < metodos.length; i++) {
					if (metodos[i].getName().startsWith("set")) {
						metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
					}
					if (objeto.getClass().getName().equals("java.lang.String")) {
						objeto = (T) filas.getString(1);
					}
				}
				listaDeObjetos.add(objeto);
				
			}
		} catch (Exception e) {
			System.out.println("Error al seleccionar registros " + e);
		}

		finally {
			if (sentencia != null) {
				try {
					sentencia.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			return listaDeObjetos;
		}

	}

}
