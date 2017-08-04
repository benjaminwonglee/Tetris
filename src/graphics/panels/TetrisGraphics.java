package graphics.panels;

import javax.swing.JPanel;

import graphics.Frame;

public class TetrisGraphics extends JPanel {
	private static final long serialVersionUID = -1369565331561128914L;
	private Frame frame;

	public TetrisGraphics(Frame parent) {
		this.frame = parent;
		this.setLayout(null);
		this.setBounds(0, 0, 900, 940);
		JPanel titlePanel = new TitlePanel(this);
		JPanel gamePanel = new GamePanel(this);
		JPanel displayPanel = new DisplayPanel(this);
		this.add(titlePanel);
		this.add(gamePanel);
		this.add(displayPanel);
	}

	public Frame getFrame() {
		return frame;
	}	
}
