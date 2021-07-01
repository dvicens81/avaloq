package com.avaloq.dice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "dices")
@Table(name = "dices")
@Builder
@Getter
@Setter
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
}
