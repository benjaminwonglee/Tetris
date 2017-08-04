package graphics;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.panels.TetrisGraphics;

public class Frame {
	public Frame() {
		JFrame frame = new JFrame();
		frame.setTitle("Tetris");
		// Actual width 795, Actual height 940
		frame.setPreferredSize(new Dimension(800, 975));
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
		new Frame();
	}
}
