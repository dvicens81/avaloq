package com.avaloq.dice.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.service.RollService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller class.
 * Return information related with all the rolls, number-side dide combination executed on the application
 * 
 * 
 * @author dvicensnoguera
 *
 */

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/totalroll")
@Slf4j
public class RollController {
	
	private final RollService totalRollService;
	
	@GetMapping
	public ResponseEntity<List<RollDto>> getTotalRolls() {
		log.debug("Get Total Rolls");
		return new ResponseEntity<>(totalRollService.getTotalRolls(), HttpStatus.OK);
	}
}
