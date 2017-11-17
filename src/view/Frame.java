package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.panels.TetrisGraphics;
import view.panels.TitlePanel;

public class Frame extends JFrame implements Observer {
	private static final long serialVersionUID = -4625604749828860822L;
	private JPanel mainPanel; 
	
	public Frame() {
		super("Tetris");
		JPanel titlePanel = new TitlePanel(this);
		mainPanel = new TetrisGraphics(this);
		add(titlePanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		setFrameProperties();
	}

	private void setFrameProperties() {
		// Actual width 795, Actual height 940
		addWindowListener(new TetrisWindowListener());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Deal with updates to the Tetris model
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		mainPanel.repaint();
	}

	/**
	 * Testing Main to test graphics without the game.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		new Frame();
	}

}
