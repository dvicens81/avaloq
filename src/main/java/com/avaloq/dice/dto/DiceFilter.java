package com.avaloq.dice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
