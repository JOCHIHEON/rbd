package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.MatchRepository;
import com.example.demo.vo.MatchInfoVO;

@Repository
public class MatchRepositoryImpl implements MatchRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.MATCH.insertMatch", matchVo);
	}

	@Override
	public Integer updateMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.MATCH.updateMatch", matchVo);
	}

	@Override
	public Integer deleteMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.MATCH.deleteMatch", matchVo);
	}

	@Override
	public MatchInfoVO matchView(Integer match_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.MATCH.matchView",match_no);
	}

	@Override
	public List<MatchInfoVO> matchListView(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.MATCH.matchListView", matchVo);
	}

}
