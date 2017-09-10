package graphics.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import graphics.GameBorder;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1244543786097347429L;
	private TetrisGraphics tetrisGraphics;

	public GamePanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		JPanel grid = new GridPanel();
		add(grid);
		defineGamePanel();
	}

	private void defineGamePanel() {
		this.setBackground(new Color(0, 0, 0));
		this.setBorder(new GameBorder());
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(450, 900);
	}
}
