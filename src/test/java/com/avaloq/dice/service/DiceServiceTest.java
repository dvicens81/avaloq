package com.avaloq.dice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.convert.DiceFilterToDiceEntityConvert;
import com.avaloq.dice.convert.DiceMapToDiceDtoConvert;
import com.avaloq.dice.convert.MapDiceFilterToRollEntityConvert;
import com.avaloq.dice.dto.DiceDto;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.operation.DiceCompleteRollOperation;
import com.avaloq.dice.repository.DiceRepository;
import com.avaloq.dice.validate.DiceValidateForm;

@SpringBootTest
public class DiceServiceTest {
	
	@InjectMocks
	private DiceServiceImpl diceService;
	@Mock
	private DiceCompleteRollOperation diceDistribution;
	@Mock
	private DiceMapToDiceDtoConvert diceMapToDiceDtoConvert;
	@Mock
	private DiceValidateForm validate;
	@Mock
	private DiceRepository diceRepository;
	@Mock
	private DiceFilterToDiceEntityConvert diceFilterToDiceEntity;
	@Mock
	private PercentageService relativeDistributionService; 
	@Mock
	private MapDiceFilterToRollEntityConvert mapDiceFilterToRollEntityConvert;
	
	@Test
	public void testService() {
		DiceFilter diceFilter = new DiceFilter();
		Map<Integer, Integer> expectedMapResult = new HashMap<>();
		expectedMapResult.put(2, 4);
		expectedMapResult.put(5, 6);
		expectedMapResult.put(7, 3);
		
		List<DiceDto> expectedListResult = new ArrayList<>();
		expectedListResult.add(DiceDto.builder().number(2).times(4).build());
		expectedListResult.add(DiceDto.builder().number(5).times(6).build());
		expectedListResult.add(DiceDto.builder().number(7).times(3).build());
		
		when(diceDistribution.getRollInformation(diceFilter)).thenReturn(expectedMapResult);
		when(diceMapToDiceDtoConvert.convert(expectedMapResult)).thenReturn(expectedListResult);
		
		List<DiceDto> result = diceService.getRoll(diceFilter);
		assertEquals(2, result.get(0).getNumber());
		assertEquals(5, result.get(1).getNumber());
		assertEquals(7, result.get(2).getNumber());
		assertEquals(4, result.get(0).getTimes());
		assertEquals(6, result.get(1).getTimes());
		assertEquals(3, result.get(2).getTimes());
	}

}
