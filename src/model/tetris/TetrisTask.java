package model.tetris;

import java.util.TimerTask;

public class TetrisTask extends TimerTask {
	Tetris tetris;

	public TetrisTask(Tetris tetris) {
		this.tetris = tetris;
	}

	@Override
	public void run() {
		/*
		 * TODO: Make behaviour on 1 tick. Drops by 1; change grid. Use
		 * tetris.getPivot for position of tetromino.
		 */

	}

}
