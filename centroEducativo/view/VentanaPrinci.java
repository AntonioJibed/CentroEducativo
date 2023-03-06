package centroEducativo.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrinci extends JFrame {

	public VentanaPrinci() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabedPane = new JTabbedPane();
		JPanel pnl1 = new JPanel();
		pnl1.setBackground(Color.blue);
		tabedPane.add("Cursos", pnl1);

		JPanel pnl2 = new JPanel();
		pnl2.setBackground(Color.RED);

		tabedPane.add("Materia", pnl2);

		JPanel pnl3 = new JPanel();
		pnl3.setBackground(Color.RED);

		tabedPane.add("Estudiante", pnl3);
		
		JPanel pnl4 = new JPanel();
		pnl4.setBackground(Color.RED);

		tabedPane.add("Profesor", pnl4);
		
		JPanel pnl5 = new JPanel();
		pnl5.setBackground(Color.RED);

		tabedPane.add("ValoracionMateria", pnl5);

		this.setContentPane(tabedPane);

//		this.setContentPane(getPanelPrincipal());

	}

	public static void main(String args[]) {
		VentanaPrinci v = new VentanaPrinci();
		v.setVisible(true);
	}

}
