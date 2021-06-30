package com.avaloq.dice.enums;
/**
 * Enum to categorize all the errors on the app
 * 
 * @author dvicensnoguera
 *
 */
public enum DiceErrorsEnum {
	NUMBER_DICE(100, "Number of dice is invalid the min value is 1"),
	TOTAL_ROLLS(101, "Total rolls is invalid the min value is 1"),
	SIDES_DICE(102, "Sides of the dice is invalid the min value is 4");
	
	private int code;
	private String description;
	
	private DiceErrorsEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return this.description;
	}

}
