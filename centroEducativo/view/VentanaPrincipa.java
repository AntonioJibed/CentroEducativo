package centroEducativo.view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import tutorialJava.capitulo9_AWT_SWING.utils.Apariencia;


public class VentanaPrincipa extends JFrame {



	public VentanaPrincipa() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabedPane = new JTabbedPane();

		tabedPane.add("Cursos", new PanelGestionCurso());
		tabedPane.add("Materia", new PanelGestionMateria());
		tabedPane.add("Estudiante", new PanelGestionEstudiante());
//		tabedPane.add("Profesor", new PanelGestionProfesor());
		tabedPane.add("ValoracionMateria", new PanelGestionValoracionMateria());

		this.setMinimumSize(new Dimension(800, 600));

		this.setContentPane(tabedPane);
	}

	public static void main(String args[]) {
		VentanaPrincipa v = new VentanaPrincipa();
		v.setVisible(true);

	}
}
