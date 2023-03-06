package centroEducativo.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import centroEducativo.model.Curso;


public class ControladorCurso {
	public static List<Curso> obtenerTodosLosCursos() {
		List<Curso> lista = new ArrayList<Curso>();
		
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) Conexion.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from fabricante");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) { 
				Curso f = new Curso(rs.getInt("id"), rs.getString("descripcion"));
				lista.add(f);
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		return lista;
	}

}
