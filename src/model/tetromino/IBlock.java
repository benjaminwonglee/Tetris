package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;

public class IBlock extends Tetromino {

	@Override
	public void draw(Graphics g) {
		Polygon p = new Polygon();
		g.drawPolygon(p);
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public boolean[][] getTetrominoMatrix() {
		boolean[][] matrix = null;
		if (getOrientation() == 0 || getOrientation() == 180) {
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
}
