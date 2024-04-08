package com.monopoly.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gameid;
	
	@ManyToOne
	@JoinColumn(name="playername",insertable = false, updatable = false)
	private Player player;
	
	private String playername;
	
	@ManyToOne
	@JoinColumn(name="placeid",insertable = false, updatable = false)
	private Place place;
	
	private Integer placeid;
	
	private boolean buy;
	
	private boolean rent;
	

}
