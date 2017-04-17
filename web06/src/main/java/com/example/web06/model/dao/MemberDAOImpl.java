package com.example.web06.model.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.web06.model.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	/*@Inject*/
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(MemberVO vo) {
		System.out.println(vo.toString());
		sqlSession.insert("member.insert", vo);
		
	}

	@Override
	public List<MemberVO> listAll() {
		return sqlSession.selectList("member.list");
	}

	@Override
	public void delete(String userid) {
		sqlSession.delete("member.delete",userid);
	}

	@Override
	public MemberVO read(String userid) {
		return sqlSession.selectOne("member.view", userid);
	}

	@Override
	public void update(MemberVO vo) {
		sqlSession.update("member.update", vo);
	}
}
