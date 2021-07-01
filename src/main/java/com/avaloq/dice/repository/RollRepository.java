package com.avaloq.dice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.avaloq.dice.entity.RollEntity;

public interface RollRepository extends CrudRepository<RollEntity, Long> {
	
	@Query(value = "SELECT number, number_dice, side_dice, SUM(total) as total, SUM(id) as id " +
			"FROM rolls " +
			"WHERE number_dice = ?1 and side_dice = ?2 " +
			"GROUP BY number, number_dice, side_dice",
			nativeQuery = true)
	public List<RollEntity> getRollByNumberDiceAndSideDice(int numberDice, int sideDice);
	
	

}


