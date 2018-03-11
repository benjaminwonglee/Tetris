package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.tetris.Tetris;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1244543786097347429L;
	private TetrisGraphics tetrisGraphics;
	private GridPanel grid;

	public GamePanel(TetrisGraphics tetrisGraphics) {

		this.tetrisGraphics = tetrisGraphics;
		grid = new GridPanel(this);
		add(grid);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		// Create a red border
		for (int i = 1; i < 8; i++) {
			g.setColor(new Color(50 + (20 * i), 10, 10));
			int wd = (i - 1) * 4;
			int ht = i - 1;
			g.fillRect(wd, ht, getPreferredSize().width - (wd * 2), getPreferredSize().height - (ht * 2));
		}
		grid.repaint();
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(450, 891);
	}

	public Tetris getModel() {
		return tetrisGraphics.getModel();
	}

}
