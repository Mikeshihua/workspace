/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	public void run(){
		GoOutRoom();
		pickBeeper();
		GoBackRoom();
		putBeeper();
		turnRight();
	}

	//turns karel 90 degrees to the right
	
	public void turnRight(){
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	//turn karel around 180 degrees 
	
	public void turnAround(){
		turnLeft();
		turnLeft();
	}
	
	//let Karel go out of the room
	
	public void GoOutRoom(){
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	//let Karel go back of the old position
	
	public void GoBackRoom(){
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
	}
}
