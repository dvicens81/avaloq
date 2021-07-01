package com.avaloq.dice.map;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Class to execute operations with Map interface
 * @author dvicensnoguera
 *
 */

@Component
public class DiceMapOperations {
	/**
	 * Receive sum of the roll and add or update the information on the Map.
	 * @param map
	 * @param sumRoll
	 */
	public void updateMapInformation(Map<Integer,Integer> map, int sumRoll) {
		map.compute(sumRoll, (k,v) -> map.getOrDefault(k, 0) + 1);
	}
}
