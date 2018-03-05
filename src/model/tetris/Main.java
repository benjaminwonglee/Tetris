package model.tetris;

import view.Frame;

public class Main {
	public static void main(String args[]) {
		Tetris tetris = new Tetris(1);
		tetris.addObserver(new Frame());
	}
}
