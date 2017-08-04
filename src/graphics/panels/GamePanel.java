package graphics.panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import graphics.GameBorder;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1244543786097347429L;
	private TetrisGraphics tetrisGraphics; 
	
	public GamePanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		defineGamePanel();
	}

	private void defineGamePanel() {
		this.setBounds(0, 50, 450, 890);
		this.setBackground(new Color(100, 100, 100));
		this.setBorder(new GameBorder());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGrid(g);
	}

	private void drawGrid(Graphics g) {
		/*
		 * Border is 60 width and 60 height total. Need 10 cells wide, 22 cells
		 * high. Need square size that is the same height and width. 600 / 15
		 * (cols) = 40, 900 / 40 = (approx) 22.5 rows.
		 */
		int sqSize = 38;
		for (int cols = 0; cols < 32; cols++) {
			for (int rows = 0; rows < 45; rows++) {
				g.drawLine(sqSize * cols, sqSize * rows, sqSize * cols, 900);
				g.drawLine(sqSize * cols, sqSize * rows, 600, sqSize * rows);
			}
		}

	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

}
