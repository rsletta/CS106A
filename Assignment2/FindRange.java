/*
 * File: FindRange.java
 * --------------------
 * This program is a stub for the FindRange problem, which finds the
 * smallest and largest values in a list of integers.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {

	// Name: 
	// Section Leader: 
	
	public void run() {
		int smallest=0;
		int largest=0;
		int input=1;
		while (input!=0) {
			input = readInt("Skriv er tall(0 avslutter):");
			if (input<smallest){
				smallest=input;
			} else if (input>largest) {
				largest=input;
			}
		}
		println("Smallest:"+smallest+".");
		println("Largest:"+largest+".");
	}

}
