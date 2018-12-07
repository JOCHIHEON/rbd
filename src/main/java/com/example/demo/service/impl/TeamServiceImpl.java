package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.collection.Team;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.TeamService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepo;


	@Override
	public Team teamView(String team_code) {
		// TODO Auto-generated method stub
		return teamRepo.findByTeam(team_code);
	}

	@Override
	public Team teamDetailView(String team_code, String season) {
		// TODO Auto-generated method stub	
		return teamRepo.findByTeamDetail(team_code,season);
	}

	@Override
	public List<Team> teamListView(Team teamVo) {
		// TODO Auto-generated method stub
		//return teamRepo.findByTeam();
		return teamRepo.findByTeamList();
	}

}
