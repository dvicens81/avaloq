package com.avaloq.dice.utilities;

import java.util.List;

import org.springframework.stereotype.Component;

import com.avaloq.dice.entity.RollEntity;

@Component
public class PercentageUtilities {
	
	public String getPercentage(int totalRolls, int times) {
		return String.valueOf( (double)times/totalRolls * 100);
	}
	
	public int getTotalFromListRolls(List<RollEntity> rolls) {
		return rolls.stream().mapToInt(RollEntity::getTotal).sum();
	}

}
