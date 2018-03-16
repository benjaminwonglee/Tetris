package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class LBlock extends Tetromino {

	@Override
	public void draw(Graphics g) {

		Polygon p = new Polygon();
		g.drawPolygon(p);
	}

	@Override
	public Color getColor() {
		return Color.PINK;
	}

	@Override
	public boolean[][] getTetrominoMatrix(int orientation) {

		boolean[][] matrix = null;
		if (orientation == 0) {
			matrix = new boolean[3][3];
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[2][1] = true;
			matrix[0][2] = true;
			// . . .
			// T T T
			// T . .
		} else if (orientation == 90) {
			matrix = new boolean[3][3];
			matrix[0][0] = true;
			matrix[1][0] = true;
			matrix[1][1] = true;
			matrix[1][2] = true;
			// T T .
			// . T .
			// . T .
		} else if (orientation == 180) {
			matrix = new boolean[3][3];
			matrix[2][0] = true;
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[2][1] = true;
			// . . T
			// T T T
			// . . .

		} else if (orientation == 270) {
			matrix = new boolean[3][3];
			matrix[1][0] = true;
			matrix[1][1] = true;
			matrix[1][2] = true;
			matrix[2][2] = true;
			// . T .
			// . T .
			// . T T
		}
		return matrix;
	}

}
