package com.avaloq.dice.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.avaloq.dice.convert.DiceFilterToDiceEntityConvert;
import com.avaloq.dice.convert.DiceMapToDiceDtoConvert;
import com.avaloq.dice.convert.MapDiceFilterToRollEntityConvert;
import com.avaloq.dice.dto.DiceDto;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.operation.DiceCompleteRollOperation;
import com.avaloq.dice.repository.DiceRepository;
import com.avaloq.dice.validate.DiceValidateForm;

import lombok.AllArgsConstructor;

/**
 * Service layer.
 * 
 * This class is implemented to dispatch the differents actions (validate, roll the dices, convert and save the data). 
 * 
 * @author dvicensnoguera
 *
 */
@AllArgsConstructor
@Service
public class DiceServiceImpl implements DiceService {
	
	private final DiceCompleteRollOperation diceDistribution;
	private final DiceMapToDiceDtoConvert diceMapToDiceDtoConvert;
	private final DiceValidateForm validateForm;
	private final DiceRepository diceRepository;
	private final DiceFilterToDiceEntityConvert diceFilterToDiceEntity;
	//Only one point of access to rollRepository and is this service
	private final PercentageService relativeDistributionService; 
	private final MapDiceFilterToRollEntityConvert mapDiceFilterToRollEntityConvert;

	@Override
	public List<DiceDto> getRoll(DiceFilter diceFilter) {
		//validate the information filled
		validateForm.validateInformation(diceFilter);
		//Get roll information
		Map<Integer, Integer> map = diceDistribution.getRollInformation(diceFilter);
		//save data on database
		diceRepository.save(diceFilterToDiceEntity.convert(diceFilter));
		relativeDistributionService.saveAll(mapDiceFilterToRollEntityConvert.convert(map, diceFilter));		
		//return the result
		return diceMapToDiceDtoConvert.convert(map);
	}

}
