package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1244543786097347429L;
	private TetrisGraphics tetrisGraphics;

	public GamePanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		JPanel grid = new GridPanel();
		add(grid);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(50, 10, 10));
		g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
		int offset1 = 1;
		int offsetW1 = 6;
		g.setColor(new Color(100, 10, 10));
		g.fillRect(offset1 + offsetW1, offset1, getPreferredSize().width - (offset1 * 2) - (offsetW1 * 2),
				getPreferredSize().height - (offset1 * 2));
		int offset2 = 3;
		int offsetW2 = 10;
		g.setColor(new Color(130, 10, 10));
		g.fillRect(offset2 + offsetW2, offset2, getPreferredSize().width - (offset2 * 2) - (offsetW2 * 2),
				getPreferredSize().height - (offset2 * 2));
	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(450, 891);
	}

}
