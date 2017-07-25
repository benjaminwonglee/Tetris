package tetris;

import java.util.List;

import tetromino.Tetromino;

public class Tetris {
	List<Tetromino> tetrominoes;
	boolean[][] grid;

	public Tetris(int difficulty) {
		tetrominoes = generateTetrominoes();
		grid = new boolean[10][10];
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
