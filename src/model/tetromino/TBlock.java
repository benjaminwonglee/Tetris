package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class TBlock extends Tetromino {

	@Override
	public void draw(Graphics g) {

		Polygon p = new Polygon();
		g.drawPolygon(p);
	}

	@Override
	public Color getColor() {
		return new Color(120, 0, 120);
	}

	@Override
	public boolean[][] getTetrominoMatrix(int orientation) {

		boolean[][] matrix = null;
		if (orientation == 0) {
			matrix = new boolean[3][3];
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[2][1] = true;
			matrix[1][2] = true;
			// . . .
			// T T T
			// . T .
		} else if (orientation == 90) {
			matrix = new boolean[3][3];
			matrix[1][0] = true;
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[1][2] = true;
			// . T .
			// T T .
			// . T .
		} else if (orientation == 180) {
			matrix = new boolean[3][3];
			matrix[1][0] = true;
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[2][1] = true;
			// . T .
			// T T T
			// . . .
		} else if (orientation == 270) {
			matrix = new boolean[3][3];
			matrix[1][0] = true;
			matrix[1][1] = true;
			matrix[1][2] = true;
			matrix[2][1] = true;
			// . T .
			// . T T
			// . T .
		}
		return matrix;
	}
}
