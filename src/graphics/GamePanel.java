package graphics;

import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1244543786097347429L;

	public GamePanel() {
		defineGamePanel();
	}

	private void defineGamePanel() {
		this.setBounds(0, 0, 600, 1000);
		this.setBackground(new Color(0, 100, 100));

	}

}
