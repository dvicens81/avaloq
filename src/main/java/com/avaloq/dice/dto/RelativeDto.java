package com.avaloq.dice.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RelativeDto {
	
	private TotalRollDto roll;
	private List<InformationRelativeDto> information;

}
