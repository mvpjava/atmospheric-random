package com.mvpjava.random;

import java.util.Arrays;

public class Application {

	private final AtmosphericRandom atmosphericRandom;

	public Application(AtmosphericRandom atmosphericRandom) {
		this.atmosphericRandom = atmosphericRandom;
	}

	public void startApplication() {
		  int randomInt = atmosphericRandom.nextInt();
		  System.out.println("Random Atmospheric Integers = " + randomInt);
		  System.out.println("==========================================");
		 		  
		  int[] randomInts = atmosphericRandom.nextInt(2, 1, 200);
		  System.out.println("Random Atmospheric Integers = " +
		  Arrays.toString(randomInts)); 
		  System.out.println("==========================================");	 

		  int[] randomIntsBin = atmosphericRandom.nextInt(3, 1, 1000, false, 2);
		  System.out.println("Random Atmospheric Integers = " +
		  Arrays.toString(randomIntsBin));
	}
}
