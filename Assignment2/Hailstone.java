/*
 * File: Hailstone.java
 * --------------------
 * This program is a stub for the Hailstone problem, which computes
 * Hailstone sequence described in Assignment #2.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {

	// Name: 
	// Section Leader: 
	
	public void run() {
		int n=readInt("Skriv et tall:");
		int x=0;
		while (n!=1){
			if (n%2==0){
				println(+n+" er et partall");
				n=(n/2);
				x++;
			} else {
				println(+n+" er et oddetall");
				n=(n*3)+1;
				x++;
			}
		}
		println("Da var det over.Det tok "+x+" runder Œ komme frem til "+n+".");
	}

}
