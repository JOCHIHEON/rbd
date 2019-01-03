package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.MatchRepository;
import net.javajs.rbd.vo.MatchInfoVO;

@Repository
public class MatchRepositoryImpl implements MatchRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.MATCH.insertMatch", matchVo);
	}

	@Override
	public Integer updateMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.MATCH.updateMatch", matchVo);
	}

	@Override
	public Integer deleteMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.MATCH.deleteMatch", matchVo);
	}

	@Override
	public MatchInfoVO matchView(Integer match_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.MATCH.matchView",match_no);
	}

	@Override
	public List<MatchInfoVO> matchListView(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.MATCH.matchListView", matchVo);
	}

}
