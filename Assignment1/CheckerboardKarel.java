/*/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run(){
		while (notFacingNorth()||frontIsClear()){
			putBeeper();
			if(frontIsBlocked()){
				GoUp();
				if(frontIsClear()){
					move();
					GoAhead();
					move();
				}
					
			}
			else{
				move();
				if(frontIsClear()){
					move();
				}
				else {
					GoUp();
					if(frontIsClear()){
						move();
						GoAhead();
					}
				}
			}
			
		}
	}


	private void GoAhead() {
		// let Karel face the right direction
		if(leftIsClear()){
			turnLeft();
		}
		else
			turnRight();
			
	}


	private void GoUp() {
		//go northward
		if(facingEast()){
			turnLeft();

		}
		else{
			turnRight();
		}
		
		
	}
}
