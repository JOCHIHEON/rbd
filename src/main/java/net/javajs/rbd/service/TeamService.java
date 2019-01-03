package net.javajs.rbd.service;

import java.util.List;

import net.javajs.rbd.collection.Team;

public interface TeamService {
	public Team teamView(String team_code);
	public Team teamDetailView(String team_code, String season);
	public List<Team> teamListView(Team teamVo);
	
}
