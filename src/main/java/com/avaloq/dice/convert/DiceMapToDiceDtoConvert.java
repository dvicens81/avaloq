package com.avaloq.dice.convert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.DiceDto;

import lombok.AllArgsConstructor;
/**
 * Convert class
 * @author dvicensnoguera
 *
 */
@AllArgsConstructor
@Component
public class DiceMapToDiceDtoConvert {
	/**
	 * Convert Map<Integer, Integer> to List<DiceDto>
	 * @param source
	 * @return
	 */
	public List<DiceDto> convert(Map<Integer, Integer> source) {
		
		return source	.entrySet()
						.stream()
						.map(dice -> DiceDto.builder()
											.number(dice.getKey())
											.times(dice.getValue())
											.build())
						.collect(Collectors.toList()); 
	}

}
