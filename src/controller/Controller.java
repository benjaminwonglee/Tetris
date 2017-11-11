package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import common.Action;
import model.tetris.Tetris;

public class Controller implements KeyListener {

	Tetris model;

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
		switch (e.getKeyChar()) {
		case KeyEvent.VK_A:
			model.setTetrominoAction(Action.MOVE_LEFT);
			break;
		case KeyEvent.VK_D:
			model.setTetrominoAction(Action.MOVE_RIGHT);
			break;
		case KeyEvent.VK_S:
			model.setTetrominoAction(Action.SOFT_DROP);
			break;
		case KeyEvent.VK_Z:
			model.setTetrominoAction(Action.ROTATE_LEFT);
			break;
		case KeyEvent.VK_X:
			model.setTetrominoAction(Action.ROTATE_RIGHT);
			break;
		case KeyEvent.VK_C:
			model.holdTetromino();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			model.setTetrominoAction(Action.ROTATE_RIGHT);
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_KP_LEFT:
			model.setTetrominoAction(Action.MOVE_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_KP_RIGHT:
			model.setTetrominoAction(Action.MOVE_RIGHT);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
