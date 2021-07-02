package com.avaloq.dice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/**
 * POJO to get the parameter on the url of the endpoint
 * 
 * @author dvicensnoguera
 *
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class DiceFilter {
	
	private int number;
	private int sides;
	private int totalRolls;
	
	//By Default
	public DiceFilter() {
		this.number = 3;
		this.sides = 6;
		this.totalRolls = 100;
	}

}
