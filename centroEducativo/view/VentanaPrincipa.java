package centroEducativo.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import centroEducativo.view.PanelGestionCurso;
import centroEducativo.view.PanelGestionMateria;

public class VentanaPrincipa extends JFrame {

	public VentanaPrincipa() {
this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("Cursos", new PanelGestionCurso());
		tabedPane.add("Materia", new PanelGestionMateria());
		this.setMinimumSize(new Dimension(800, 600));

		
		this.setContentPane(tabedPane);
	}
		
	
	public static void main(String args[]) {
		VentanaPrincipa v = new VentanaPrincipa();
		v.setVisible(true);

	}
}
