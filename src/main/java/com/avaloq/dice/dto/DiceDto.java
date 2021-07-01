package com.avaloq.dice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO to return on the response
 * 
 * @author dvicensnoguera
 *
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class DiceDto {

	private int number;
	private int times;
}
