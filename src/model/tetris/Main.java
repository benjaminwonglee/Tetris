package model.tetris;

import view.Frame;

public class Main {
	public static void main(String args[]) {
		System.out.println("bees");
		Tetris tetris = new Tetris(1); 
		tetris.addObserver(new Frame());	
	}
}
