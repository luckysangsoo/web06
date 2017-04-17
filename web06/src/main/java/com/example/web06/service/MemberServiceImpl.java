package com.example.web06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web06.model.dao.MemberDAO;
import com.example.web06.model.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	/*@Inject*/
	@Autowired
	MemberDAO memberDao;
	
	@Override
	public void insert(MemberVO vo) {
		memberDao.insert(vo);

	}

	@Override
	public List<MemberVO> listAll() {
		
		return memberDao.listAll();
	}

	@Override
	public void delete(String userid) {
		memberDao.delete(userid);
		
	}

	@Override
	public MemberVO read(String userid) {
		return memberDao.read(userid);
	}

	@Override
	public void update(MemberVO vo) {
		memberDao.update(vo);
	}
}
