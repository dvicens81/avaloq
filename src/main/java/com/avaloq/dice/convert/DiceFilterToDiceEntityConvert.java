package com.avaloq.dice.convert;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.entity.DiceEntity;
/**
 * Convert DiceFilter to DiceEntity 
 * 
 * @author dvicensnoguera
 *
 */

@Component
public class DiceFilterToDiceEntityConvert {

	public DiceEntity convert(DiceFilter diceFilter) {
		return DiceEntity.builder()
						.numberDice(diceFilter.getNumber())
						.sideDice(diceFilter.getSides())
						.totalRoll(diceFilter.getTotalRolls())
						.build();
	}
}
