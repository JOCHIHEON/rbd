package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.TeamDetailRecordRepository;
import com.example.demo.vo.TeamDetailRecordVO;

@Repository
public class TeamDetailRecordRepositoryImpl implements TeamDetailRecordRepository {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	@Override
	public Integer insertTeamDeRecord(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.TEAMDETAIL.insertTeamDeRecord",teamDeRecordVo);
	}

	@Override
	public Integer updateTeamDeRecord(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.TEAMDETAIL.updateTeamDeRecord", teamDeRecordVo);
	}

	@Override
	public Integer deleteTeamDeRecord(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.TEAMDETAIL.deleteTeamDeRecord", teamDeRecordVo);
	}

	@Override
	public TeamDetailRecordVO teamDeRecordView(Integer team_code) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.TEAMDETAIL.teamDeRecordView", team_code);
	}

	@Override
	public List<TeamDetailRecordVO> teamDeRecordListView(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.TEAMDETAIL.teamDeRecordListView", teamDeRecordVo);
	}

}
