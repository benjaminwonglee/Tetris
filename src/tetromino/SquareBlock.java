package tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SquareBlock extends Tetromino implements DrawInterface {

	@Override
	public void draw(Graphics g) {
		Polygon p = new Polygon();
		g.drawPolygon(p);
	}

	@Override
	public Color getColor() {
		return Color.YELLOW;
	}

}
