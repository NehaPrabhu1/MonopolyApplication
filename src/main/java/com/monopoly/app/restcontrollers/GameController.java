package com.monopoly.app.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monopoly.app.entities.Game;
import com.monopoly.app.entities.Place;
import com.monopoly.app.entities.Player;
import com.monopoly.app.services.GameService;
import com.monopoly.app.services.PlaceService;
import com.monopoly.app.services.PlayerService;

@RestController
@RequestMapping("")
public class GameController {
	static int turn = 1;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private GameService gameService;

	@GetMapping("/create-game/")
	public String createGame() {

		// places boughtby null
		placeService.resetPlace();

		// player amount 1000
		playerService.resetPlayer();

		// delete all game table rows
		gameService.resetGame();
		
		turn = 1;

		return "Game created";
	}

	@GetMapping("/roll-die/{playername}")
	public String rollDie(@PathVariable("playername") String playername) {
		Game game = new Game();
		
		game.setPlayername(playername);
		
		//roll die
		int die_rolled = gameService.roll_die();

		//get currentposition for player
		Player player = playerService.getPlayer(playername);
		Player otherPlayer = null;
		int currentPosition = player.getPlaceid();
			
		int calc = (currentPosition + die_rolled)%11;
		int newPosition = calc == 0 ? 11: calc;
		
		game.setPlaceid(newPosition);
		
		//save newposition for player
		player.setPlaceid(newPosition);
		
		//check if place unclaimed
		Place place = placeService.findPlace(newPosition);
		
		String outcome = "";
		
		if(place.getBoughtby() == null) {
			place.setBoughtby(playername);
			int amount = player.getAmount() - place.getBuyprice();
			player.setAmount(amount);
			game.setBuy(true);
			game.setRent(false);
			outcome = " bought for "+place.getBuyprice()+ " now has "+player.getAmount();
		}else if(place.getBoughtby().equals(playername)) {
			game.setBuy(true);
			game.setRent(false);
		}
		else {
			String playername1 = place.getBoughtby();
			int amount = player.getAmount() - place.getRent();
			player.setAmount(amount);
			game.setBuy(false);
			game.setRent(true);
			
			Player otherplayer = playerService.getPlayer(playername1);
			otherplayer.setAmount(otherplayer.getAmount()+place.getRent());
			outcome = " rented for "+ place.getRent()+ " now has "+player.getAmount();
		}
		
		//save place, player, player1, game
		placeService.savePlace(place);
		playerService.savePlayer(player);
		if(otherPlayer != null)
			playerService.savePlayer(otherPlayer);
		gameService.saveGame(game);
		
		turn++;
		if(turn == 50 || player.getAmount()<0) {
			return "Game over";
		}
		
		return playername +" rolled die - "+die_rolled+" new place - "+place.getPlacename()+ outcome;
	}

}
