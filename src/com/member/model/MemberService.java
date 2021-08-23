package com.member.model;

import java.util.List;

public class MemberService {
	
	private MemberDAO_interface dao;
	
	public MemberService () {
		dao = new MemberJDBCDAO();
	}
	
	public MemberVO addMember(String username, String email, String password,
			String address, String mobile, String joindate, String profilepic, String name, String gender,
			String birthday, String education, String occupation, String ig, String fb, String twt, Integer admin) {
		
		MemberVO memberVO = new MemberVO();
		
//		memberVO.setUserid(userid);
		memberVO.setName(name);
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setAddress(address);
		memberVO.setMobile(mobile);
		memberVO.setJoindate(joindate);
		memberVO.setProfilepic(profilepic);
		memberVO.setName(name);
		memberVO.setGender(gender);
		memberVO.setBirthday(birthday);
		memberVO.setEducation(education);
		memberVO.setOccupation(occupation);
		memberVO.setIg(ig);
		memberVO.setFb(fb);
		memberVO.setTwt(twt);
		memberVO.setAdmin(admin);
		dao.insert(memberVO);
		
		return memberVO;
	}
	
	public MemberVO updateMember(Integer userid, String username, String email, String password,
			String address, String mobile, String joindate, String profilepic, String name, String gender,
			String birthday, String education, String occupation, String ig, String fb, String twt, Integer admin) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setUserid(userid);
		memberVO.setName(name);
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setAddress(address);
		memberVO.setMobile(mobile);
		memberVO.setJoindate(joindate);
		memberVO.setProfilepic(profilepic);
		memberVO.setName(name);
		memberVO.setGender(gender);
		memberVO.setBirthday(birthday);
		memberVO.setEducation(education);
		memberVO.setOccupation(occupation);
		memberVO.setIg(ig);
		memberVO.setFb(fb);
		memberVO.setTwt(twt);
		memberVO.setAdmin(admin);
		dao.update(memberVO);
		
		return memberVO;
	}
	
	public void deleteMember(Integer userid) {
		dao.delete(userid);
	}
	
	public MemberVO getoneMember(Integer userid) {
		return dao.findByPrimaryKey(userid);
	}
	
	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
	
	
	
	
}
