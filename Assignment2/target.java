import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class target extends GraphicsProgram{
	public static final double SMALL_CIRCLE_R = 50;
	public static final double MID_CIRCLE_R = 100;
	public static final double LARGE_CIRCLE_R = 150;
	
	public void run(){
		double x = getWidth()/2;
		double y = getHeight()/2;
		drawCircle(x,y,LARGE_CIRCLE_R,Color.red);
		drawCircle(x,y,MID_CIRCLE_R,Color.white);
		drawCircle(x,y,SMALL_CIRCLE_R,Color.red);
	}

	private void drawCircle(double x, double y, double D, Color color) {
		// TODO Auto-generated method stub
		GOval circle = new GOval(x-D/2,y-D/2,D,D);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle);
	}
}
