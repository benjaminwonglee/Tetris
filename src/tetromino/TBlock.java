package tetromino;

import java.awt.Graphics;
import java.awt.Polygon;

public class TBlock extends Tetromino implements DrawInterface {

	@Override
	public void draw(Graphics g) {
		Polygon p = new Polygon();
		g.drawPolygon(p);
	}

}
