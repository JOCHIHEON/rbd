package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TeamRepository;
import com.example.demo.service.TeamService;
import com.example.demo.vo.TeamInfoVO;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepo;
	@Override
	public Integer insertTeam(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return teamRepo.insertTeam(teamVo);
	}

	@Override
	public Integer updateTeam(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return teamRepo.updateTeam(teamVo);
	}

	@Override
	public Integer deleteTeam(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return teamRepo.deleteTeam(teamVo);
	}

	@Override
	public TeamInfoVO teamView(Integer team_code) {
		// TODO Auto-generated method stub
		return teamRepo.teamView(team_code);
	}

	@Override
	public List<TeamInfoVO> teamListView(TeamInfoVO teamVo) {
		// TODO Auto-generated method stub
		return teamRepo.teamListView(teamVo);
	}

}
