package centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;



public class ControladorCurso {
	public JTextField jtfId;
	public JTextField jtfDescripcion;
	public Connection conn = null;
	
	public void cargarPrimerRegistro() {
		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id limit 1");

			if (rs.next()) {
				this.jtfId.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void cargarUltimoRegistro() {
		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id desc limit 1");

			if (rs.next()) {
				this.jtfId.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarSiguienteRegistro() {
		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso where id > " + jtfId.getText() + " order by id limit 1;");

			if (rs.next()) {
				this.jtfId.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarAnteriorRegistro() {
		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso where id < " + jtfId.getText() + " order by id desc limit 1;");

			if (rs.next()) {
				this.jtfId.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
