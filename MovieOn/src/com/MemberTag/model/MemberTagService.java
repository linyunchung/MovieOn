package com.MemberTag.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class MemberTagService {

	private MemberTagDAO_interface dao;

	public MemberTagService() {
		dao = new MemberTagJDBCDAO();
	}

	public MemberTagVO addMemberTag( Integer userId, Integer genreId) {

		MemberTagVO memberTagVO = new MemberTagVO();

		memberTagVO.setUserId(userId);
		memberTagVO.setGenreId(genreId);
		dao.insert(memberTagVO);

		return memberTagVO;
	}

	public MemberTagVO updateMemberTag(Integer tagId, Integer userId, Integer genreId) {

		MemberTagVO memberTagVO = new MemberTagVO();

		memberTagVO.setTagId(tagId);
		memberTagVO.setUserId(userId);
		memberTagVO.setGenreId(genreId);
		dao.update(memberTagVO);

		return memberTagVO;
	}

	public void deleteMemberTag(Integer tagId) {
		dao.delete(tagId);
	}
	
	public MemberTagVO getOneMemberTag(Integer tagId) {
		return dao.findByPrimaryKey(tagId);
	}

	public List<MemberTagVO> getAll() {
		return dao.getAll();
	}
}
