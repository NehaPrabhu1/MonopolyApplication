package com.monopoly.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monopoly.app.entities.Place;
import com.monopoly.app.entities.Player;
import com.monopoly.app.repositories.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@Transactional
	public void resetPlace() {
		placeRepository.updateAllPlaces();
	}
	
	public Place findPlace(int id) {
		return placeRepository.findById(id).get();
	}
	
	public void savePlace(Place place) {
		placeRepository.save(place);
	}

}
