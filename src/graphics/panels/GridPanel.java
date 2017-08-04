package graphics.panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel {
	private static final long serialVersionUID = -4857330386621368616L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(150, 150, 150));
		this.setBackground(new Color(0, 0, 0));
		drawGrid(g);
	}

	private void drawGrid(Graphics g) {
		/*
		 * Border is 60 width and 60 height total. Need 10 cells wide, 22 cells
		 * high. Need square size that is the same height and width. 600 / 15
		 * (cols) = 40, 900 / 40 = (approx) 22.5 rows.
		 */
		int sqSize = 39;
		for (int cols = 0; cols < 32; cols++) {
			for (int rows = 0; rows < 45; rows++) {
				g.drawLine(sqSize * cols, sqSize * rows, sqSize * cols, 900);
				g.drawLine(sqSize * cols, sqSize * rows, 600, sqSize * rows);
			}
		}

	}

}
