package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import view.Frame;

public class TetrisGraphics extends JPanel {
	private static final long serialVersionUID = -1369565331561128914L;
	private Frame frame;

	public TetrisGraphics(Frame parent) {
		this.frame = parent;
		this.setBackground(new Color(50, 0, 0));
		JPanel gamePanel = new GamePanel(this);
		JPanel displayPanel = new DisplayPanel(this);
		this.add(gamePanel, BorderLayout.WEST);
		this.add(displayPanel, BorderLayout.EAST);
	}

	public Frame getFrame() {
		return frame;
	}
}
