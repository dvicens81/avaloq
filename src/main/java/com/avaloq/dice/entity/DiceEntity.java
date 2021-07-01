package com.avaloq.dice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "dices")
@Table(name = "dices")
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getNumberDice() {
		return numberDice;
	}
	public void setNumberDice(Integer numberDice) {
		this.numberDice = numberDice;
	}
	public Integer getSideDice() {
		return sideDice;
	}
	public void setSideDice(Integer sideDice) {
		this.sideDice = sideDice;
	}
	public Integer getTotalRoll() {
		return totalRoll;
	}
	public void setTotalRoll(Integer totalRoll) {
		this.totalRoll = totalRoll;
	}
}
