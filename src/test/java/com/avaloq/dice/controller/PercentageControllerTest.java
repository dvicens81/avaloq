package com.avaloq.dice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.avaloq.dice.controller.v1.PercentageController;
import com.avaloq.dice.dto.InformationRelativeDto;
import com.avaloq.dice.dto.RelativeDto;
import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.service.PercentageService;

@SpringBootTest
public class PercentageControllerTest {
	
	@InjectMocks
	private PercentageController percentageController;
	@Mock
	private PercentageService relativeDistributionService;
	
	@Test
    public void testGetPercentage(){
		int numberDice = 2;
		int sideDice = 6;
		
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
	    List<InformationRelativeDto> listInformationRelativeDto = new ArrayList<>();
		listInformationRelativeDto.add(InformationRelativeDto.builder().number(2).percentage("20").times(3).build());
		listInformationRelativeDto.add(InformationRelativeDto.builder().number(3).percentage("10").times(4).build());
		RollDto rollDto = RollDto.builder().numberDice(numberDice).sideDice(sideDice).totalRolls(50).build();
		
		RelativeDto relativeDto = RelativeDto.builder().information(listInformationRelativeDto).roll(rollDto).build();
        when(relativeDistributionService.getRelativeDistribution(numberDice, sideDice)).thenReturn(relativeDto);
        
        ResponseEntity<RelativeDto> response = percentageController.getRelativeDistribution(numberDice, sideDice);
		assertEquals(50, response.getBody().getRoll().getTotalRolls());
		assertEquals(2, response.getBody().getRoll().getNumberDice());
    }
}
