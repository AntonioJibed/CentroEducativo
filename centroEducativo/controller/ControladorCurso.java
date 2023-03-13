package centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import centroEducativo.Conexion;
import centroEducativo.model.Curso;
import centroEducativo.model.Materia;

public class ControladorCurso {

	private static Curso getEntidadFromResultSet(String sql) {
		Curso curso = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return curso;
	}

	public static Curso findFirst() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.curso order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Curso findLast() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.curso order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Curso findNext(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.curso where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Curso findPrevious(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.curso where id < " + actualId + " order by id desc limit 1");
	}

	public static int modificar(Curso m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement("update curso set descripcion = ? where id = ?");

			ps.setString(1, m.getDescripcion());
			ps.setInt(2, m.getId());
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
	public static int insertar(Curso m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement("insert into curso (id, descripcion) " + " values (?, ?)");

			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, m.getDescripcion());
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
	public static int eliminar(int id) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement("delete from curso where id = ?");

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

	private static int getSiguientIdValido() {
		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement("select max(id) from materia");

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

	public static List<Curso> findAll() {
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from curso");

			while (rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				cursos.add(c);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return cursos;
	}

}
