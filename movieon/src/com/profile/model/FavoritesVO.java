package com.profile.model;

import java.io.Serializable;

public class FavoritesVO implements Serializable{

	private int favoritesID;
	private int userID;
	private int favorites1;
	private int favorites2;
	private int favorites3;
	private int favorites4;
	
	public FavoritesVO() {
		super();
	}
	
	public FavoritesVO(int favoritesID, int userID, int favorites1, int favorites2, int favorites3, int favorites4) {
		super();
		this.favoritesID = favoritesID;
		this.userID = userID;
		this.favorites1 = favorites1;
		this.favorites2 = favorites2;
		this.favorites3 = favorites3;
		this.favorites4 = favorites4;
	}

	@Override
	public String toString() {
		return "FavoritesVO [favoritesID=" + favoritesID + ", userID=" + userID + ", favorites1=" + favorites1
				+ ", favorites2=" + favorites2 + ", favorites3=" + favorites3 + ", favorites4=" + favorites4 + "]";
	}
	
	public int getFavoritesID() {
		return favoritesID;
	}
	public void setFavoritesID(int favoritesID) {
		this.favoritesID = favoritesID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getFavorites1() {
		return favorites1;
	}
	public void setFavorites1(int favorites1) {
		this.favorites1 = favorites1;
	}
	public int getFavorites2() {
		return favorites2;
	}
	public void setFavorites2(int favorites2) {
		this.favorites2 = favorites2;
	}
	public int getFavorites3() {
		return favorites3;
	}
	public void setFavorites3(int favorites3) {
		this.favorites3 = favorites3;
	}
	public int getFavorites4() {
		return favorites4;
	}
	public void setFavorites4(int favorites4) {
		this.favorites4 = favorites4;
	}
}
