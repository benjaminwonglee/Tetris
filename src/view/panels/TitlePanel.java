package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import view.Frame;

public class TitlePanel extends JPanel {
	
	private static final long serialVersionUID = 2349693647370386088L;
	private Frame frame;

	public TitlePanel(Frame frame) {
		
		this.frame = frame;
		defineTitlePanel();
	}

	private void defineTitlePanel() {
		this.setPreferredSize(new Dimension(800, 50));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 70; i++) {
			g.setColor(new Color(i * 3, i * 3, i * 3));
			g.fillRect(i * 15, 0, 15, 50);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Georgia", Font.ITALIC, 32));
		g.drawString("Tetris", 15, 40);
	}

	public Frame getFrame() {
		return frame;
	}

}
