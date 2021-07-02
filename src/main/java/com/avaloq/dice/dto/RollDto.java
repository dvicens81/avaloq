package com.avaloq.dice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
/**
 * DTO that has the number dice, side dice and totalRolls
 * Is used when is necessary to return 
 * the information related total number of simulations and total rolls made.
 * 
 * Is used to return the relative distribution on specific number-side combination
 * 
 * @author dvicensnoguera
 *
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RollDto {
	
	private int numberDice;
	private int sideDice;
	private int totalRolls;

}
