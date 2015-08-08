/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

/*
 * Name: Ronnie Sletta
 * Section Leader: 
 */

public class CheckerboardKarel_ronnie extends SuperKarel {

	public void run() {
		while (frontIsClear()){
			boolean place=true;
			moveKarel();
			while (place==true){
				putBeeper();
			}
			moveKarel();
			place=!place;
		}
	}

	private void moveKarel(){
		if (frontIsClear()){
			move();
			
		} else {
			moveRow();
		}
	}
	
	private void moveRow() {
		
	}
}

