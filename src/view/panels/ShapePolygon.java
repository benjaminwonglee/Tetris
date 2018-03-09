package view.panels;

import java.awt.Polygon;

public class ShapePolygon {

	public static Polygon fiveStar(int x, int y, int width, int height) {

		Polygon p = new Polygon();
		int sp = width / 6;
		p.xpoints = new int[] { x, x + width / 3, x + width / 2, x + width - (width / 3), x + width, x + width / 4 * 3,
				x + width - sp, x + width / 2, x + sp - 2, x + width / 4, x };
		p.ypoints = new int[] { y + (height / 3), y + (height / 3), y, y + (height / 3), y + (height / 3),
				y + (height / 8) * 5, y + height, y + (height / 8 * 7), y + height, y + (height / 8) * 5,
				y + (height / 3) };

		p.npoints = p.xpoints.length;
		return p;
	}

	public static Polygon hexagon(int x, int y, int width, int height) {

		Polygon p = new Polygon();
		p.xpoints = new int[] { x, x + width / 3, x + width / 3 * 2, x + width, x + width / 3 * 2, x + width / 3, x };
		p.ypoints = new int[] { y + height / 2, y, y, y + height / 2, y + height, y + height, y + height / 2 };
		p.npoints = p.xpoints.length;
		return p;
	}

	public static Polygon triangle(int x, int y, int width, int height) {

		Polygon p = new Polygon();
		p.xpoints = new int[] { x, x + width / 2, x + width, x };
		p.ypoints = new int[] { y + height, y, y + height, y + height };
		p.npoints = p.xpoints.length;
		return p;
	}

}
