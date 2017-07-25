package tetris;

import java.util.List;
import java.util.concurrent.TimeUnit;

import tetromino.Tetromino;

public class Tetris {
	List<Tetromino> tetrominoes;
	boolean[][] grid;
	int difficulty;
	Tetromino nextTetromino;
	Tetromino heldTetromino;

	public Tetris(int difficulty) {
		tetrominoes = generateTetrominoes();
		nextTetromino = getRandomTetromino();
		heldTetromino = getNextTetromino();
		grid = new boolean[10][10];
		this.difficulty = difficulty;
		run();
	}

	private Tetromino getRandomTetromino() {
		return tetrominoes.get((int) (Math.random() * tetrominoes.size()));
	}

	private Tetromino getNextTetromino() {
		Tetromino tempTetromino = nextTetromino;
		nextTetromino = getRandomTetromino();
		return tempTetromino;
	}

	private void run() {
		while (rowEmpty(grid, 0)) {
			tick();
			int waitTime = 1000 / difficulty;
			if (waitTime <= 0) {
				waitTime = 1;
			}
			try {
				TimeUnit.MILLISECONDS.sleep(waitTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void tick() {
		// TODO Auto-generated method stub

	}

	private boolean rowEmpty(boolean[][] grid, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	private List<Tetromino> generateTetrominoes() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String args[]) {
		System.out.println("bees");
		new Tetris(1);
	}
}
