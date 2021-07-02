package com.avaloq.dice.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaloq.dice.dto.RelativeDto;
import com.avaloq.dice.service.PercentageService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller class
 * Receive numberDIce and sideDice and return a dto 
 * that contains the information related with the parameters send it.
 * Total rolls, percentage of the numbers that were appeared.
 * @author dvicensnoguera
 *
 */

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/relative")
@Slf4j
public class PercentageController {
	
	private final PercentageService relativeDistributionService;
	
	@GetMapping("/numberDice/{numberDice}/sideDice/{sideDice}")
	public ResponseEntity<RelativeDto> getRelativeDistribution(@PathVariable("numberDice") Integer numberDice,
																	@PathVariable("sideDice") Integer sideDice) {
		log.debug("Get getRelativeDistribution, numberDice, sideDice, {}, {}");
		return new ResponseEntity<>(relativeDistributionService.getRelativeDistribution(numberDice, sideDice), HttpStatus.OK);
	}
}
