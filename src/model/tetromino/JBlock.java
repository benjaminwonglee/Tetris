package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;

public class JBlock extends Tetromino implements DrawInterface {

	@Override
	public void draw(Graphics g) {
		Polygon p = new Polygon();
		g.drawPolygon(p);
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}

	@Override
	public boolean[][] getTetrominoMatrix() {
		boolean[][] matrix = null;
		if (getOrientation() == 0) {
			matrix = new boolean[3][2];
			matrix[0][0] = true;
			matrix[0][1] = true;
			matrix[1][1] = true;
			matrix[2][1] = true;
			// T . .
			// T T T
		} else if (getOrientation() == 90) {
			matrix = new boolean[2][3];
			matrix[0][0] = true;
			matrix[1][0] = true;
			matrix[0][1] = true;
			matrix[0][2] = true;
			// T T
			// T .
			// T .
		} else if (getOrientation() == 180) {
			matrix = new boolean[3][2];
			matrix[0][0] = true;
			matrix[1][0] = true;
			matrix[2][0] = true;
			matrix[2][1] = true;
			// T T T
			// . . T
		} else if (getOrientation() == 270) {
			matrix = new boolean[2][3];
			matrix[1][0] = true;
			matrix[1][1] = true;
			matrix[0][2] = true;
			matrix[1][2] = true;
			// . T
			// . T
			// T T
		}
		return matrix;
	}
}