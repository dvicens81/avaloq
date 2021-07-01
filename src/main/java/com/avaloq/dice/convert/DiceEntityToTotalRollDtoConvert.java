package com.avaloq.dice.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.TotalRollDto;
import com.avaloq.dice.entity.DiceEntity;
/**
 * Convert DiceEntity to TotalRollDto
 * @author dvicensnoguera
 *
 */
@Component
public class DiceEntityToTotalRollDtoConvert {
	
	public List<TotalRollDto> convert(List<DiceEntity> list){
		return list.stream().map(this::buildTotalRoll ).collect(Collectors.toList());
	}
	
	private TotalRollDto buildTotalRoll(DiceEntity diceEntity) {
		return TotalRollDto.builder()
							.numberDice(diceEntity.getNumberDice())
							.totalRolls(diceEntity.getTotalRoll())
							.sideDice(diceEntity.getSideDice())
							.build();							
	}

}
