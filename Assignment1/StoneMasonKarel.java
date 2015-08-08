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

/*
 * Name: 
 * Section Leader: 
 */

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		while (facingEast()){
		buildCollumn();
		goToBaseline();
		moveToNextCollumn();
		}
	}

	private void buildCollumn(){
		turnLeft();
		while (frontIsClear()){
			if (noBeepersPresent()) {
				putBeeper();
				//if (frontIsClear()) {
					move();	
				//}
				
			} else {
				//if (frontIsClear()){
					move();	
				//}
				
			}
		}
		if (noBeepersPresent()) {
			putBeeper();
			
		} else {

			
		}
	}
	
	private void goToBaseline(){
		turnAround();
		while (frontIsClear()){
			move();
		}
		turnLeft();
	}
	
	private void moveToNextCollumn(){
		if (frontIsClear()){
			move();
			move();
			move();
			move();
	
		} else {
			goHome();
		}

	}

	private void goHome(){
		turnAround();
		while (frontIsClear()){
			move();
		}
		//turnAround();
	}
	
}
