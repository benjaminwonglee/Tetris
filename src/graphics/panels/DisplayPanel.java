package graphics.panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	private static final long serialVersionUID = 4667216275241133396L;
	private TetrisGraphics tetrisGraphics;

	public DisplayPanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		defineDisplayPanel();
	}

	private void defineDisplayPanel() {
		this.setBounds(450, 50, 350, 890);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 20; i < 45; i++) {
			g.setColor(new Color(i, i, i * 2));
			g.fillRect((i - 20) * 15, 0, 15, 890);
			g.setColor(new Color(i, i, i * 3));
			g.fillRect((i - 20) * 15, 0, 15, (i - 20) * 40);

		}
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

}
