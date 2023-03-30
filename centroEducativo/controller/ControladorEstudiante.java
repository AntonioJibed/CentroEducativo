package centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import centroEducativo.Conexion;
import centroEducativo.model.Estudiante;

public class ControladorEstudiante {

	private static Estudiante getEntidadFromResultSet(String sql) {
		Estudiante estudiante = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				estudiante = new Estudiante();
				estudiante.setId(rs.getInt("id"));
				estudiante.setNombre(rs.getString("nombre"));
				estudiante.setApellido1(rs.getString("apellido1"));
				estudiante.setApellido2(rs.getString("apellido2"));
				estudiante.setDni(rs.getString("dni"));
				estudiante.setDireccion(rs.getString("direccion"));
				estudiante.setEmail(rs.getString("email"));
				estudiante.setTelefono(rs.getString("telefono"));
				estudiante.setColorPreferido(rs.getString("colorPreferido"));
				estudiante.setIdTipologiaSexo(rs.getInt("idTipologiaSexo"));

			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return estudiante;
	}

	public static Estudiante findFirst() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.estudiante order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Estudiante findLast() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.estudiante order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Estudiante findNext(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Estudiante findPrevious(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante where id < " + actualId + " order by id desc limit 1");
	}

	public static int modificar(Estudiante m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("update estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, "
							+ "dni = ?, direccion = ?, email = ?, telefono = ? where id = ?");

			ps.setString(1, m.getNombre());
			ps.setString(2, m.getApellido1());
			ps.setString(3, m.getApellido2());
			ps.setString(4, m.getDni());
			ps.setString(5, m.getDireccion());
			ps.setString(6, m.getEmail());
			ps.setString(7, m.getTelefono());
			ps.setInt(8, m.getId());
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
	public static int insertar(Estudiante m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) "
							+ " values (?, ?, ?, ?, ?, ?, ?, ?)");

			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, m.getNombre());
			ps.setString(3, m.getApellido1());
			ps.setString(4, m.getApellido2());
			ps.setString(5, m.getDni());
			ps.setString(6, m.getDireccion());
			ps.setString(7, m.getEmail());
			ps.setString(8, m.getTelefono());
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
			PreparedStatement ps = conn.prepareStatement("delete from estudiante where id = ?");

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
			PreparedStatement ps = conn.prepareStatement("select max(id) from estudiante");

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
