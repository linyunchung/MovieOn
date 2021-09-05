package com.member.model;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Part;

import com.movie.model.MovieVO;

public class MemberService {
	
	private MemberDAO_interface dao;
	
	public MemberService () {
		dao = new MemberJDBCDAO();
	}	
	public MemberVO addMember(String username, String email, String password) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setUsername(username);
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		dao.insert(memberVO);
		
		return memberVO;
	}
	
	
	public MemberVO updateProfile(byte[] profilepic, String name, String gender, java.sql.Date birthday, String address, String education, String occupation, String ig, String fb, String twt, Integer userid, String username) {
		
		MemberVO memberVO = new MemberVO();
	
		memberVO.setProfilepic(profilepic);
		memberVO.setName(name);
		memberVO.setGender(gender);
		memberVO.setBirthday(birthday);
		memberVO.setAddress(address);
		memberVO.setEducation(education);
		memberVO.setOccupation(occupation);
		memberVO.setIg(ig);
		memberVO.setFb(fb);
		memberVO.setTwt(twt);
		memberVO.setUserid(userid);
		memberVO.setUsername(username);
		dao.updateProfile(memberVO);
		
		return memberVO;
	}
	
	
	public MemberVO updateMember(Integer userid, String username, String email, String password,
			String address, Timestamp joindate, String mobile, byte[] profilepic, String name, String gender,
			java.sql.Date birthday, String education, String occupation, String ig, String fb, String twt) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setUserid(userid);
		memberVO.setUsername(username);
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
		dao.update(memberVO);
		
		return memberVO;
	}
	
	public void deleteMember(Integer userid) {
		dao.delete(userid);
	}
	
	public MemberVO getOneMember(Integer userid) {
		return dao.findByPrimaryKey(userid);
	}
	
	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
	public List<MemberVO> getNewest(){
		List<MemberVO> list = dao.getAll();
		list.sort(Comparator.comparing(MemberVO::getUserid).reversed());
		return list;
	}
	
	public MemberVO login(String email, String password) {

		return dao.login(email, password);
	}

	public MemberVO changepwd(String password, Integer userid) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setPassword(password);
		memberVO.setUserid(userid);
		dao.changepwd(memberVO);
		
		return memberVO;
	}
	
	public MemberVO getEmail(String email) {
		return dao.findByEmail(email);
	}
}
