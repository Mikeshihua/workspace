package FalingBall;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/*
* This class draws a checkerboard on the graphics window.
* The size of the checkerboard is specified by the
* constants NROWS and NCOLUMNS, and the checkboard fills
* the vertical space available.
*/
public class chessBoard extends GraphicsProgram {
	/* Number of rows */
	private static final int NROWS = 8;
	/* Number of columns */
	private static final int NCOLUMNS = 8;
	/* Runs the program */
	public void run() {
	int sqSize = getHeight() / NROWS;
		for (int i = 0; i < NROWS; i++) {
			for (int j = 0; j < NCOLUMNS; j++) {
				int x = j * sqSize;
				int y = i * sqSize;
				GRect sq = new GRect(x, y, sqSize, sqSize);
				sq.setFilled(((i + j) % 2) != 0);
				add(sq);
			}
		}
	}
}