package graphics;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	public Frame() {
		JFrame frame = new JFrame();
		frame.setTitle("Tetris");
		frame.setPreferredSize(new Dimension(750, 935));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.addWindowListener(new TetrisWindowListener());
		JPanel mainPanel = new TetrisGraphics();
		frame.add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		new Frame();
	}
}
