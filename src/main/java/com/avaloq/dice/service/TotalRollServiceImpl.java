package com.avaloq.dice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avaloq.dice.convert.DiceEntityToTotalRollDtoConvert;
import com.avaloq.dice.dto.TotalRollDto;
import com.avaloq.dice.repository.DiceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TotalRollServiceImpl implements TotalRollService {
	
	private final DiceRepository diceRepository;
	private final DiceEntityToTotalRollDtoConvert convert;
	

	@Override
	public List<TotalRollDto> getTotalRolls() {
		return convert.convert(diceRepository.getDiceEntities());
	}
}
