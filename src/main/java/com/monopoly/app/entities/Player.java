package com.monopoly.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
	
	@Id
	private String playername;
	
	private int amount;
	
	@OneToOne
	@JoinColumn(name="placeid",insertable = false, updatable = false)
	private Place place;
	
	private int placeid;

}
