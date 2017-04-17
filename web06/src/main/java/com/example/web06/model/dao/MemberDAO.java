package com.example.web06.model.dao;

import java.util.List;

import com.example.web06.model.dto.MemberVO;


public interface MemberDAO {
	public void insert(MemberVO vo);
	public List<MemberVO> listAll();
	public void delete(String userid);
	public MemberVO read(String userid);
	public void update(MemberVO vo);

}
