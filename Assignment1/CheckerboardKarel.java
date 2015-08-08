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
 * Name: Ronnie Andrè Sletta
 * Section Leader: 
 */

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		//Brukes for å finne ut om en beeper skal plasseres ut eller ei
		boolean place=true;
		// Dersom HØYRE OG VENSTRE er blokkert fra start, må dette være en enkel rad
		if (leftIsBlocked()&&rightIsBlocked()){
			// Jeg setter ut beepere helt til jeg komme til enden av raden
			while (facingEast()){
				// Skal jeg plassere en beeper her?
				if (place==true){
					placeBeeper();
					// Fortell Karel at det ikke skal plasseres noen beeper på neste punkt
					place=!place;
					moveKarel();
				} 
				else {
					// Jeg plasserte ikke noen beeper på dette punktet, men skal plassere på neste
					place=!place;
					moveKarel();
				}
			}
		
		} else {
		// Ettersom jeg er her, består verden av flere rader
			while (leftIsClear()){
				if (rightIsClear()){ 
					// Skal jeg plassere en beeper her?
					if (place==true){
						placeBeeper();
						// Fortell Karel at det ikke skal plasseres noen beeper på neste punkt
						place=!place;
						moveKarel();
					} 
					else {
						// Jeg plasserte ikke noen beeper på dette punktet, men skal plassere på neste
						place=!place;
						moveKarel();
					}
				}
				else
				{
					// Skal jeg plassere en beeper her?
					if (place==true){
						placeBeeper();
						// Fortell Karel at det ikke skal plasseres noen beeper på neste punkt
						place=!place;
						moveKarel();
					} 
					else {
						// Jeg plasserte ikke noen beeper på dette punktet, men skal plassere på neste
						place=!place;
						moveKarel();
					}
			}
			}
		}
		
		checkForTopStreet();
		turnAround(); // STOPP!!!!!!
	}

	
	//Metode for å flytte Karel såfremt det er klart i front av han
	private void moveKarel(){
		if (frontIsClear()){
			move();
			
		} else {
			// Karel har truffet en ende, så han flytter en rad opp
			moveRow();
		}
	}
	
	//Dersom det skal være en beeper i ruten, og det ikke er det fra før, plasseres en ut
	private void placeBeeper(){
		if (noBeepersPresent()){
		putBeeper();
		}

	}
	
	//Metode for å skifte fra en ferdig utfyllt rad, til den neste over
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
		//Dersom jeg er i denne funksjonen må jeg ha kommet til den øverse raden som er oddetallsrad
		if (facingEast()){ 
			//Brukes for å finne ut om en beeper skal plasseres ut eller ei
			boolean place=true;
			// Da setter jeg igang og fyller denne også
			while (facingEast()){
				// Skal jeg plassere en beeper her?
				if (place==true){
					placeBeeper();
					// Fortell Karel at det ikke skal plasseres noen beeper på neste punkt
					place=!place;
					moveKarel();
				} 
				else {
					// Jeg plasserte ikke noen beeper på dette punktet, men skal plassere på neste
					place=!place;
					moveKarel();
				}
			}
		}
		
	}

}

