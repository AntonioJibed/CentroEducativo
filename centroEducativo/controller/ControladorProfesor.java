package centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import centroEducativo.Conexion;
import centroEducativo.model.Profesor;

public class ControladorProfesor {

	private static Profesor getEntidadFromResultSet(String sql) {
		Profesor profesor = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				profesor = new Profesor();
				profesor.setId(rs.getInt("id"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setApellido1(rs.getString("apellido1"));
				profesor.setApellido2(rs.getString("apellido2"));
				profesor.setDni(rs.getString("dni"));
				profesor.setDireccion(rs.getString("direccion"));
				profesor.setEmail(rs.getString("email"));
				profesor.setTelefono(rs.getString("telefono"));

			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profesor;
	}

	public static Profesor findFirst() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.profesor order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Profesor findLast() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.profesor order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Profesor findNext(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.profesor where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Profesor findPrevious(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.profesor where id < " + actualId + " order by id desc limit 1");
	}

	public static int modificar(Profesor m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("update profesor set nombre = ?, apellido1 = ?, apellido2 = ?, "
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
	public static int insertar(Profesor m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) "
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
			PreparedStatement ps = conn.prepareStatement("delete from profesor where id = ?");

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
			PreparedStatement ps = conn.prepareStatement("select max(id) from profesor");

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
