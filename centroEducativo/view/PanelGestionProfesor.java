package centroEducativo.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import centroEducativo.controller.ControladorProfesor;
import centroEducativo.controller.ControladorEstudiante;
import centroEducativo.controller.ControladorMateria;
import centroEducativo.model.Profesor;
import centroEducativo.model.Materia;

public class PanelGestionProfesor extends JPanel {


	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
	PanelDatosPersonales datosPersonales;
	private byte[] contenidoImagen;
	/**
	 * Create the panel.
	 */
	public PanelGestionProfesor() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de estudiantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.weightx=2;
		gbc_lblNewLabel.weighty=0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		datosPersonales = new PanelDatosPersonales();
		GridBagConstraints gbc_datosPersonales = new GridBagConstraints();
		gbc_datosPersonales.fill = GridBagConstraints.HORIZONTAL;
		gbc_datosPersonales.insets = new Insets(0, 0, 5, 0);
		gbc_datosPersonales.gridx = 1;
		gbc_datosPersonales.gridy = 1;
		gbc_lblNewLabel.weightx=2;
		gbc_lblNewLabel.weighty=1;
		add(datosPersonales, gbc_datosPersonales);
	
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		gbc_lblNewLabel.weightx=2;
		gbc_lblNewLabel.weighty=0;
		add(panel, gbc_panel);
		
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findPrevious(
						Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findNext(
						Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorProfesor.findLast());
			}
		});
		panel.add(btnUltimo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		panel.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		panel.add(btnEliminar);
		
		cargarPrimero();
	}

	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = { "Sí", "No" };
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono
		// mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", "Eliminación",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas,
				posiblesRespuestas[1]);
		if (opcionElegida == 0) {
			int actualId = Integer.parseInt(this.jtfId.getText());
			if (ControladorProfesor.eliminar(actualId) != 1) {
				JOptionPane.showMessageDialog(null, "Algo ha salido mal");
			} else {
				// Cargo otro registro en pantalla
				Profesor mAnterior = ControladorProfesor.findPrevious(actualId);
				if (mAnterior != null) {
					cargarEnPantalla(mAnterior);
				} else {
					Profesor mSiguiente = ControladorProfesor.findNext(actualId);
					if (mSiguiente != null) {
						cargarEnPantalla(mSiguiente);
					} else { // No quedan registros, has eliminado el único
						limpiarDatos();
					}
				}
			}
		}

	}

	/**
	 * 
	 */
	private void limpiarDatos() {
		this.jtfId.setText("0");
		this.jtfNombre.setText("");
		this.jtfApellido1.setText("");
		this.jtfApellido2.setText("");
		this.jtfDni.setText("");
		this.jtfDireccion.setText("");
		this.jtfEmail.setText("");
		this.jtfTelefono.setText("");

	}

	/**
	 * 
	 */
	private void guardar() {
		Profesor m = new Profesor();
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setNombre(this.jtfNombre.getText());
		m.setApellido1(this.jtfApellido1.getText());
		m.setApellido2(this.jtfApellido2.getText());
		m.setDni(this.jtfDni.getText());
		m.setDireccion(this.jtfDireccion.getText());
		m.setEmail(this.jtfEmail.getText());
		m.setTelefono(this.jtfTelefono.getText());

		String strError = "No se ha podido guardar";
		if (m.getId() == 0) {
			int nuevoIdInsertado = ControladorProfesor.insertar(m);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			} else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		} else {
			if (ControladorProfesor.modificar(m) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}

	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorProfesor.findFirst());
	}

	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla(Profesor p) {
		if (p != null) {
			this.jtfId.setText("" + m.getId());
			this.jtfNombre.setText(m.getNombre());
			this.jtfApellido1.setText(m.getApellido1());
			this.jtfApellido2.setText(m.getApellido2());
			this.jtfDni.setText(m.getDni());
			this.jtfDireccion.setText(m.getDireccion());
			this.jtfEmail.setText(m.getEmail());
			this.jtfTelefono.setText(m.getTelefono());
		}

		// Habilito y deshabilito botones de navegación
		if (ControladorProfesor.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		} else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorProfesor.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		} else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}

	}

}