package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import common.Action;
import model.tetris.Tetris;

public class Controller implements KeyListener {

	Tetris model;

	public Controller(Tetris model) {
		this.model = model;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'a':
			model.setTetrominoAction(Action.MOVE_LEFT);
			break;
		case 'd':
			model.setTetrominoAction(Action.MOVE_RIGHT);
			break;
		case 's':
			model.setTetrominoAction(Action.SOFT_DROP);
			break;
		case 'z':
			model.setTetrominoAction(Action.ROTATE_LEFT);
			break;
		case 'x':
			model.setTetrominoAction(Action.ROTATE_RIGHT);
			break;
		case 'c':
			model.holdTetromino();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			model.setTetrominoAction(Action.ROTATE_RIGHT);
			break;
		case KeyEvent.VK_DOWN:
			model.setTetrominoAction(Action.SOFT_DROP);
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
