package model.tetromino;

import java.awt.Color;

public abstract class Tetromino implements DrawInterface{
	private int x;
	private int y;
	private int orientation = 0;
	private int offsetH = 0;
	private int offsetV = 0;


	public void softDrop() {
		//Figure out a way to find contact with lowest block underneath
		offsetV += 2;
	}

	public void hardDrop() {
		//Figure out a way to find contact with lowest block underneath

	}

	public void rotateLeft() {
		if (orientation == 0) {
			orientation = 270;
			return;
		}
		orientation -= 90;
	}

	public void rotateRight() {
		if (orientation == 270) {
			orientation = 0;
			return;
		}
		orientation += 90;

	}

	public void moveLeft() {
		offsetH -= 1;
	}

	public void moveRight() {
		offsetH += 1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getOrientation() {
		return orientation;
	}

	public int getOffsetH() {
		return offsetH;
	}

	public void setOffsetH(int offsetH) {
		this.offsetH = offsetH;
	}

	public int getOffsetV() {
		return offsetV;
	}

	public void setOffsetV(int offsetV) {
		this.offsetV = offsetV;
	}

	public abstract boolean[][] getTetrominoMatrix();

}
