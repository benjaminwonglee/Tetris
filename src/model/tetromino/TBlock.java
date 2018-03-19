package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class TBlock extends Tetromino {

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
		return new Color(180, 0, 180);
	}

	@Override
	public boolean[][] getTetrominoMatrix(int orientation) {

		boolean[][] matrix = null;
		if (orientation == 0) {
			matrix = new boolean[3][2];
			matrix[0][0] = true;
			matrix[1][0] = true;
			matrix[2][0] = true;
			matrix[1][1] = true;
			// T T T
			// . T .
		} else if (orientation == 90) {
			matrix = new boolean[2][3];
			matrix[1][0] = true;
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[1][2] = true;
			// . T
			// T T
			// . T
		} else if (orientation == 180) {
			matrix = new boolean[3][2];
			matrix[1][0] = true;
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[2][1] = true;
			// . T .
			// T T T
		} else if (orientation == 270) {
			matrix = new boolean[2][3];
			matrix[0][0] = true;
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[0][2] = true;
			// T .
			// T T
			// T .
		}
		return matrix;
	}
}
