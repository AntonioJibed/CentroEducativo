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
import centroEducativo.controller.ControladorValoracionMateria;
import centroEducativo.model.Profesor;
import centroEducativo.model.ValoracionMateria;

public class PanelGestionValoracionMateria extends JPanel {

	private JTextField jtfIdEstudiante;
	private JTextField jtfIdMateria;
	private JTextField jtfIdProfesor;
	private JTextField jtfId;
	private JTextField jtfValoracion;
	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;

	public PanelGestionValoracionMateria() {

		GridBagLayout gridBagLayout = new GridBagLayout();
//				gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
//				gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//				gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//				gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//				gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//				gridBagLayout.columnWidths = new int[]{0};
//				gridBagLayout.rowHeights = new int[]{0};
//				gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//				gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestión de Valoracion Materia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_8 = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 1;
		add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("IdProfesor");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfIdProfesor = new JTextField();
		GridBagConstraints gbc_jtfIdProfesor = new GridBagConstraints();
		gbc_jtfIdProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jtfIdProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdProfesor.gridx = 1;
		gbc_jtfIdProfesor.gridy = 2;
		add(jtfIdProfesor, gbc_jtfIdProfesor);
		jtfIdProfesor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("IdEstudiante");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfIdEstudiante = new JTextField();
		GridBagConstraints gbc_jtfIdEstudiante = new GridBagConstraints();
		gbc_jtfIdEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_jtfIdEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdEstudiante.gridx = 1;
		gbc_jtfIdEstudiante.gridy = 3;
		add(jtfIdEstudiante, gbc_jtfIdEstudiante);
		jtfIdEstudiante.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("IdMateria");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfIdMateria = new JTextField();
		GridBagConstraints gbc_jtfIdMateria = new GridBagConstraints();
		gbc_jtfIdMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jtfIdMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdMateria.gridx = 1;
		gbc_jtfIdMateria.gridy = 4;
		add(jtfIdMateria, gbc_jtfIdMateria);
		jtfIdMateria.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Valoracion");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfValoracion = new JTextField();
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 1;
		gbc_jtfValoracion.gridy = 5;
		add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
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
				cargarEnPantalla(ControladorValoracionMateria.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorValoracionMateria.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorValoracionMateria.findLast());
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
			if (ControladorValoracionMateria.eliminar(actualId) != 1) {
				JOptionPane.showMessageDialog(null, "Algo ha salido mal");
			} else {
				// Cargo otro registro en pantalla
				ValoracionMateria mAnterior = ControladorValoracionMateria.findPrevious(actualId);
				if (mAnterior != null) {
					cargarEnPantalla(mAnterior);
				} else {
					ValoracionMateria mSiguiente = ControladorValoracionMateria.findNext(actualId);
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
		this.jtfIdProfesor.setText("");
		this.jtfIdEstudiante.setText("");
		this.jtfIdMateria.setText("");
		this.jtfValoracion.setText("");

	}

	/**
	 * 
	 */
	private void guardar() {
		ValoracionMateria m = new ValoracionMateria();
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setIdProfesor(Integer.parseInt(this.jtfIdProfesor.getText()));
		m.setIdEstudiante(Integer.parseInt(this.jtfIdEstudiante.getText()));
		m.setIdMateria(Integer.parseInt(this.jtfIdMateria.getText()));
		m.setValoracion(Integer.parseInt(this.jtfValoracion.getText()));

		String strError = "No se ha podido guardar";
		if (m.getId() == 0) {
			int nuevoIdInsertado = ControladorValoracionMateria.insertar(m);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			} else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		} else {
			if (ControladorValoracionMateria.modificar(m) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}

	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorValoracionMateria.findFirst());
	}

	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla(ValoracionMateria m) {
		if (m != null) {
			this.jtfId.setText("" + m.getId());
			this.jtfIdProfesor.setText("" + m.getIdProfesor());
			this.jtfIdEstudiante.setText("" + m.getIdEstudiante());
			this.jtfIdMateria.setText("" + m.getIdMateria());
			this.jtfValoracion.setText("" + m.getValoracion());
		}

		// Habilito y deshabilito botones de navegación
		if (ControladorValoracionMateria.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		} else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorValoracionMateria.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		} else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}

	}

}
