package com.mvpjava.random;

import java.util.Arrays;

public class Application {

	private final AtmosphericRandom atmosphericRandom;

	public Application(AtmosphericRandom atmosphericRandom) {
		this.atmosphericRandom = atmosphericRandom;
	}

	public void startApplication() {
		  System.out.println("==========================================");
		  int randomInt = atmosphericRandom.nextInt();
		  System.out.println("Random Atmospheric Integer = " + randomInt);
		  System.out.println("==========================================");
		  System.out.println("");
	  
		  System.out.println("==========================================");
		  int[] randomInts = atmosphericRandom.nextInt(5, 1, 2000);
		  System.out.println("Random Atmospheric Integers = " + Arrays.toString(randomInts)); 
		  System.out.println("==========================================");	 
		  System.out.println("");

		  System.out.println("==========================================");
		  int[] randomIntsBin = atmosphericRandom.nextInt(3, 1, 1000, false);
		  System.out.println("Random Atmospheric Integers = " +  Arrays.toString(randomIntsBin));
		  System.out.println("==========================================");
		  
	}
}
