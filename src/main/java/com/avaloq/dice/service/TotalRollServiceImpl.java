package com.avaloq.dice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avaloq.dice.convert.DiceEntityToTotalRollDtoConvert;
import com.avaloq.dice.dto.TotalRollDto;
import com.avaloq.dice.repository.DiceRepository;

import lombok.AllArgsConstructor;
/**
 * Service layer.
 * Provide the total of the simulations by existing dice number–dice side
 * @author dvicensnoguera
 *
 */
@Service
@AllArgsConstructor
public class TotalRollServiceImpl implements TotalRollService {
	
	private final DiceRepository diceRepository;
	private final DiceEntityToTotalRollDtoConvert diceEntityToTotalRollConvert;
	
	/**
	 * Provide the total of the simulations by existing dice number–dice side
	 */
	@Override
	public List<TotalRollDto> getTotalRolls() {
		return diceEntityToTotalRollConvert.convert(diceRepository.getDiceEntities());
	}
}
