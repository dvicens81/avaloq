package com.avaloq.dice.service;

import java.util.List;

import com.avaloq.dice.dto.RelativeDto;
import com.avaloq.dice.entity.RollEntity;

public interface RelativeDistributionService {
	
	RelativeDto getRelativeDistribution(int numberDice, int sideDice);
	
	Iterable<RollEntity> saveAll(List<RollEntity> rolls);

}
