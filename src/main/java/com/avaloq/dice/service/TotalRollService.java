package com.avaloq.dice.service;

import java.util.List;

import com.avaloq.dice.dto.TotalRollDto;
/**
 * Service layer.
 * Provide the total of the simulations by existing dice number–dice side
 * @author dvicensnoguera
 *
 */
public interface TotalRollService {
	
	public List<TotalRollDto> getTotalRolls();

}
