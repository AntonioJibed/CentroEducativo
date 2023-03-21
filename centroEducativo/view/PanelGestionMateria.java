package centroEducativo.view;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import centroEducativo.controller.ControladorCurso;
import centroEducativo.controller.ControladorMateria;
import centroEducativo.model.Curso;
import centroEducativo.model.Materia;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelGestionMateria extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfAcronimo;
	JComboBox<Curso> jcbCurso;
	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;

	/**
	 * Create the panel.
	 */
	public PanelGestionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestión de materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Acrónimo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfAcronimo = new JTextField();
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 1;
		gbc_jtfAcronimo.gridy = 3;
		add(jtfAcronimo, gbc_jtfAcronimo);
		jtfAcronimo.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Curso:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcbCurso = new JComboBox<Curso>();
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 1;
		gbc_jcbCurso.gridy = 4;
		add(jcbCurso, gbc_jcbCurso);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

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
				cargarEnPantalla(ControladorMateria.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorMateria.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorMateria.findLast());
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

		cargarCursosEnJCombo();
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
			if (ControladorMateria.eliminar(actualId) != 1) {
				JOptionPane.showMessageDialog(null, "Algo ha salido mal");
			} else {
				// Cargo otro registro en pantalla
				Materia mAnterior = ControladorMateria.findPrevious(actualId);
				if (mAnterior != null) {
					cargarEnPantalla(mAnterior);
				} else {
					Materia mSiguiente = ControladorMateria.findNext(actualId);
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
		this.jtfAcronimo.setText("");
		if (this.jcbCurso.getItemCount() > 0) {
			this.jcbCurso.setSelectedIndex(0);
		}
	}

	/**
	 * 
	 */
	private void guardar() {
		Materia m = new Materia();
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setNombre(this.jtfNombre.getText());
		m.setAcronimo(this.jtfAcronimo.getText());

		Curso c = (Curso) this.jcbCurso.getSelectedItem();
		m.setIdCurso(c.getId());

		String strError = "No se ha podido guardar";
		if (m.getId() == 0) {
			int nuevoIdInsertado = ControladorMateria.insertar(m);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			} else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		} else {
			if (ControladorMateria.modificar(m) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}

	}

	/**
	 * 
	 */
	private void cargarCursosEnJCombo() {
		List<Curso> cursos = ControladorCurso.findAll();
		for (Curso curso : cursos) {
			this.jcbCurso.addItem(curso);
		}
	}

	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorMateria.findFirst());
	}

	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla(Materia m) {
		if (m != null) {
			this.jtfId.setText("" + m.getId());
			this.jtfNombre.setText(m.getNombre());
			this.jtfAcronimo.setText(m.getAcronimo());

			for (int i = 0; i < this.jcbCurso.getItemCount(); i++) {
				Curso c = this.jcbCurso.getItemAt(i);
				if (m.getIdCurso() == c.getId()) {
					this.jcbCurso.setSelectedIndex(i);
				}
			}
		}

		// Habilito y deshabilito botones de navegación
		if (ControladorMateria.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		} else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorMateria.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		} else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}

	}

}
