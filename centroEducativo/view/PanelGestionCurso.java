package centroEducativo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import centroEducativo.controller.ControladorCurso;
import centroEducativo.controller.ControladorMateria;
import centroEducativo.model.Curso;
import centroEducativo.model.Materia;


public class PanelGestionCurso extends JPanel{
	private JTextField jtfId;
	private JPanel panel;
	private JTextField jtfDescripcion;
	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;

	/**
	 * Create the panel.
	 */
	public PanelGestionCurso() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Gestión de Curso");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(15, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		
		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		this.add(lblNewLabel_2, gbc_lblNewLabel_3);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 3;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
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
				cargarEnPantalla(ControladorMateria.findPrevious(
						Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorMateria.findNext(
						Integer.parseInt(jtfId.getText())));
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

		cargarPrimero();
	}

	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", 
				"Eliminación", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	int actualId = Integer.parseInt(this.jtfId.getText());
		    if (ControladorMateria.eliminar(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	Materia mAnterior = ControladorMateria.findPrevious(actualId);
		    	if (mAnterior != null) {
		    		cargarEnPantalla(mAnterior);
		    	}
		    	else {
		    		Materia mSiguiente = ControladorMateria.findNext(actualId);
		    		if (mSiguiente != null) {
		    			cargarEnPantalla(mSiguiente);
		    		}
		    		else { // No quedan registros, has eliminado el único
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
		this.jtfDescripcion.setText("");
	}
	
	/**
	 * 
	 */
	private void guardar() {
		Materia m = new Materia();
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setNombre(this.jtfDescripcion.getText());
		
		String strError = "No se ha podido guardar";
		if (m.getId() == 0) {
			int nuevoIdInsertado = ControladorMateria.insertar(m);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		}
		else {
			if (ControladorMateria.modificar(m) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
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
	private void cargarEnPantalla (Materia m) {
		if (m != null) {
			this.jtfId.setText("" + m.getId());
			this.jtfDescripcion.setText(m.getNombre());

		}
		
		// Habilito y deshabilito botones de navegación
		if (ControladorMateria.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		}
		else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorMateria.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		}
		else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}
	
	}

}
