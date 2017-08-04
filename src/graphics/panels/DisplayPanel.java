package graphics.panels;

import java.awt.Color;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	private static final long serialVersionUID = 4667216275241133396L;
	private TetrisGraphics tetrisGraphics;
	
	public DisplayPanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		defineDisplayPanel();
	}

	private void defineDisplayPanel() {
		this.setBackground(new Color(75, 180, 150));
		this.setBounds(450, 50, 350, 890);
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}
}
