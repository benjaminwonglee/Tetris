package common;

import java.awt.Color;

public class PrintUtils {

	/**
	 * Print a display of the current grid state
	 *
	 * @return the text version display of the grid
	 */
	public static String getTextGrid(Color[][] grid) {

		String text = "Current grid:\n";
		for (int col = 0; col < grid[0].length; col++) {
			for (int row = 0; row < grid.length; row++) {
				if (grid[row][col] != null) {
					text += " T ";
				} else {
					text += " F ";
				}
			}
			text += "\n";
		}
		return text;
	}

}
