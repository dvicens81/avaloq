package com.avaloq.dice.utilities;

import java.util.List;

import org.springframework.stereotype.Component;

import com.avaloq.dice.entity.RollEntity;
/**
 * Utilities class for calculate the percentage and getTotal from list of rolls
 * @author dvicensnoguera
 *
 */
@Component
public class PercentageUtilities {
	/**
	 * Get the percentage 
	 * @param totalRolls
	 * @param times
	 * @return
	 */
	public String getPercentage(int totalRolls, int times) {
		return String.valueOf( (double)times/totalRolls * 100);
	}
	/**
	 * Get sum total attribute from rollEntity list 
	 * @param rolls
	 * @return
	 */
	public int getTotalFromListRolls(List<RollEntity> rolls) {
		return rolls.stream().mapToInt(RollEntity::getTotal).sum();
	}

}
