package com.avaloq.dice.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.InformationRelativeDto;
import com.avaloq.dice.dto.RelativeDto;
import com.avaloq.dice.dto.TotalRollDto;
import com.avaloq.dice.entity.RollEntity;
import com.avaloq.dice.utilities.PercentageUtilities;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ListRollEntityToRelativeDtoConvert {
	
	private final PercentageUtilities percentageUtilities;
	
	public RelativeDto convert(List<RollEntity> rolles){
		int totalRolls = percentageUtilities.getTotalFromListRolls(rolles);
		return RelativeDto.builder()
					.information(buildListInformationRelativeDto(rolles, totalRolls))
					.roll(buildTotalRoll(rolles.get(0), totalRolls))
					.build();
		
	}
	
	private InformationRelativeDto buildInformationRelativeDto(RollEntity rollEntity, int totalRolls) {
		return InformationRelativeDto.builder()
								.number(rollEntity.getNumber())
								.times(rollEntity.getTotal())
								.percentage(percentageUtilities.getPercentage(totalRolls, rollEntity.getTotal()))
								.build();
	}
	
	private List<InformationRelativeDto> buildListInformationRelativeDto(List<RollEntity> rolles, int totalRolls){
		
		return rolles.stream()
				.map(roll->buildInformationRelativeDto(roll,totalRolls))
				.collect(Collectors.toList());
	}
	
	private TotalRollDto buildTotalRoll(RollEntity rollEntity, int totalRolls) {
		return TotalRollDto.builder()
					.numberDice(rollEntity.getNumberDice())
					.sideDice(rollEntity.getSideDice())
					.totalRolls(totalRolls)
					.build();
	}

}
