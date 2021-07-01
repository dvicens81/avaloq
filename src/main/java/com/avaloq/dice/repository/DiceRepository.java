package com.avaloq.dice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.avaloq.dice.entity.DiceEntity;

public interface DiceRepository extends CrudRepository<DiceEntity, Long> {
	
	@Query(value="SELECT number_dice, side_dice, SUM(total_roll) as total_roll, SUM(id) as id FROM dices GROUP BY number_dice, side_dice", 
			nativeQuery = true)
	public List<DiceEntity> getDiceEntities();
	
	

}


