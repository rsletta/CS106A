/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

/*
 * Name: Ronnie Sletta
 * Section Leader: 
 */

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		countToWall();
		findMidPoint();
		//Vi har endelig funnet midtpunktet, men nå står jo Karel en steg til venstre for beeperen og ser på den..
		move();//Flytt et steg slik at du står på beeperen...
		
		
	}
	
	/*
	 * Metode som fyller raden med beepers, helt til den treffer veggen.
	 * Når veggen treffes, går Karel tilbake og henter alle beepere og samler
	 * de i an haug i enden av raden.Når han er ferdig har han samme antall 
	 * beppere i haugen som raden er lang.
	 * */
	private void countToWall() {
			
			while (leftIsClear()){ 
				placeBeeper();
				move();
				placeBeeper();
				turnRight(); // Snu 90 grader mot høyre for å sjekke om enden av raden er nådd
				if (leftIsBlocked()&&frontIsBlocked()){ 
					turnAround();
				}
				turnLeft();	// Snu 90 grader mot venstre for å rette Karel opp igjen	
			}
			//Gå tilbake, hent alle beepere, og plasser de i en haug i enden av raden
			while (frontIsClear())
			{
				move();			
				if (beepersPresent()){
					turnAround();
					pickBeeper();
					moveToEastWall();
					putBeeper();
				}
			}
			turnAround();
			moveToEastWall();
	}
	
	/*
	 * Metode for å finne midten. Karel står nå på en stabel av beepers som tilsvarer bredden av raden.Ved å flytte mot midten ved 
	 * å legge ut en beeper pr runde, men fjerne to fra haugen, vil han komme til midten når han går tom i haugen sin.Når han er tom
	 * for beepere i haugen,rydder han opp "telle-beepere", før han triumfernde står på midtpunktets beeper.:)
	 * */
	private void findMidPoint(){

		while (beepersPresent()){
				
				// Dersom det er flere beepere igjen,plukk opp en som skal flyttes ut
				if (beepersPresent())
				{
					pickBeeper();
				}
				
				// Dersom det er tomt for beepere i enden av raden, betyr det at midten er funnet, og Karel kan rydde opp
				if (noBeepersPresent()){
					cleanBeepers();
				} 
				// Det er flere beepere igjen her, så Karel skal flytte den mot midten
				else
				{
					while(beepersPresent()){ //Så lenge Karel står på en beeper, skal han gå fremover til han finner et tomrom
						move();
					}				
					// Når Karel stopper kan han legge ned en beeper
					placeBeeper();
					turnAround(); //Snu for å gå tilbake
					moveToEastWall(); // Gå tilbake til østveggen
					//Dersom det er flere beepere igjen, skal en til fjernes, slik at totalt 2 stk blir borte for hver som flyttes ut
					if (beepersPresent()) 
					{
						pickBeeper();
					}	
					//Dersom det ikke er flere igjen, kan Karel rydde opp
					if (noBeepersPresent()){
						cleanBeepers();
					}
				}
		}
	}
	
	
	//Dersom det ikke er en beeper her fra før, legg en ut.
	private void placeBeeper(){
		if (noBeepersPresent()){
			putBeeper();
		}
	}
		
	//Metode for å flytte Karel helt over til østveggen
	private void moveToEastWall(){
		while (leftIsClear()){
			move();
			turnRight();
			if (leftIsBlocked()&&frontIsBlocked()){
				turnAround();
			}
			turnLeft();		
		}
	}
	
	
	//Metode for å rydde telle-beepere.Utgangspunktet er at Karel står i høyreenden av raden, vendt mot venstre, og er tom for beepere
	private void cleanBeepers() {
	move();// Flytt et steg mot venstre
		while (beepersPresent()){ // Er det en beeper her?
			move(); //Ja, det var det, flytt et sted til
			// Er det en beeper her da?
			if (beepersPresent()){ 
				turnAround();// Jau,det var en her også.Da var ikke forrige beeper midten.Snu rundt igjen
				move();// Og flytt tilbake
				turnAround();//Snu deg mot venstre igjen.
				pickBeeper();//Plukk opp beeperen vi vet at ikke er midten
				move();// Flytt et steg mot venstre (Ja, vi har vært her allerede, og strengt tatt vet vi at det er en beeper her.)
			} 
			// Nope, her var det ingen beeper. Det betyr at den forrige beeperen var midtpunkten mitt
			else
			{
				turnAround();// Snu rundt
				
			}
			
		}
		
	}
	
}
