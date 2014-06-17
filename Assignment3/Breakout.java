/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;
/**
 * Initialize of velocity
 */
	private static final int START_VELOCITY = 3;
	private static final double DELAY = 2;
	
/** Number of turns */
	private static final int NTURNS = 3;
	



/** Runs the Breakout program. */
	public void main() {
		/* You fill this in, along with any subsidiary methods */
		run();
		
	}
	public void run() {
	// TODO Auto-generated method stub
	//设置窗口大小
		
		
		setupbricks();
		setuppaddle();
		setupball();
		waitForClick();
		setupspeed();
		setuplabel();
		addMouseListeners();
		addKeyListeners();
		while(ball.getY() <= APPLICATION_HEIGHT && ballNum >= 1){
			moveball();
			checkForCollision();
			pause(DELAY);
		}
		if(ballNum>=1){
			add(gameOver,90,300);
		}
		else{
			add(win,80,300);
		}
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		location.setLabel("Mouse:("+e.getX()+","+e.getY()+")"+"    left number of bricks"+ballNum);
		paddle.move((e.getX()+PADDLE_WIDTH)>APPLICATION_WIDTH?0:(e.getX()-paddle.getX()),0);
	}
	public void showlabel(){
		location.setLabel("Mouse:("+","+")"+"    left number of bricks"+ballNum);
	}
	private void setuplabel() {
		// TODO Auto-generated method stub
		location = new GLabel("");
		location.setFont("Times New Roman-20");
		add(location,10,30);
		gameOver = new GLabel("Game Over");
		gameOver.setFont("Times New Roman-50");
		win = new GLabel("Yeah! You WIN.");
		win.setFont("Times New Roman-40");
		win.setColor(Color.red);
	}
	private void movepaddle(double xt) {
		// TODO Auto-generated method stub
		paddle.move(xt,0);
	}
	private void checkForCollision() {
		// TODO Auto-generated method stub
		double x = ball.getX();
		double y = ball.getY();
		movepaddle(vx);
		GObject collider_left = getCollidingObject(x-1,y+BALL_RADIUS);
		GObject collider_right = getCollidingObject(x+2*BALL_RADIUS+1,y+BALL_RADIUS);
		GObject collider_up = getCollidingObject(x+BALL_RADIUS,y-1);
		GObject collider_down = getCollidingObject(x+BALL_RADIUS,y+1+2*BALL_RADIUS);
		
		if(y < 300 && y > 60){
			if(collider_up !=null && collider_up != collider_left 
					&& collider_up != collider_right && collider_up != collider_down){
				remove(collider_up);
				vy=-vy;
				bounceClip.play();
				ballNum--;
			}
			if(collider_down !=null && collider_down != collider_left 
					&& collider_down != collider_right){
				remove(collider_down);
				vy=-vy;
				bounceClip.play();
				ballNum--;
			}
			if(collider_left !=null&& collider_left!=collider_right){
				remove(collider_left);
				vx=-vx;
				bounceClip.play();
				ballNum--;
			}
			if(collider_right !=null){
				remove(collider_right);
				vx=-vx;
				bounceClip.play();
				ballNum--;
			}

		}
		else{
			if(collider_down == paddle){
				if(y<550){
					vy=-vy;
					bounceClip.play();
				}
			}
		}
		if (y <= 0 ){
			vy=-vy;
		}
		if(x <= 0 || x >= APPLICATION_WIDTH-BALL_RADIUS*2){
			vx=-vx;
		}
		showlabel();
	}
	private void setupspeed() {
		// TODO Auto-generated method stub
		vx = rgen.nextDouble(1.0,3.0);
		if (rgen.nextBoolean(0.5))vx=-vx;
		vy= -START_VELOCITY;
	}
	private void moveball() {
		// TODO Auto-generated method stub
		ball.move(vx, vy);
	}
	private void setupball() {
		// TODO Auto-generated method stub
		ball = new GOval(BALL_RADIUS*2,BALL_RADIUS*2);
		ball.setFilled(true);
		add(ball,APPLICATION_WIDTH/2-BALL_RADIUS,APPLICATION_HEIGHT-PADDLE_Y_OFFSET-2*BALL_RADIUS-1);
	}
	private void setuppaddle() {
		// TODO Auto-generated method stub
		paddle = new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle,(APPLICATION_WIDTH-PADDLE_WIDTH)/2,APPLICATION_HEIGHT-PADDLE_Y_OFFSET);
	}
	private void setupbricks() {
		// TODO Auto-generated method stub
		Color arry_color[]={Color.red,Color.orange,Color.yellow,Color.green,Color.cyan};
		for(int i= 0 ; i < NBRICK_ROWS; i++){
			for(int j = 0 ;j < NBRICKS_PER_ROW; j++){
				bricks[i][j]= new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				bricks[i][j].setColor(arry_color[i/2]);
				bricks[i][j].setFillColor(arry_color[i/2]);
				bricks[i][j].setFilled(true);
				add(bricks[i][j],(BRICK_WIDTH+BRICK_SEP)*j,BRICK_Y_OFFSET+BRICK_HEIGHT*i+BRICK_SEP*(i+1));
				
			}
		}
	}
	private GObject getCollidingObject(double d, double f){
		return getElementAt(d,f);
	}
	private GOval ball;
	private GRect paddle;
	private GRect bricks[][]=new GRect[10][10];
	private GLabel location;
	private GLabel gameOver;
	private GLabel win;
	private double vx,vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private int ballNum = 100;

	
}
