package com.avaloq.dice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.convert.ListRollEntityToRelativeDtoConvert;
import com.avaloq.dice.dto.InformationRelativeDto;
import com.avaloq.dice.dto.RelativeDto;
import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.entity.RollEntity;
import com.avaloq.dice.repository.RollRepository;

@SpringBootTest
public class RelativeDistributonServiceTest {
	
	@InjectMocks
	private RelativeDistributonServiceImpl relativeDistributionService;
	@Mock
	private RollRepository rollRepository;
	@Mock
	private ListRollEntityToRelativeDtoConvert listRollEntityToRelativeDtoConvert;
	@Test
	public void getRelativeDistributionTest() {
		int numberDice = 2;
		int sideDice = 6;
		List<RollEntity> listRolls = new ArrayList<>();
		listRolls.add(RollEntity.builder().number(2).sideDice(4).total(20).numberDice(2).build());
		listRolls.add(RollEntity.builder().number(3).sideDice(4).total(10).numberDice(2).build());
		
		List<InformationRelativeDto> listInformationRelativeDto = new ArrayList<>();
		listInformationRelativeDto.add(InformationRelativeDto.builder().number(2).percentage("20").times(3).build());
		listInformationRelativeDto.add(InformationRelativeDto.builder().number(3).percentage("10").times(4).build());
		
		RollDto rollDto = RollDto.builder().numberDice(numberDice).sideDice(sideDice).totalRolls(50).build();
		
		RelativeDto relativeDto = RelativeDto.builder().information(listInformationRelativeDto).roll(rollDto).build();
		
		when(rollRepository.getRollByNumberDiceAndSideDice(numberDice, sideDice)).thenReturn(listRolls);
		when(listRollEntityToRelativeDtoConvert.convert(listRolls)).thenReturn(relativeDto);
		
		RelativeDto response = relativeDistributionService.getRelativeDistribution(numberDice, sideDice);
		assertEquals(50, response.getRoll().getTotalRolls());
		assertEquals(2, response.getRoll().getNumberDice());
	}
	
	@Test
	public void getRelativeDistributionEmptyResultTest() {
		int numberDice = 2;
		int sideDice = 6;	
		
		when(rollRepository.getRollByNumberDiceAndSideDice(numberDice, sideDice)).thenReturn(null);
		when(listRollEntityToRelativeDtoConvert.convert(Mockito.any())).thenReturn(new RelativeDto());
		
		RelativeDto response = relativeDistributionService.getRelativeDistribution(numberDice, sideDice);
		assertNull(response.getRoll());
		assertNull(response.getInformation());
	}
	
	@Test
	public void saveTest() {
		List<RollEntity> listRolls = new ArrayList<>();
		listRolls.add(RollEntity.builder().number(2).sideDice(4).total(20).numberDice(2).build());
		listRolls.add(RollEntity.builder().number(3).sideDice(4).total(10).numberDice(2).build());
		when(rollRepository.saveAll(listRolls)).thenReturn(listRolls);
		
		Iterable<RollEntity> responseList = relativeDistributionService.saveAll(listRolls);
		Iterator<RollEntity> responseIterator = responseList.iterator();
		assertEquals(2, responseIterator.next().getNumber());
	}
	

}
