package com.avaloq.dice.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaloq.dice.dto.DiceDto;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.service.DiceService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for the dice
 * Returns a list of sum of the dices and total times that appears the number on all the rolls 
 * @author dvicensnoguera
 *
 */

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/roll")
@Slf4j
public class DiceController {
	
	private final DiceService diceService;
	
	@GetMapping
	public ResponseEntity<List<DiceDto>> getInformation(DiceFilter diceFilter) {
		log.debug("Get information numberDice {}, sides {} and total of rolls {}", diceFilter.getNumber(), diceFilter.getSides(), diceFilter.getTotalRolls());
		return new ResponseEntity<>(diceService.getRoll(diceFilter), HttpStatus.OK);
	}
}
