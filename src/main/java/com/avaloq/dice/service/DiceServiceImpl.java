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
import com.avaloq.dice.repository.RollRepository;
import com.avaloq.dice.validate.DiceValidateForm;

import lombok.AllArgsConstructor;

/**
 * Service layer.
 * It is a middle class that do specific actions (validate, roll the dices and convert).
 * 
 * This class dispatch to other classes the functionalities to do. 
 * 
 * @author dvicensnoguera
 *
 */
@AllArgsConstructor
@Service
public class DiceServiceImpl implements DiceService {
	
	private final DiceCompleteRollOperation diceDistribution;
	private final DiceMapToDiceDtoConvert convert;
	private final DiceValidateForm validate;
	private final DiceRepository diceRepository;
	private final DiceFilterToDiceEntityConvert diceFilterToDiceEntity;
	private final RollRepository rollRepository;
	private final MapDiceFilterToRollEntityConvert mapDiceFilterToRollEntityConvert;

	@Override
	public List<DiceDto> getRoll(DiceFilter diceFilter) {
		//validate the information filled
		validate.validateInformation(diceFilter);
		Map<Integer, Integer> map = diceDistribution.getRollInformation(diceFilter);
		//save data on database
		diceRepository.save(diceFilterToDiceEntity.convert(diceFilter));
		rollRepository.saveAll(mapDiceFilterToRollEntityConvert.convert(map, diceFilter));		
		//return the result
		return convert.convert(map);
	}

}
