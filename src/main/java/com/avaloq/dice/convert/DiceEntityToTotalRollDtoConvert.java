package com.avaloq.dice.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.entity.DiceEntity;
/**
 * Convert DiceEntity to TotalRollDto
 * @author dvicensnoguera
 *
 */
@Component
public class DiceEntityToTotalRollDtoConvert {
	
	public List<RollDto> convert(List<DiceEntity> list){
		return list.stream().map(this::buildTotalRoll ).collect(Collectors.toList());
	}
	
	private RollDto buildTotalRoll(DiceEntity diceEntity) {
		return RollDto.builder()
							.numberDice(diceEntity.getNumberDice())
							.totalRolls(diceEntity.getTotalRoll())
							.sideDice(diceEntity.getSideDice())
							.build();							
	}

}
