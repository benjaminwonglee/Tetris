package graphics.panels;

import java.awt.Color;
import java.awt.Dimension;
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
		this.setBounds(0, 0, 795, 50);
		this.setPreferredSize(new Dimension(795, 50));
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

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

}
