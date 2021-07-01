package com.avaloq.dice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO used for inform control errors occurred on the application
 * code:  Internal code
 * description: text to describe the error
 * @author dvicensnoguera
 *
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class CodeError implements Serializable{
	
	private static final long serialVersionUID = -3534514350963254717L;
	
	private int code;
	private String description;

}
