package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TeamDetailRecordRepository;
import com.example.demo.service.TeamDetailRecordService;
import com.example.demo.vo.TeamDetailRecordVO;

@Service
public class TeamDetailRecordServiceImpl implements TeamDetailRecordService{
	
	@Autowired
	private TeamDetailRecordRepository teamDeRepo;
	@Override
	public Integer insertTeamDeRecord(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return teamDeRepo.insertTeamDeRecord(teamDeRecordVo);
	}

	@Override
	public Integer updateTeamDeRecord(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return teamDeRepo.updateTeamDeRecord(teamDeRecordVo);
	}

	@Override
	public Integer deleteTeamDeRecord(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return teamDeRepo.deleteTeamDeRecord(teamDeRecordVo);
	}

	@Override
	public TeamDetailRecordVO teamDeRecordView(Integer team_code) {
		// TODO Auto-generated method stub
		return teamDeRepo.teamDeRecordView(team_code);
	}

	@Override
	public List<TeamDetailRecordVO> teamDeRecordListView(TeamDetailRecordVO teamDeRecordVo) {
		// TODO Auto-generated method stub
		return teamDeRepo.teamDeRecordListView(teamDeRecordVo);
	}

}
