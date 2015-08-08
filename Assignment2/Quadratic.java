/*
 * File: Quadratic.java
 * --------------------
 * This program is a stub for the Quadratic problem, which finds the
 * roots of the quadratic equation.
 */

import acm.program.*;

public class Quadratic extends ConsoleProgram {

	// Name:
	// Section Leader:
	
	public void run() {
		int a=readInt("A:");
		int b=readInt("B:");
		int x=(a*a)+(b*b);
		double c=Math.sqrt(x);
		println("C:"+ c +".");
		
	}

}

