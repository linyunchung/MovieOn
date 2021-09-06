package com.profile.model;

import java.util.List;

import com.follow.model.FollowDAOImpl;

public class FavoritesService {
	private FavoritesDAOImpl dao;
	
	public FavoritesService() {
		dao = new FavoritesDAOImpl();
	}
	
	public void createFavorite(int userID){
		dao.add(userID);
	}
	
	public void updateFavoriteMovies(FavoritesVO favoritesVO) {
		dao.update(favoritesVO);
	}
	
	public List<Integer>getFavoriteMovieIDs(int userID){
		return dao.findByUserID(userID);
	}
}
