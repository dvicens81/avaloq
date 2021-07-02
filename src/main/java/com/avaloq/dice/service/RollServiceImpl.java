package com.avaloq.dice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avaloq.dice.convert.DiceEntityToTotalRollDtoConvert;
import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.repository.DiceRepository;

import lombok.AllArgsConstructor;
/**
 * Service layer.
 * Provide the total of rolls by number–dice side combination
 * @author dvicensnoguera
 *
 */
@Service
@AllArgsConstructor
public class RollServiceImpl implements RollService {
	
	private final DiceRepository diceRepository;
	private final DiceEntityToTotalRollDtoConvert diceEntityToTotalRollConvert;
	
	@Override
	public List<RollDto> getTotalRolls() {
		return diceEntityToTotalRollConvert.convert(diceRepository.getTotalRollByNumberAndSideDice());
	}
}
