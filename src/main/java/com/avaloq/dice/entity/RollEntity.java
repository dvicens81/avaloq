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

@Entity(name = "rolls")
@Table(name = "rolls")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class RollEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "number_dice")
	private Integer numberDice;
	@Column(name = "side_dice")
	private Integer sideDice;
	@Column(name = "number")
	private Integer number;
	@Column(name="total")
	private Integer total;
	
	public RollEntity() {
		//empty constructor
	}
}
