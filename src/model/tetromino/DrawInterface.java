package model.tetromino;

import java.awt.Color;
import java.awt.Graphics;

public interface DrawInterface {

	public void draw(Graphics g, int pixPerBlock, int startX, int startY);

	public Color getColor();
}
