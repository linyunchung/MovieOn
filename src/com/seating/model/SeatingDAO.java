package com.seating.model;

public interface SeatingDAO {

	//create
	void newScreening(SeatingVO seating);

	//update
	void book(String screenID, String selected);
	
	//Query
	SeatingVO findByID(String screenID);
	
}
