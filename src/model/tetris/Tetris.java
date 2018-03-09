package model.tetris;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import common.Action;
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
	private Point pivot;

	public Tetris(int difficulty) {

		grid = new Color[width][height];
		this.difficulty = difficulty;
		current = getRandomTetromino();
		nextTetromino = getRandomTetromino();
		createTetromino(current);
		run();
	}

	private void run() {

		Timer t = new Timer();
		TetrisTask tt = new TetrisTask(this);
		t.scheduleAtFixedRate(tt, 0, 1000 / difficulty);
	}

	private void runAlt() {

		// Will this work with KeyListener? If not, use java.util.timer.
		while (rowEmpty(grid, 0)) {
			tick();
			int waitTime = 1000 / difficulty;
			if (waitTime <= 0) {
				waitTime = 1;
			}
			try {
				TimeUnit.MILLISECONDS.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void tick() {

	}

	private void createTetromino(Tetromino current) {

		boolean[][] tetromino = current.getTetrominoMatrix();
		pivot = new Point();
		pivot.x = (grid.length / 2) - (tetromino.length / 2) - (tetromino.length % 2);
		pivot.y = 0;
		for (int i = 0; i < tetromino.length; i++) {
			for (int j = 0; j < tetromino[0].length; j++) {
				if (tetromino[i][j]) {
					grid[pivot.x + i][pivot.y + j] = current.getColor();
				}
			}
		}
		notifyObservers();
		setChanged();
		System.out.println(textGrid());
	}

	public Tetromino getRandomTetromino() {

		List<Tetromino> tetrominoes = generator.getTetrominoes();
		return tetrominoes.get((int) (Math.random() * tetrominoes.size()));
	}

	public void holdTetromino() {

		Tetromino tempTetromino = nextTetromino;
		nextTetromino = getRandomTetromino();
		heldTetromino = tempTetromino;
	}

	private boolean rowEmpty(Color[][] grid, int row) {
		return true;
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
		setChanged();
		notifyObservers();
	}

	/**
	 * Print a display of the current grid state
	 * @return
	 */
	public String textGrid() {

		String text = "Current grid:\n";
		for (int col = 0; col < grid[0].length; col++) {
			for (int row = 0; row < grid.length; row++) {
				if (grid[row][col] != null) {
					text += " T ";
				} else {
					text += " F ";
				}
			}
			text += "\n";
		}
		return text;
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

	public Point getPivot() {
		return pivot;
	}

	public void setPivot(Point pivot) {
		this.pivot = pivot;
	}
}
