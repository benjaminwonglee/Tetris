package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class OBlock extends Tetromino {

	@Override
	public void draw(Graphics g) {

		Polygon p = new Polygon();
		g.drawPolygon(p);
	}

	@Override
	public Color getColor() {
		return Color.YELLOW;
	}

	@Override
	public boolean[][] getTetrominoMatrix(int orientation) {

		boolean[][] matrix = null;
		matrix = new boolean[2][2];
		matrix[0][0] = true;
		matrix[0][1] = true;
		matrix[1][0] = true;
		matrix[1][1] = true;
		return matrix;
	}

}
