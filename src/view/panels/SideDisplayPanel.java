package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.tetromino.Tetromino;

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
		paintBackground(g);
		paintNextQueue(g);

	}

	private void paintBackground(Graphics g) {

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

	private void paintNextQueue(Graphics g) {

		Tetromino[] nextQueue = tetrisGraphics.getFrame().getModel().getNextQueue();
		int xPos = this.getPreferredSize().width / 2;
		int yPos = 50;
		int pixelsPerBlock = 50;
		for (Tetromino t : nextQueue) {
			int xLength = t.getTetrominoMatrix(t.getOrientation()).length;
			xPos -= (pixelsPerBlock * (xLength / 2));
			if (xLength % 2 == 1) {
				xPos -= pixelsPerBlock / 2;
			}
			t.draw(g, pixelsPerBlock, xPos, yPos);
			yPos += pixelsPerBlock * 3;
			xPos = this.getPreferredSize().width / 2;
		}
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

}
