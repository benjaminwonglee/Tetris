package tetris;

import java.util.List;
import java.util.concurrent.TimeUnit;

import tetromino.Tetromino;

public class Tetris {
	List<Tetromino> tetrominoes;
	boolean[][] grid;
	int difficulty;

	public Tetris(int difficulty) {
		tetrominoes = generateTetrominoes();
		grid = new boolean[10][10];
		this.difficulty = difficulty;
		run();
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
