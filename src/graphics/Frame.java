package graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.panels.TetrisGraphics;
import tetris.Tetris;

public class Frame extends JFrame{
	private static final long serialVersionUID = -4625604749828860822L;
	private Tetris tetris;

	public Frame(Tetris tetris) {
		super("Tetris");
		this.tetris = tetris;
		JPanel mainPanel = new TetrisGraphics(this);
		add(mainPanel, BorderLayout.CENTER);
		setFrameProperties();
	}

	private void setFrameProperties() {
		// Actual width 795, Actual height 940
		setResizable(false);
		pack();
		addWindowListener(new TetrisWindowListener());
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Frame(null);
	}
}
