/*
 * File: GraphicsHierarchy.java
 * ----------------------------
 * This program is a stub for the GraphicsHierarchy problem, which
 * draws a partial diagram of the acm.graphics hierarchy.
 */

import acm.graphics.*;
import acm.program.*;

public class GraphicsHierarchy extends GraphicsProgram {
	
	public void run() {
		drawRect(275,100,150,50);
		drawRect(100,200,150,50);
		drawRect(275,200,150,50);
		drawRect(450,200,150,50);
		drawLabel("Program",350,125);
		drawLabel("GraphicsProgram",175,225);
		drawLabel("ConsoleProgram",350,225);
		drawLabel("DialogProgram",525,225);
		drawLine(350,150,175,200);
		drawLine(350,150,350,200);
		drawLine(350,150,525,200);
	}

	private void drawLine(int x0, int y0, int x1, int y1) {
		// TODO Auto-generated method stub
		GLine line = new GLine(x0,y0,x1,y1);
		add(line);
	}

	private void drawLabel(String string, int x, int y) {
		// TODO Auto-generated method stub
		GLabel l = new GLabel(string);
		add(l,x-l.getWidth()/2,y);
	}

	private void drawRect(int x, int y, int w, int h) {
		// TODO Auto-generated method stub
		GRect r = new GRect(x,y,w,h);
		add(r);
	}

}
