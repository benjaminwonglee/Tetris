package graphics.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import graphics.Frame;

public class TetrisGraphics extends JPanel {
	private static final long serialVersionUID = -1369565331561128914L;
	private Frame frame;

	public TetrisGraphics(Frame parent) {
		this.frame = parent;
		this.setPreferredSize(new Dimension(900, 940));
		this.setBackground(Color.BLACK);
		JPanel titlePanel = new TitlePanel(this);
		JPanel gamePanel = new GamePanel(this);
		JPanel displayPanel = new DisplayPanel(this);
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.WEST);
		this.add(displayPanel,BorderLayout.EAST);
	}

	public Frame getFrame() {
		return frame;
	}
}
