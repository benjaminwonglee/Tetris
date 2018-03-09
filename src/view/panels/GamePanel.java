package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1244543786097347429L;
	private TetrisGraphics tetrisGraphics;

	public GamePanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		JPanel grid = new GridPanel();
		add(grid);
	}

	// TODO: Draw the pieces in either the GridPanel or here. Decide.

	// TODO: Figure out better names and what this code does
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
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(450, 891);
	}

}
