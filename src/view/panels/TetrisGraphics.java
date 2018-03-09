package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.tetris.Tetris;
import view.Frame;

public class TetrisGraphics extends JPanel {
	private static final long serialVersionUID = -1369565331561128914L;
	private Frame frame;
	private GamePanel gamePanel;
	private SideDisplayPanel displayPanel;

	public TetrisGraphics(Frame parent) {

		this.frame = parent;
		this.setBackground(new Color(50, 0, 0));
		gamePanel = new GamePanel(this);
		displayPanel = new SideDisplayPanel(this);
		this.add(gamePanel, BorderLayout.WEST);
		this.add(displayPanel, BorderLayout.EAST);
	}

	public Frame getFrame() {
		return frame;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		gamePanel.repaint();
	}

	public Tetris getModel() {
		return frame.getModel();
	}

}
