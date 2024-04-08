package com.monopoly.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.monopoly.app.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
	
	@Modifying
	@Query(value = "update Player set amount = 1000, placeid=1",nativeQuery = true)
	void updateAllPlayers();
	
	@Modifying
	@Query(value = "update Player set placeid=:newposition where playername = :playername",nativeQuery = true)
	void updatePlayerPosition(String playername, int newposition);

}
