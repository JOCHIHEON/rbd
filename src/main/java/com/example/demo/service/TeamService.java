package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.TeamInfoVO;

public interface TeamService {
	public Integer insertTeam(TeamInfoVO teamVo);
	public Integer updateTeam(TeamInfoVO teamVo);
	public Integer deleteTeam(TeamInfoVO teamVo);
	
	public TeamInfoVO teamView(Integer team_code);
	public List<TeamInfoVO> teamListView(TeamInfoVO teamVo);
	
}