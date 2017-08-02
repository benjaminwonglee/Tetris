package graphics;

import java.awt.Color;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	private static final long serialVersionUID = 4667216275241133396L;

	public DisplayPanel() {
		defineDisplayPanel();
	}

	private void defineDisplayPanel() {
		this.setBackground(new Color(100, 100, 0));
		this.setBounds(700, 0, 300, 1000);
	}
}
