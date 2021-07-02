package com.avaloq.dice.operation;

import java.util.Random;

import org.springframework.stereotype.Component;
/**
 * This class is implemented to get the total number for one roll
 *  
 * 
 * author David Vicens
 */
@Component
public class DiceSpecificRollOperation {
	
	private Random random = new Random();
	private static final int MIN_VALUE = 1;
	/**
	 * Calculate the total for one roll
	 * 
	 * @param numberDice
	 * @param side
	 * @return
	 */
	public int getTotalOfOneRoll(int numberDice, int side) {
		int start = 0;
		int total = 0;
		do {
			total = total + rollDice(side);
			start ++;
		} while (start<numberDice);
		return total;
		
	}
	
	/**
	 * Get random number between 1 and parameter side.
	 * @param side max value of the dice.
	 * @return
	 */
	private int rollDice(int side) {
		return random.nextInt(side - MIN_VALUE + 1) + MIN_VALUE;
	}

}
