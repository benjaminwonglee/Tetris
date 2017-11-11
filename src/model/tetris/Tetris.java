package model.tetris;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import common.Action;
import model.tetromino.Tetromino;
import model.tetromino.TetrominoGenerator;

public class Tetris extends Observable {
	private boolean[][] grid;
	private int difficulty;
	private TetrominoGenerator generator = new TetrominoGenerator();
	private Tetromino current;
	private Tetromino nextTetromino;
	private Tetromino heldTetromino;

	public Tetris(int difficulty) {
		grid = new boolean[10][10];
		this.difficulty = difficulty;
		current = getRandomTetromino();
		nextTetromino = getRandomTetromino();
		
		run();
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

	private void run() {
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

	private boolean rowEmpty(boolean[][] grid, int row) {
		return false;
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

	public TetrominoGenerator getGenerator() {
		return generator;
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
