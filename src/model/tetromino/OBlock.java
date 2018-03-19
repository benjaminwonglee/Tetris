package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class OBlock extends Tetromino {

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
