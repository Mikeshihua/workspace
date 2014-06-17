package FalingBall;

import acm.program.*;
import acm.graphics.*;

public class FallingBall extends GraphicsProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Size of the ball 
	 */
	private static final int DIAM_BALL = 50;
	/**
	 * Amount Y velocity is increased each cycle as a 
	 * result of gravity
	 */
	private static final double GRAVITY = 2;
	
	/** Animation delay or pause time between ball moves
	 * 
	 */
	private static final int DELAY = 20;
	
	/** Initial X and Y location of ball
	 * 
	 */
	private static final double X_START = DIAM_BALL;
	private static final double Y_START = 100;
	
	/**
	 * X Velocity
	 */
	private static final double X_VEL = 4;
	
	/**
	 * Amount Y Velocity is reduced when it bounces
	 */
	private static final double BOUNCE_REDUCE = 0.9;
	
	/**
	 * Starting X and Y Velocties
	 */
	private double xVel = X_VEL;
	private double yVel = 0.0;
	
	private GObject ball;
	
	public void run() {
		setup();
		waitForClick();
		//�����뿪�ұ߽߱�ʱ����
		while (ball.getX() < getWidth()) {
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}

	private void setup() {
		// TODO ������Auto-generated method stub
		//ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);
		//ball.setFilled(true);
		ball = new GFace(50,50);
		add(ball);
	}
	private void moveBall() {
		// TODO Auto-generated method stub
		yVel += GRAVITY;
		ball.move(xVel, yVel);
	
	}

	private void checkForCollision() {
		// TODO Auto-generated method stub
		if(ball.getY() > getHeight()- DIAM_BALL){
			yVel = -yVel * BOUNCE_REDUCE;
			
			
			double diff = ball.getY() - (getHeight() - DIAM_BALL);
			ball.move(0, -2*diff);
		}
	}


}