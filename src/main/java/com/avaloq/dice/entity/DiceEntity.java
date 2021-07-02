package com.avaloq.dice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Dices table
 * Is used to save the information related with the roll.
 * Is storage the number dice and side of the dice and the total rolls did it.
 * 
 * @author dvicensnoguera
 *
 */
@Entity(name = "dices")
@Table(name = "dices")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class DiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "number_dice")
	private Integer numberDice;
	@Column(name = "side_dice")
	private Integer sideDice;
	@Column(name = "total_roll")
	private Integer totalRoll;
	
	public DiceEntity() {
		//empry constructor
	}
}
