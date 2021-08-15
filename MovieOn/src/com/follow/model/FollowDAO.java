package com.follow.model;

import java.util.List;

public interface FollowDAO {
	
	void create(FollowVO follow);
	
	void update(FollowVO follow);
	
	void deleteByID(int followID);

	FollowVO findByID(int followID);
	
	List<FollowVO> findAll();

	List<FollowVO>findBySource(int userID);
	
	List<FollowVO>findByTarget(int userID);

}
