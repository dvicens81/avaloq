package com.avaloq.dice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
/**
 * DTO to return on the response
 * 
 * @author dvicensnoguera
 *
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class DiceDto {

	private int number;
	private int times;
}
