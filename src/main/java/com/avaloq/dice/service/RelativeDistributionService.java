package com.avaloq.dice.service;

import com.avaloq.dice.dto.RelativeDto;

public interface RelativeDistributionService {
	
	RelativeDto getRelativeDistribution(int numberDice, int sideDice);

}
