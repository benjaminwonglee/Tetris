package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = -4857330386621368616L;
	private GamePanel parent;
	private int sqSize = 40;

	public GridPanel(GamePanel gamePanel) {
		this.parent = gamePanel;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(new Color(150, 150, 150));
		this.setBackground(new Color(0, 0, 0));
		drawPieces(g);
		drawGrid(g);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(401, 881);
	}

	/**
	 * Need to draw a grid 10 cells wide, 22 cells high. Need square size that is
	 * the same height and width.
	 */
	private void drawGrid(Graphics g) {

		g.setColor(new Color(150, 150, 150));
		for (int col = 0; col < 10; col++) {
			for (int row = 0; row < 22; row++) {
				g.drawRect(sqSize * col, sqSize * row, sqSize, sqSize);
			}
		}

	}

	private void drawPieces(Graphics g) {

		Color[][] grid = parent.getModel().getGrid();
		for (int col = 0; col < grid.length; col++) {
			for (int row = 0; row < grid[0].length; row++) {
				if (grid[col][row] != null) {
					g.setColor(grid[col][row]);
					g.fillRect(sqSize * col, sqSize * row, sqSize, sqSize);
				}
			}
		}

	}

}
