/*
 * File: Rainbow.java
 * ------------------
 * This program is a stub for the Target problem, which displays
 * a target by adding consecutively smaller circles to the canvas.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {

	// Name:Ronnie Sletta
	// Section Leader:
	private static final int PIXELS_PER_INCH=72;
	
	public void run() {
		double WINDOW_CENTER_WIDTH =getWidth() / 2;
		double WINDOW_CENTER_HEIGHT =getHeight() / 2;	
		drawCircle(WINDOW_CENTER_HEIGHT,WINDOW_CENTER_WIDTH,1,Color.RED);
		drawCircle(WINDOW_CENTER_HEIGHT,WINDOW_CENTER_WIDTH,0.63,Color.WHITE);
		drawCircle(WINDOW_CENTER_HEIGHT,WINDOW_CENTER_WIDTH,0.3,Color.RED);
	}
	
	private void drawCircle(double circleCenterPosHeight,double circleCenterPosWidth, double sizeInInch,Color circleColor){
		double size=(PIXELS_PER_INCH *(sizeInInch*2)) ;		
		GOval circle= new GOval((circleCenterPosWidth-(size /2)) ,(circleCenterPosHeight-(size /2)),size,size);
		circle.setColor(circleColor);
		circle.setFilled(true);
		circle.setFillColor(circleColor);
		add(circle);
	}
}
