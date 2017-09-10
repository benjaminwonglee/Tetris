package graphics.panels;

import java.awt.Color;
import java.awt.Dimension;
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

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(401, 881);
	}

	private void drawGrid(Graphics g) {
		/*
		 * Need 10 cells wide, 22 cells high. Need square size that is the same
		 * height and width.
		 */
		int sqSize = 40;
		for (int cols = 0; cols < 10; cols++) {
			for (int rows = 0; rows < 22; rows++) {
				g.drawRect(sqSize * cols, sqSize * rows, sqSize, sqSize);
			}
		}

	}

}
