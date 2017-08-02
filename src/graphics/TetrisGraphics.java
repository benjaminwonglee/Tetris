package graphics;

import javax.swing.JPanel;

public class TetrisGraphics extends JPanel {
	private static final long serialVersionUID = -1369565331561128914L;

	public TetrisGraphics() {
		this.setLayout(null);
		// Frame is 1000 x 1000
		this.setBounds(0, 0, 1000, 1000);
		JPanel gamePanel = new GamePanel();
		JPanel displayPanel = new DisplayPanel();
		this.add(gamePanel);
		this.add(displayPanel);
	}
}
