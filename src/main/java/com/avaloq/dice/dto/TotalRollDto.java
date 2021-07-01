package com.avaloq.dice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class TotalRollDto {
	
	private int numberDice;
	private int sideDice;
	private int totalRolls;

}
