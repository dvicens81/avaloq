package com.avaloq.dice.operation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.map.DiceMapOperations;

import lombok.AllArgsConstructor;
/**
 * This class is implemented to iterate the totalRoll send it
 * and dispatch on specific class the operations needed to 
 * fill the map
 * Key is the result of the sum of the dices and VALUE the times to appear the result
 * @author dvicensnoguera
 *
 */
@AllArgsConstructor
@Component
public class DiceCompleteRollOperation {
	
	private final DiceSpecificRollOperation diceSpecificRollOperation;
	private final DiceMapOperations diceMap;
	
	/**
	 * Iterate the number of total rolls and
	 * Update in a map all the information related with the operation
	 * 
	 * @param diceFilter
	 * @return
	 */
	public Map<Integer, Integer> getRollInformation(DiceFilter diceFilter){	
		Map<Integer, Integer> map = new HashMap<>();
		int start = 0;		
		do {
			diceMap.updateMapInformation(map, diceSpecificRollOperation.getTotalOfOneRoll(diceFilter.getNumber(), diceFilter.getSides()));
			start++;
		} while (start<diceFilter.getTotalRolls());
		
		return map;
	} 

}
