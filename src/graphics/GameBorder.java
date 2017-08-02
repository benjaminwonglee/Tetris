package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class GameBorder implements Border {

	@Override
	public Insets getBorderInsets(Component arg0) {
		return new Insets(0, 0, 0, 0);
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	@Override
	public void paintBorder(Component arg0, Graphics g, int x, int y, int width, int height) {
		for (int i = 30; i >= 0; i--) {
			g.setColor(new Color(200 - i * 2, i * 5, 0));
			g.drawRect(i, i, width - (i * 2), height - (i * 2));
		}
	}

}
