package centroEducativo.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import centroEducativo.model.Materia;
import centroEducativo.Conexion;
import centroEducativo.model.Curso;

public class ControladorMateria {

	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Materia getEntidadFromResultSet(String sql) {
		Materia materia = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				materia = new Materia();
				materia.setId(rs.getInt("id"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAcronimo(rs.getString("acronimo"));
				materia.setIdCurso(rs.getInt("curso_id"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return materia;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Materia findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.materia order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Materia findLast () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.materia order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Materia findNext (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.materia where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Materia findPrevious (int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.materia where id < " + actualId + " order by id desc limit 1");
	}

	

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Materia m) {
		
		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update materia set nombre = ?, acronimo = ?, curso_id = ? where id = ?");
		
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getAcronimo());
			ps.setInt(3, m.getIdCurso());
			ps.setInt(4, m.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int insertar (Materia m) {
		
		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into materia (id, nombre, acronimo, curso_id) "
					+ " values (?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, m.getNombre());
			ps.setString(3, m.getAcronimo());
			ps.setInt(4, m.getIdCurso());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int eliminar (int id) {
		
		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"delete from materia where id = ?");
		
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from materia");
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
}
