package model.tetromino;

public abstract class Tetromino implements DrawInterface {

	private int x;
	private int y;
	private int orientation = 0;

	public void softDrop() {
		adjustY(1);
	}

	public void hardDrop() {

		// Figure out a way to find contact with lowest block underneath

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
		adjustX(-1);
	}

	public void moveRight() {
		adjustX(1);
	}

	private void adjustX(int offset) {
		x += offset;
	}

	private void adjustY(int offset) {
		y += offset;
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

	public abstract boolean[][] getTetrominoMatrix(int orientation);

}
