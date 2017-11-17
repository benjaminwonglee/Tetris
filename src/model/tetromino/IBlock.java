package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;

public class IBlock extends Tetromino implements DrawInterface {

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
		Arrays.fill(matrix, true);
		return matrix;
	}
}
