package com.monopoly.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monopoly.app.entities.Player;
import com.monopoly.app.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Transactional
	public void resetPlayer() {
		playerRepository.updateAllPlayers();
	}
	
	public Player getPlayer(String playername) {
		return playerRepository.findById(playername).get();
	}
	
	@Transactional
	public void updatePlayerPosition(String playername, int newPosition) {
		playerRepository.updatePlayerPosition(playername, newPosition);
	}
	
	public void savePlayer(Player player) {
		playerRepository.save(player);
	}
}
