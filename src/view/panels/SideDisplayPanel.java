package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SideDisplayPanel extends JPanel {
	private static final long serialVersionUID = 4667216275241133396L;
	private TetrisGraphics tetrisGraphics;

	public SideDisplayPanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		defineDisplayPanel();
	}

	/**
	 * Height is defined as 22 squares x 40 pixels = 880 + (5*2) + 1
	 */
	private void defineDisplayPanel() {
		this.setPreferredSize(new Dimension(380, 891));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		int cols = 20;
		int width = this.getPreferredSize().width / cols;
		for (int column = 0; column < cols; column++) {

			// Darker Grey
			int colorFactor = 40 + column;
			g.setColor(new Color(colorFactor * 2, colorFactor * 2, colorFactor * 2));
			g.fillRect(column * width, 0, width, this.getPreferredSize().height);

		}

		width = 50;
		int height = 50;
		int widthMod = 60;
		int heightMod = 30;
		for (int y = -height; y < this.getPreferredSize().height; y += heightMod) {
			int shade = 120;
			for (int x = -width; x < this.getPreferredSize().width; x += widthMod) {
				g.setColor(new Color(shade, shade, shade));
				g.fillPolygon(ShapePolygon.fiveStar(x += width, y += height, width, height));
				shade += 10;
			}
		}

	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

}
