package model.tetris;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Timer;

import common.Action;
import common.PrintUtils;
import model.tetromino.Tetromino;
import model.tetromino.TetrominoGenerator;

public class Tetris extends Observable {

	private Color[][] grid;
	private int width = 10;
	private int height = 22;
	private int difficulty;

	// Tetromino fields
	private TetrominoGenerator generator = new TetrominoGenerator();
	private Tetromino current;
	private Tetromino nextTetromino;
	private Tetromino heldTetromino;
	private Point[] oldPosition;
	private int tetrominoCount = 0;

	public Tetris(int difficulty) {

		grid = new Color[width][height];
		this.difficulty = difficulty;
		current = getRandomTetromino();
		nextTetromino = getRandomTetromino();
		createTetromino();
		run();
	}

	private void run() {

		Timer t = new Timer();
		TetrisTask tt = new TetrisTask(this);
		t.scheduleAtFixedRate(tt, 1000, 1000 / difficulty);
	}

	// private void runAlt() {
	//
	// // Will this work with KeyListener? If not, use java.util.timer.
	// while (rowEmpty(grid, 0)) {
	// tick();
	// int waitTime = 1000 / difficulty;
	// if (waitTime <= 0) {
	// waitTime = 1;
	// }
	// try {
	// TimeUnit.MILLISECONDS.sleep(waitTime);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// private void tick() {
	//
	// }
	//
	// private boolean rowEmpty(Color[][] grid, int row) {
	// return true;
	// }

	private void createTetromino() {

		// Set original coordinates for tetromino
		current.setX(grid.length / 2);
		current.setY(0);

		// Add all points for the old position
		defineOldPosition();

		updateGrid();
		System.out.println(PrintUtils.getTextGrid(grid));
	}

	private void defineOldPosition() {

		oldPosition = new Point[4];
		boolean[][] tetromino = current.getTetrominoMatrix(current.getOrientation());
		int count = 0;
		for (int x = 0; x < tetromino.length; x++) {
			for (int y = 0; y < tetromino[0].length; y++) {
				if (tetromino[x][y]) {
					oldPosition[count] = new Point((current.getX() - tetromino.length / 2) + x, current.getY() + y);
					count++;
				}
			}
		}
	}

	public Tetromino getRandomTetromino() {

		List<Tetromino> tetrominoes = generator.getTetrominoes();
		// Restart using the same tetromino set
		if (tetrominoCount > tetrominoes.size()) {
			tetrominoCount = 0;
		}
		return tetrominoes.get(tetrominoCount++);
	}

	public void holdTetromino() {

		Tetromino tempTetromino = nextTetromino;
		nextTetromino = getRandomTetromino();
		heldTetromino = tempTetromino;
	}

	public void setTetrominoAction(Action action) {

		boolean success = true;

		switch (action) {
		case ROTATE_LEFT:
			// TODO: Correct the range checks here
			if (rangeCheckX(1)) {
				current.rotateLeft();
			} else {
				success = false;
			}
			break;
		case ROTATE_RIGHT:
			// TODO: Correct the range checks here
			if (rangeCheckX(1)) {
				current.rotateRight();
			} else {
				success = false;
			}
			break;
		case MOVE_LEFT:
			if (rangeCheckX(-1)) {
				current.moveLeft();
			} else {
				success = false;
			}
			break;
		case MOVE_RIGHT:
			if (rangeCheckX(1)) {
				current.moveRight();
			} else {
				success = false;
			}
			break;
		case SOFT_DROP:
			current.softDrop();
			break;
		case HARD_DROP:
			current.hardDrop();
			break;
		default:
			break;
		}
		if (success) {
			updateGrid();
		}
		System.out.println(PrintUtils.getTextGrid(grid));
	}

	private boolean rangeCheckX(int changeX) {

		int result = current.getX() + changeX;
		boolean[][] tetrominoMatrix = current.getTetrominoMatrix(current.getOrientation());
		if (changeX > 0) {
			result += tetrominoMatrix.length / 2 + tetrominoMatrix.length % 2;
		} else if (changeX < 0) {
			result -= tetrominoMatrix.length / 2;
		}

		if (result < 0 || result > grid.length) {
			return false;
		}
		return true;
	}

	private void updateGrid() {

		// Clear the tiles in the old position
		for (Point p : oldPosition) {
			grid[p.x][p.y] = null;
		}
		// Update old position to be current
		defineOldPosition();

		// Update tetromino in new position
		boolean[][] tetromino = current.getTetrominoMatrix(current.getOrientation());
		for (int i = 0; i < tetromino.length; i++) {
			for (int j = 0; j < tetromino[0].length; j++) {
				if (tetromino[i][j]) {
					int actualX = current.getX() - (tetromino.length / 2) + i;
					int actualY = current.getY() + j;
					grid[actualX][actualY] = current.getColor();
				}
			}
		}
		setChanged();
		notifyObservers();
	}

	public TetrominoGenerator getGenerator() {
		return generator;
	}

	public Color[][] getGrid() {
		return grid;
	}

	public void setGrid(Color[][] grid) {
		this.grid = grid;
	}

	public Tetromino getCurrent() {
		return current;
	}

	public Tetromino getNextTetromino() {
		return nextTetromino;
	}

	public Tetromino getHeldTetromino() {
		return heldTetromino;
	}
}
