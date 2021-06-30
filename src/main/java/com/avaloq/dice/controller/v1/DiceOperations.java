package com.avaloq.dice.controller.v1;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avaloq.dice.dto.DiceDto;
import com.avaloq.dice.dto.DiceFilter;

/**
 * Interface Driven Controller 
 * New feature introduced in Spring 5.1. 
 * Now, when Spring MVC controllers implement an interface, 
 * they do this not only in the standard Java way but also inherit all web request related 
 * functionality defined in the interface.
 * 
 * @author dvicensnoguera
 *
 */

@RequestMapping("/default")
public interface DiceOperations {
	
	@GetMapping
	ResponseEntity<List<DiceDto>> getInformation(DiceFilter diceFilter);

}
