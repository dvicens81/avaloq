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

import com.avaloq.dice.controller.v1.DiceController;
import com.avaloq.dice.dto.DiceDto;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.service.DiceService;

@SpringBootTest
public class DiceControllerTest {
	
	@InjectMocks
	private DiceController diceController;
	
	@Mock
	private DiceService diceService;
	
	@Test
    public void testGetInformation(){
		DiceFilter diceFilter = new DiceFilter();
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        List<DiceDto> resultExpected = new ArrayList<>();
        resultExpected.add(DiceDto.builder().number(5).times(3).build());
        resultExpected.add(DiceDto.builder().number(7).times(1).build());
        resultExpected.add(DiceDto.builder().number(8).times(2).build());
        
        when(diceService.getRoll(diceFilter)).thenReturn(resultExpected);
         
        ResponseEntity<List<DiceDto>> response = diceController.getInformation(diceFilter);
         
        assertEquals(3, response.getBody().size());
    }

}
