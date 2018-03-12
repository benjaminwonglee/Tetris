package model.tetris;

import java.util.TimerTask;

import common.Action;

public class TetrisTask extends TimerTask {

	Tetris tetris;

	public TetrisTask(Tetris tetris) {
		this.tetris = tetris;
	}

	@Override
	public void run() {
		tetris.setTetrominoAction(Action.SOFT_DROP);
	}

}
