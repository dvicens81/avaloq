package com.avaloq.dice.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.avaloq.dice.convert.ListRollEntityToRelativeDtoConvert;
import com.avaloq.dice.dto.RelativeDto;
import com.avaloq.dice.entity.RollEntity;
import com.avaloq.dice.repository.RollRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RelativeDistributorServiceImpl implements RelativeDistributionService{
	
	private final RollRepository rollRepository;
	private final ListRollEntityToRelativeDtoConvert listRollEntityToRelativeDtoConvert;
	
	@Override	
	public RelativeDto getRelativeDistribution(int numberDice, int sideDice) {
		List<RollEntity> listRolls = rollRepository.getRollByNumberDiceAndSideDice(numberDice, sideDice);
		
		return Optional.ofNullable(listRolls)
						.filter(CollectionUtils::isNotEmpty)
						.map(listRollEntityToRelativeDtoConvert::convert)
						.orElseGet(RelativeDto::new);
	}
	
	

}
