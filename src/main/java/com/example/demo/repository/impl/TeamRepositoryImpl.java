package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.TeamRepository;
import com.example.demo.vo.TeamInfoVO;

@Repository
public class TeamRepositoryImpl implements TeamRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	@Override
	public Integer insertTeam(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.TEAM.insertTeam",teamVo);
	}

	@Override
	public Integer updateTeam(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.TEAM.updateTeam", teamVo);
	}

	@Override
	public Integer deleteTeam(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.TEAM.deleteTeam", teamVo.getTeam_code());
	}

	@Override
	public TeamInfoVO teamView(Integer team_code) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.TEAM.teamView", team_code);
	}

	@Override
	public List<TeamInfoVO> teamListView(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.TEAM.teamListView",teamVo);
	}

}
