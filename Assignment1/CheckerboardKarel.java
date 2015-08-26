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
 * Name: Ronnie Andrèe Sletta
 * Section Leader: 
 */

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		//Used to determine if beeper should be places, or not
		boolean place=true;
		// If both RIGHT and LEFT is blocked from the start, this must be a single row
		if (leftIsBlocked()&&rightIsBlocked()){
			// I'm placing beepers until the end of the row
			while (facingEast()){
				// Should I put down a beeper here?
				if (place==true){
					placeBeeper();
					// Don't place a beeper on the next spot, Karel!
					place=!place;
					moveKarel();
				} 
				else {
					// I didn't place a beeper here, so I'll put one down on the next move.
					place=!place;
					moveKarel();
				}
			}
		
		} else {
		// Since I'm here, I guess the world must have more than one row.
			while (leftIsClear()){
				if (rightIsClear()){ 
					// Should I put down a beeper here?
					if (place==true){
						placeBeeper();
						// Don't place a beeper on the next spot, Karel!
						place=!place;
						moveKarel();
					} 
					else {
						// I didn't place a beeper here, so I'll put one down on the next move.
						place=!place;
						moveKarel();
					}
				}
				else
				{
					// Should I put down a beeper here?
					if (place==true){
						placeBeeper();
						// Don't place a beeper on the next spot, Karel!
						place=!place;
						moveKarel();
					} 
					else {
						// I didn't place a beeper here, so I'll put one down on the next move.
						place=!place;
						moveKarel();
					}
			}
			}
		}
		
		checkForTopStreet();
		turnAround(); // STOP!!!!!!
	}

	
	//Method for moving Karel, as long as he has a clear path infront of him
	private void moveKarel(){
		if (frontIsClear()){
			move();
			
		} else {
			// Karel hit the end of the row, so he's moving to the next row above him
			moveRow();
		}
	}
	
	//If this square is supossed to have a beeper, and there isn't one here allready, put one down.
	private void placeBeeper(){
		if (noBeepersPresent()){
		putBeeper();
		}

	}
	
	//Method for moving from a filled row, to the next one above it.
	private void moveRow(){
		if (facingEast()){
			turnLeft();
			if (frontIsClear()){
				move();
				turnLeft();
			}					
			
		}
		else
		{
			turnRight();
			if (frontIsClear()){
				move();
				turnRight();
				
			}
		}
	}

	private void checkForTopStreet(){
		//If I'm in this function, I must be one the top row, which is an odd numbered row.
		if (facingEast()){ 
			//Used to determine if beeper should be places, or not
			boolean place=true;
			// Ok, I'll start filling this to then
			while (facingEast()){
				// Should I put down a beeper here?
				if (place==true){
					placeBeeper();
					// Don't place a beeper on the next spot, Karel!
					place=!place;
					moveKarel();
				} 
				else {
					// I didn't place a beeper here, so I'll put one down on the next move.
					place=!place;
					moveKarel();
				}
			}
		}
		
	}

}

