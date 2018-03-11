package model.tetris;

import java.awt.Color;
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
		t.scheduleAtFixedRate(tt, 0, 1000 / difficulty);
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

		boolean[][] tetromino = current.getTetrominoMatrix();

		// Set original coordinates for tetromino
		current.setX((grid.length / 2) - (tetromino.length / 2) - (tetromino.length % 2));
		current.setY(0);

		updateGrid();
		System.out.println(PrintUtils.getTextGrid(grid));
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

		switch (action) {
		case ROTATE_LEFT:
			current.rotateLeft();
			break;
		case ROTATE_RIGHT:
			current.rotateRight();
			break;
		case MOVE_LEFT:
			current.moveLeft();
			break;
		case MOVE_RIGHT:
			current.moveRight();
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
		updateGrid();
		System.out.println(PrintUtils.getTextGrid(grid));
	}

	private void updateGrid() {

		boolean[][] tetromino = current.getTetrominoMatrix();

		for (int i = 0; i < tetromino.length; i++) {
			for (int j = 0; j < tetromino[0].length; j++) {
				if (tetromino[i][j]) {
					grid[current.getX() + i][current.getY() + j] = current.getColor();
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
