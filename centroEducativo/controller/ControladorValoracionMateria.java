package centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import centroEducativo.Conexion;
import centroEducativo.model.ValoracionMateria;

public class ControladorValoracionMateria {
	private static ValoracionMateria getEntidadFromResultSet(String sql) {
		ValoracionMateria valoracionMateria = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				valoracionMateria = new ValoracionMateria();
				valoracionMateria.setId(rs.getInt("id"));
				valoracionMateria.setIdProfesor(rs.getInt("idProfesor"));
				valoracionMateria.setIdEstudiante(rs.getInt("idEstudiante"));
				valoracionMateria.setIdMateria(rs.getInt("idMateria"));
				valoracionMateria.setValoracion(rs.getFloat("valoracion"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valoracionMateria;
	}

	public static ValoracionMateria findFirst() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.valoracionMateria order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findLast() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo.valoracionMateria order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findNext(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionMateria where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria findPrevious(int actualId) {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionMateria where id < " + actualId + " order by id desc limit 1");
	}

	public static int modificar(ValoracionMateria m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("update valoracionMateria set idProfesor = ?, idEstudiante = ?, idMateria = ?, "
							+ "valoracion = ? where id = ?");

			ps.setInt(1, m.getIdProfesor());
			ps.setInt(2, m.getIdEstudiante());
			ps.setInt(3, m.getIdMateria());
			ps.setFloat(4, m.getValoracion());
			ps.setInt(5, m.getId());
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
	public static int insertar(ValoracionMateria m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into valoracionMateria (id, idProfesor, idEstudiante, idMateria, idValoracion) "
							+ " values (?, ?, ?, ?, ?)");

			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setInt(1, m.getIdProfesor());
			ps.setInt(2, m.getIdEstudiante());
			ps.setInt(3, m.getIdMateria());
			ps.setFloat(4, m.getValoracion());
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
			PreparedStatement ps = conn.prepareStatement("delete from valoracionMateria where id = ?");

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
			PreparedStatement ps = conn.prepareStatement("select max(id) from valoracionMateria");

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
