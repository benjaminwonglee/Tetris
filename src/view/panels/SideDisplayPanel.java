package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.tetromino.Tetromino;

public class SideDisplayPanel extends JPanel {

	private static final long serialVersionUID = 4667216275241133396L;
	private TetrisGraphics tetrisGraphics;
	private static final int PIXELS_PER_BLOCK = 35;

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

		drawCenteredTitle("Next Queue", xPos, yPos, g);
		yPos += 40;

		for (Tetromino t : nextQueue) {
			drawTetromino(t, xPos, yPos, PIXELS_PER_BLOCK, g);
			yPos += PIXELS_PER_BLOCK * 3;
		}

		paintHoldQueue(g, yPos);
	}

	private void paintHoldQueue(Graphics g, int yPos) {

		int xPos = this.getPreferredSize().width / 2;
		yPos += 60;

		drawCenteredTitle("Holding", xPos, yPos, g);
		yPos += 40;

		Tetromino heldPiece = tetrisGraphics.getFrame().getModel().getHeldTetromino();
		if (heldPiece != null) {
			drawTetromino(heldPiece, xPos, yPos, PIXELS_PER_BLOCK, g);
		}
	}

	private void drawTetromino(Tetromino t, int xPos, int yPos, int pixelsPerBlock, Graphics g) {

		int xLength = t.getTetrominoMatrix(t.getOrientation()).length;
		xPos -= (pixelsPerBlock * (xLength / 2));
		if (xLength % 2 == 1) {
			xPos -= pixelsPerBlock / 2;
		}
		t.draw(g, pixelsPerBlock, xPos, yPos);
	}

	/**
	 * Draw a title at the center of a panel
	 * 
	 * @param title
	 * @param g
	 */
	public static void drawCenteredTitle(String title, int xPos, int yPos, Graphics g) {

		g.setColor(Color.WHITE);
		g.setFont(new Font("Times", Font.BOLD, 26));
		g.drawString(title, xPos - (g.getFontMetrics().stringWidth(title) / 2), yPos);
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

}
