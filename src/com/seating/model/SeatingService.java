package com.seating.model;

public class SeatingService {
	private SeatingDAOImpl dao;

	public SeatingService() {
		dao = new SeatingDAOImpl();
	}
	
	public String getUnavailable(String screenID) {
		return dao.findByID(screenID).getUnavailable();
	}
	
	public void newBooking(String screenID, String selected) {
		dao.book(screenID, selected);
	}
	
	
}
