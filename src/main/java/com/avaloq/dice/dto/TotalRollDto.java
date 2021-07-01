package com.avaloq.dice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TotalRollDto {
	
	private int numberDice;
	private int sideDice;
	private long totalRolls;

}
