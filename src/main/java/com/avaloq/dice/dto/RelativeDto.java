package com.avaloq.dice.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
/**
 *  Root DTO that is used to return relative distribution
 * 
 *  
 * @author dvicensnoguera
 *
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RelativeDto {
	
	private RollDto roll;
	private List<InformationRelativeDto> information;

}
