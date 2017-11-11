package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.tetris.Tetris;

public class Controller implements KeyListener {

	Tetris model;

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
		switch (e.getKeyChar()) {
		case KeyEvent.VK_Z:
			model.rotateLeft();
			break;
		case KeyEvent.VK_X:
			model.rotateRight();
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
			model.rotateLeft();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
