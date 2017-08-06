package graphics;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.panels.TetrisGraphics;
import tetris.Tetris;

public class Frame {
	private Tetris tetris;

	public Frame(Tetris tetris) {
		this.tetris = tetris;
		JFrame frame = new JFrame();
		frame.setTitle("Tetris");
		// Actual width 795, Actual height 940
		// frame.setPreferredSize(new Dimension(800, 975));
		frame.setPreferredSize(new Dimension(795, 940));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.pack();
		frame.addWindowListener(new TetrisWindowListener());
		JPanel mainPanel = new TetrisGraphics(this);
		frame.add(mainPanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		new Frame(new Tetris(1));
	}
}
