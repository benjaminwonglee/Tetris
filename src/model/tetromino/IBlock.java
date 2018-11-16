package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class IBlock extends Tetromino {

	@Override
	public void draw(Graphics g, int pixPerBlock, int startX, int startY) {

		Polygon p = new Polygon();
		boolean[][] tetrominoMatrix = getTetrominoMatrix(getOrientation());

		p.addPoint(startX, startY);
		p.addPoint(startX + (pixPerBlock * tetrominoMatrix.length), startY);
		p.addPoint(startX + (pixPerBlock * tetrominoMatrix.length), startY + (pixPerBlock * tetrominoMatrix[0].length));
		p.addPoint(startX, startY + (pixPerBlock * tetrominoMatrix[0].length));

		Color current = getColor();
		g.setColor(current);
		g.fillPolygon(p);
		g.setColor(getOutlineColor());
		g.drawPolygon(p);
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public boolean[][] getTetrominoMatrix(int orientation) {

		boolean[][] matrix = null;
		if (orientation == 0 || orientation == 180) {
			matrix = new boolean[4][1];
		} else {
			matrix = new boolean[1][4];
		}

		for (int col = 0; col < matrix.length; col++) {
			for (int row = 0; row < matrix[0].length; row++) {

				matrix[col][row] = true;
			}
		}
		return matrix;
	}

	// @Override
	// public boolean contains(int x, int y) {
	// if (x >= (getX() / 2) && x <= ((getX() / 2) + 4)) {
	//
	// }
	// return false;
	// }
}
