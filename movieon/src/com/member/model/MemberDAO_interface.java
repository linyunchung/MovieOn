package com.member.model;

import java.util.List;

public interface MemberDAO_interface {
    public void insert(MemberVO memberVO); 
    public void update(MemberVO memberVO);
    public void delete(Integer userid);
    public MemberVO findByPrimaryKey(Integer userid);
    public List<MemberVO> getAll();
	public MemberVO login(String email, String password);
	public void updateProfile(MemberVO memberVO);
	public void changepwd(MemberVO memberVO);
	public MemberVO findByEmail(String email);
}