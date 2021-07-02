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
/**
 * Service layer.
 * 
 * This class is to manage the information related to number-side combination and
 * the percentage that numbers appears on the rolls for all simulations.
 * 
 * @author dvicensnoguera
 *
 */
@Service
@AllArgsConstructor
public class PercentageServiceImpl implements PercentageService{
	
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

	@Override
	public Iterable<RollEntity> saveAll(List<RollEntity> rolls) {
		return rollRepository.saveAll(rolls);
	}
	
	

}
