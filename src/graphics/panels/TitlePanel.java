package graphics.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	private static final long serialVersionUID = 2349693647370386088L;
	private TetrisGraphics tetrisGraphics; 
	
	public TitlePanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		defineTitlePanel();
	}

	private void defineTitlePanel() {
		this.setBackground(new Color(10,10,10));
		this.setBounds(0, 0, 795, 50);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Georgia", Font.ITALIC, 32));
		g.drawString("Tetris", 15, 40);
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}
	
	
}
