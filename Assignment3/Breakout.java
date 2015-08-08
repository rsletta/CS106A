/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	// Name: Ronnie Sletta
	// Section Leader: 
	
/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 600;
	public static final int APPLICATION_HEIGHT = 400;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 50;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 15;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;
	

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 5;

/**
 * Private Instance Variables
*/
	private RandomGenerator rgen = RandomGenerator.getInstance(); 
	private GRect paddle;
	private GLabel scoreLabel;
	private GLabel livesLabel;
	private GOval ball;
	private GRect brick;	
	private GObject GObj;
	private int score=0;
	private int lives=NTURNS;
	private double ballSpeed=6;
	private double ballXV= rgen.nextDouble(1.0, 3.0); 
	private double ballYV=ballSpeed;
	private boolean alive=false;
	//private AudioClip boing = MediaTools.loadAudioClip("bounce.au"); 

	
	
/** Runs the Breakout program. */
	public void run() {
		setup();
		while (lives>=0){
			gameLoop();
			lives--;
		}
	}
	
	
	/*
	 * Metode for å gjøre alt klar til spill.Tegner blokker, spiller-figur, og laster inn lyd.Når metoden er ferdig,
	 * er brettet klar for å spilles
	 */
	private void setup(){
		
		drawBrickGrid();
		drawPaddle();
		drawBall();	
		drawHUD();
		updateHUD();
		addMouseListeners();
	}

	/*/////////////////////////////////////////////////////////////////////////////////
	 * Metoder som brukes i Setup()
	 */////////////////////////////////////////////////////////////////////////////////
	
	private void drawBrickGrid() {
		int brickRows=NBRICK_ROWS;
		int bricksInRow=NBRICKS_PER_ROW;
		int rowPositionX=((WIDTH / 2) - ((BRICK_WIDTH+(BRICK_SEP))*bricksInRow)/2 + (BRICK_SEP / 2));
		int rowPositionY=HEIGHT - HEIGHT + BRICK_Y_OFFSET;
		Color brickColor=Color.RED;
		
		//Mursteinens startposisjon begynner selvsagt på radens startposisjon
		int brickPositionX=rowPositionX;
		int brickPositionY=rowPositionY;
		//Så lenge det er mursteiner igjen, er det bare å bygge.For hver murstein som tegnes, trekkes en fra totalen
		for (int i = brickRows; i > 0 ; i-- )
		{
			if (i<=2){
				brickColor=Color.CYAN;
			}
			else if (i<=4){
				brickColor=Color.GREEN;
			}
			else if (i<=6){
				brickColor=Color.YELLOW;
			}
			else if (i<=8){
				brickColor=Color.ORANGE;
			}
			for (int j = NBRICKS_PER_ROW; j > 0 ; j-- )
			{
				
				// Tegn en rute i posisjonX og posisjonY
				drawBrick(brickPositionX,brickPositionY,brickColor);
				brickPositionX=brickPositionX+BRICK_WIDTH+BRICK_SEP;
			}
			brickPositionY=brickPositionY+BRICK_HEIGHT+BRICK_SEP;
			brickPositionX=rowPositionX; //Resett startposisjon X

			
		}
	}
	
	private void drawBrick(int BrickPositionX,int BrickPositionY,Color brickColor){
		brick = new GRect(BrickPositionX,BrickPositionY,BRICK_WIDTH,BRICK_HEIGHT);
		brick.setFilled(true);
		brick.setFillColor(brickColor);
		add(brick);
	}
	
	private void drawPaddle(){
		int paddlePosX=((WIDTH / 2) - (PADDLE_WIDTH / 2));
		int paddlePosY=HEIGHT - PADDLE_Y_OFFSET;;
		paddle = new GRect(paddlePosX,paddlePosY,PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}
	
	private void drawBall(){
		ball = new GOval (paddle.getX()+ (paddle.getWidth() / 2), paddle.getY() -  100, BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
	}
	
	private void drawHUD(){
		scoreLabel=new GLabel("");
		scoreLabel.setFont(new Font("Helvetica",Font.BOLD, 25));
		add(scoreLabel,0,scoreLabel.getAscent());
		livesLabel=new GLabel("");
		livesLabel.setFont(new Font("Helvetica",Font.BOLD, 25));
		add(livesLabel,getWidth() - 100, livesLabel.getAscent());
	}
	
	private void gameLoop(){
		alive=!alive;
		while (alive!=false)
		{
			updateHUD();
			moveBall();
			checkForCollision();
			pause(30);
		}
	}
	
	/*/////////////////////////////////////////////////////////////////////////////////
	 * Metoder som brukes i gameloop()
	 */////////////////////////////////////////////////////////////////////////////////
	
	private void updateHUD(){
		String scoreString=Integer.toString(score);
		scoreLabel.setLabel("Score: " + scoreString);
		String livesString=Integer.toString(lives);
		livesLabel.setLabel("Lives: " + livesString);
	}
	

	public void mouseMoved(MouseEvent e){
		if (paddle.getX()<=getWidth() - PADDLE_WIDTH){
			paddle.move(e.getX()-paddle.getX(),getY());
			
		} 
		else 
		{
			paddle.setLocation(getWidth() - PADDLE_WIDTH,HEIGHT - PADDLE_Y_OFFSET);
		}
	}
	
	
	private void moveBall(){
		ball.move(ballXV,ballYV);
	}
	
	private void checkForCollision(){
		/*
		 * Sjekk for kollisjon med verden
		 * 
		 */
		
		//Hvis ballen treffer høyre vegg,gå mot venstre
		if(ball.getX()-3 > getWidth()-(BALL_RADIUS * 2)){
			ballXV=-ballXV;
			//boing.play();
		}
		
		//Hvis ballen treffer venstre vegg,gå mot går
		if(ball.getX()-3 < 0){
			ballXV=-ballXV;
			//boing.play();
		}
		
		//Hvis ballen treffer gulvet, skifte retning oppover
		if(ball.getY()-3 > getHeight()-(BALL_RADIUS * 2)){
			///ballYV=-ballYV;
			alive=!alive;
			ball.setLocation(paddle.getX()+ (paddle.getWidth() / 2), paddle.getY() -  20);
			pause(500);
		}
		
		//Hvis ballen treffer taket, skifter retning nedover
		if(ball.getY()-3 < 0){
			ballYV=-ballYV;
			//boing.play();
		}
		  
		/*
		 * Sjekk kollisjoner mot objekter
		 */
		//Sjekk VENSTRE HJØRNE
		if (getElementAt(ball.getX(),ball.getY())!=null){
			GObj=getElementAt(ball.getX(),ball.getY());
			if (GObj != null){
				if (GObj==paddle){
					ballYV=-ballYV;
					//boing.play();
				} 
				else if (GObj==scoreLabel){

				}
				else if (GObj==livesLabel){

				}	
				else {
					if (GObj.getColor()==Color.CYAN){
						score+=25;
					} else if (GObj.getColor()==Color.GREEN){
						score+=30;
					}else if (GObj.getColor()==Color.YELLOW){
						score+=35;
					} else if (GObj.getColor()==Color.ORANGE){
						score+=40;
					}else if (GObj.getColor()==Color.RED){
						score+=100;
					}
					
					remove(GObj);
					ballYV=-ballYV;
					//boing.play();
				}	
			}	
		}


	}
	


}
