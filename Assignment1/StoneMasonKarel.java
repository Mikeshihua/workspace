/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run(){
		while (leftIsClear()||frontIsClear()){
			if(frontIsBlocked()){
				if(noBeepersPresent())
					putBeeper();
				GoUpStair();
			}
			else
				ShallWePutBeeper();
			}
		if(noBeepersPresent())
			putBeeper();
	}

	//Karel WIll go up stair
	
	private void GoUpStair() {
		if(facingEast()){
			turnLeft();
			move();
			turnLeft();
		}
		else{
			turnRight();
			move();
			turnRight();
		}
		
		
	}


	//let Karel know weather put a beeper
	
	private void ShallWePutBeeper() {
		for (int i=0;i<=3;i++){
			if(i==0){
				if (beepersPresent())
					move();
				else{
					putBeeper();
					move();
				}
			}
			else 
					move();
		}
		
	}

}
