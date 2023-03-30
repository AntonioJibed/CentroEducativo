package centroEducativo.view;

import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import centroEducativo.controller.ControladorCurso;
import centroEducativo.controller.ControladorEstudiante;
import centroEducativo.controller.ControladorMateria;
import centroEducativo.model.Curso;
import centroEducativo.model.Estudiante;
import centroEducativo.model.Materia;

public class PanelGestionEstudiante extends JPanel {
	

	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
	PanelDatosPersonales datosPersonales;
	private byte[] contenidoImagen;



	/**
	 * Create the panel.
	 */
	public PanelGestionEstudiante() {
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
				cargarEnPantalla(ControladorEstudiante.findPrevious(
						Integer.parseInt(datosPersonales.getId())));
			}
		});  
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorEstudiante.findNext(
						Integer.parseInt(datosPersonales.getId())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEnPantalla(ControladorEstudiante.findLast());
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
	    	int actualId = Integer.parseInt(datosPersonales.getId());
		    if (ControladorEstudiante.eliminar(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	Estudiante mAnterior = ControladorEstudiante.findPrevious(actualId);
		    	if (mAnterior != null) {
		    		cargarEnPantalla(mAnterior);
		    	}
		    	else {
		    		Estudiante mSiguiente = ControladorEstudiante.findNext(actualId);
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
		datosPersonales.setId(Integer.parseInt("0"));
		datosPersonales.setNombre("");
		datosPersonales.setApellido1("");
		datosPersonales.setApellido2("");
		datosPersonales.setDni("");
		datosPersonales.setDireccion("");
		datosPersonales.setEmail("");
		datosPersonales.setTelefono("");
		datosPersonales.setSexo(Integer.parseInt(""));
		
	}
	
	/**
	 * 
	 */
	private void guardar() {
		Estudiante e = new Estudiante();
		
		e.setId(Integer.parseInt(datosPersonales.getId()));
		e.setNombre(datosPersonales.getNombre());
		e.setApellido1(datosPersonales.getApellido1());
		e.setApellido2(datosPersonales.getApellido2());
		e.setDni(datosPersonales.getDni());
		e.setDireccion(datosPersonales.getDireccion());
		e.setEmail(datosPersonales.getEmail());
		e.setTelefono(datosPersonales.getTelefono());
		e.setIdTipologiaSexo(Integer.parseInt(datosPersonales.getSexo()));
		


		
		
		String strError = "No se ha podido guardar";
		if (e.getId() == 0) {
			int nuevoIdInsertado = ControladorEstudiante.insertar(e);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				datosPersonales.setId(nuevoIdInsertado);
			}
		}
		else {
			if (ControladorEstudiante.modificar(e) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}
		
	}
	
	
	/**
	 * 
	 */
	private void cargarPrimero() {
		cargarEnPantalla(ControladorEstudiante.findFirst());
	}
	
	
	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (Estudiante e) {
		if (e != null) {
			datosPersonales.setId(e.getId());
			datosPersonales.setNombre(e.getNombre());
			datosPersonales.setApellido1(e.getApellido1());
			datosPersonales.setApellido2(e.getApellido2());
			datosPersonales.setSexo(e.getIdTipologiaSexo());
			datosPersonales.setDni(e.getDni());
			datosPersonales.setDireccion(e.getDireccion());
			datosPersonales.setEmail(e.getEmail());
			datosPersonales.setTelefono(e.getTelefono());
			datosPersonales.setColor(e.getColorPreferido());
		}
	
		
		// Habilito y deshabilito botones de navegación
		if (ControladorEstudiante.findPrevious(Integer.parseInt(datosPersonales.getId())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		}
		else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ControladorEstudiante.findNext(Integer.parseInt(datosPersonales.getId())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		}
		else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}
	
	}

}