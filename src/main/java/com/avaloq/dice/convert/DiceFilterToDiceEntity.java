package com.avaloq.dice.convert;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.entity.DiceEntity;

@Component
public class DiceFilterToDiceEntity {

	public DiceEntity convert(DiceFilter diceFilter) {
		DiceEntity diceEntity = new DiceEntity();
		diceEntity.setNumberDice(diceFilter.getNumber());
		diceEntity.setSideDice(diceFilter.getSides());
		diceEntity.setTotalRoll(diceFilter.getTotalRolls());
		return diceEntity;
//		return DiceEntity.builder()
//							.numberDice(diceFilter.getNumber())
//							.sideDice(diceFilter.getSides())
//							.totalRoll(diceFilter.getTotalRolls())
//							.build();
	}
}
