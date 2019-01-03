package net.javajs.rbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.javajs.rbd.collection.Team;
import net.javajs.rbd.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@GetMapping("/team/{team_code}")
	public Team teamView(@PathVariable String team_code) {
		return teamService.teamView(team_code);
	}

	@GetMapping("/team/{team_code}/{season}")
	public Team teamDetailView(@PathVariable String team_code, @PathVariable String season) {
		return teamService.teamDetailView(team_code,season);
	}
	
	@GetMapping("/team")
	public List<Team> teamListView(@ModelAttribute Team teamVo){
		return teamService.teamListView(teamVo);
	}
}
