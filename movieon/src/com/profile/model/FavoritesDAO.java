package com.profile.model;

import java.util.List;

public interface FavoritesDAO {
	void add(int userID);
	void update(FavoritesVO favoritesVO);
	List<Integer> findByUserID(int userID);
	
}
