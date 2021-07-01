package com.avaloq.dice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class InformationRelativeDto extends DiceDto {
	
	private String percentage;

}
