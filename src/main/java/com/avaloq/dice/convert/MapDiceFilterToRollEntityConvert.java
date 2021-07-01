package com.avaloq.dice.convert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.entity.RollEntity;
/**
 * Convert DiceFilter to DiceEntity 
 * 
 * @author dvicensnoguera
 *
 */

@Component
public class MapDiceFilterToRollEntityConvert {

	public List<RollEntity> convert(Map<Integer, Integer> source, DiceFilter diceFilter) {
		return source	.entrySet()
						.stream()
						.map(dice -> RollEntity.builder()
											.numberDice(diceFilter.getNumber())
											.sideDice(diceFilter.getSides())
											.number(dice.getKey())
											.total(dice.getValue())
											.build())
						.collect(Collectors.toList()); 
	}
}
