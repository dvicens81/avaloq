package com.avaloq.dice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
/**
 * DTO that is used to return the percentage of the number and times of all the rolls
 * 
 * @author dvicensnoguera
 *
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class InformationRelativeDto extends DiceDto {	
	private String percentage;

}
