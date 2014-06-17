/*
 * double our beepers 
 */
//import stanford.karel.*;
/*
* File: Checkerboard.java
* -----------------------
* This program draws a checkerboard.
*/
import acm.graphics.*;
import acm.program.*;

public class ourDoubleBeeper extends GraphicsProgram {
	public void run(){
		add( new GLabel("hello,world",100,75));
	}
}
//public class ourDoubleBeeper extends SuperKarel {
//	public void run(){
//		move();
//		DobleBeepersInPile();
//		moveBackward();
//	}
//	
//	private void moveBackward(){
//		turnAround();
//		move();
//		turnAround();
//		
//	}
//	
//	private void DobleBeepersInPile(){
//		while(beepersPresent()){
//			pickBeeper();
//			PutTwoBeepersNextDoor();
//		}
//		MovepileNextDoorBack();
//	}
//	
//	private void PutTwoBeepersNextDoor(){
//		move();
//		putBeeper();
//		putBeeper();
//		moveBackward();
//	}
//	
//	private void MovepileNextDoorBack(){
//		move();
//		while (beepersPresent()){
//			MoveOneBeeperBack();
//		}
//		moveBackward();
//	}
//	
//	private void MoveOneBeeperBack(){
//		pickBeeper();
//		moveBackward();
//		putBeeper();
//		move();
//	}
//}


