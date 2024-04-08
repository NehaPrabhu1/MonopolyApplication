package com.monopoly.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.monopoly.app.entities.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer>{
	
	@Modifying
	@Query(value = "update Place set boughtby = null", nativeQuery = true)
	void updateAllPlaces();

}
