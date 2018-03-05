package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SideDisplayPanel extends JPanel {
	private static final long serialVersionUID = 4667216275241133396L;
	private TetrisGraphics tetrisGraphics;

	public SideDisplayPanel(TetrisGraphics tetrisGraphics) {
		this.tetrisGraphics = tetrisGraphics;
		defineDisplayPanel();
	}

	/**
	 * Height is defined as 22 squares x 40 pixels = 880 + (5*2) + 1
	 */
	private void defineDisplayPanel() {
		this.setPreferredSize(new Dimension(380, 891));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		for (int i = 20; i < 50; i++) {

			// Darker Grey
			g.setColor(new Color(i*2, i*2, i*2));
			g.fillRect((i - 20) * 15, 0, 15, 891);

			// Lighter Grey
			g.setColor(new Color(i*3, i*3, i*3));
			g.fillRect((i - 20) * 15, 0, 15, (i - 20) * 35);
		}

	}

	public TetrisGraphics getTetrisGraphics() {
		return tetrisGraphics;
	}

}
