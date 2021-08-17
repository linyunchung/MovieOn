package com.follow.model;

import java.util.List;

public class FollowService {
	
	private FollowDAOImpl dao;
	
	
	public FollowService() {
		dao = new FollowDAOImpl();
	}
	
	//newFollow calls FollowDAOImpl.create();
	public FollowVO newFollow(Integer sourceID, Integer targetID){
		FollowVO followvo = new FollowVO();
		followvo.setSourceID(sourceID);
		followvo.setTargetID(targetID);
		
		dao.create(followvo);
		return followvo;
	}
	
	public FollowVO updateFollow(Integer sourceID, Integer targetID) {
		FollowVO followvo = new FollowVO();
		followvo.setSourceID(sourceID);
		followvo.setTargetID(targetID);
		
		dao.update(followvo);
		return followvo;
	}
	
	public void deleteFollow(int followID) {
		dao.deleteByID(followID);
	}
	
	public FollowVO findOneFollow(int followID) {
		return dao.findByID(followID);
	}
	
	public List<FollowVO> findAll() {
		return dao.findAll();
	}	
	
	public List<FollowVO> findFollowers(int userID) {
		return dao.findByTarget(userID);
	}
	
	public int followerCount(int userID) {
		return findFollowers(userID).size();
	}
	
	public List<FollowVO> findFollowing(int userID) {
		return dao.findBySource(userID);
	}
	
	public int followingCount(int userID) {
		return findFollowing(userID).size();
	}
	
}
