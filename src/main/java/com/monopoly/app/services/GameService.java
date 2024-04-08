package com.monopoly.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monopoly.app.entities.Game;
import com.monopoly.app.entities.Player;
import com.monopoly.app.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public void resetGame() {
		gameRepository.deleteAll();
	}
	
	public int roll_die() {
		int dice1 = (int)(Math.random()*6+1);
		int dice2 = (int)(Math.random()*6+1);
		
		return dice1 + dice2;
	}
	
	public void saveGame(Game game) {
		gameRepository.save(game);
	}

}
