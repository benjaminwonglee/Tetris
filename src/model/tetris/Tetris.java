package model.tetris;

import java.util.concurrent.TimeUnit;

import model.tetromino.TetrominoGenerator;

public class Tetris {
	boolean[][] grid;
	int difficulty;
	TetrominoGenerator generator = new TetrominoGenerator();
	
	public Tetris(int difficulty) {
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

	}

	private boolean rowEmpty(boolean[][] grid, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	public void rotateLeft() {
		
	}

	public void rotateRight() {
		
	}

	public void holdTetromino() {
		generator.holdTetromino();
	}
}
