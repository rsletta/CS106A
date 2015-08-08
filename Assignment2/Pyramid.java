/*
 * File: Pyramid.java
 * ------------------
 * This program is a stub for the Pyramid problem, which draws
 * a brick pyramid.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

	// Name:Ronnie Sletta
	// Section Leader:
	
	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		// Deklarerer en INT for hvor mange mursteiner en rad skal bestŒ av.
		int bricksInRow=BRICKS_IN_BASE; 
		//Utgangsposisjon for raden i h¿yde. pner med at f¿rste rad ligger pŒ bunnen av vinduet
		int rowPositionY=getHeight(); 
		/*Utgangsposisjon for raden i side.F¿rst finnes midten av vinduet.
		SŒ trekkes det utregnete offsettet pŒ raden fra, for Œ finne ut hvor raden skal begynne i side*/
		int rowPositionX=(getWidth() / 2) - ((BRICK_WIDTH*bricksInRow) / 2);
		//SŒ lenge det er mursteiner igjen Œ sette ut, fyller vi opp pyramiden
		while (bricksInRow>0){
			//Tegn en rad med mursteiner, bestŒende av X antall steiner, og raden begynner pŒ X,Y
			drawRow(bricksInRow,rowPositionX,rowPositionY);
			// Trekk 1 murstein fra antallet en rad skal bestŒ av
			bricksInRow=bricksInRow-1;
			//Den nye raden skal begynne 1 mursteinsh¿yde over den forrige
			rowPositionY=rowPositionY-BRICK_HEIGHT;
			//Den nye raden skal begynne en 1/2 mursteinsbredde til h¿yre for den forrige
			rowPositionX=rowPositionX+(BRICK_WIDTH / 2);
		}
	}
	/*
	 * Metode for Œ tegne en rad av mursteiner. FŒr inn verdiene for hvor mange mursteiner raden skal bestŒ av,
	 * samt startposisjon for side og h¿yde.
	 */
	private int drawRow(int bricksInRow,int rowPositionX,int rowPositionY) {
		//Mursteinens startposisjon begynner selvsagt pŒ radens startposisjon
		int brickPositionX=rowPositionX;
		int brickPositionY=rowPositionY;
		//SŒ lenge det er mursteiner igjen, er det bare Œ bygge.For hver murstein som tegnes, trekkes en fra totalen
		for (int i=bricksInRow;i>0;i--)
		{
			// Tegn en murstein i posisjonX og posisjonY
			drawBrick(brickPositionX,brickPositionY);
			//Legg til bredden av en murstein til posisjonen i side.
			brickPositionX=brickPositionX+BRICK_WIDTH;

		}
		return 0;
	}
	
	/*
	 *Metode for Œ tegne en enkelt murstein. FŒr verdien for posisjonen fra drawRow() 
	 */
	private int drawBrick(int BrickPositionX,int BrickPositionY){
		GRect brick=new GRect(BrickPositionX,BrickPositionY,BRICK_WIDTH,BRICK_HEIGHT);
		add(brick);
		return 0;
		
	}
}
