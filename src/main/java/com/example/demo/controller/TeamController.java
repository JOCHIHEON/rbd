package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TeamService;
import com.example.demo.vo.TeamInfoVO;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@PostMapping("/team")
	public Integer insertTeam(@Valid @RequestBody TeamInfoVO teamVo) {
		return teamService.insertTeam(teamVo);
	}
	
	@PutMapping("/team")
	public Integer updateTeam(@Valid @RequestBody TeamInfoVO teamVo) {
		return teamService.updateTeam(teamVo);
	}
	
	@DeleteMapping("/team")
	public Integer deleteTeam(@RequestBody TeamInfoVO teamVo) {
		return teamService.deleteTeam(teamVo);
	}
	
	@GetMapping("/team/{team_code}")
	public TeamInfoVO teamView(@PathVariable Integer team_code) {
		return teamService.teamView(team_code);
	}
	
	@GetMapping("/team")
	public List<TeamInfoVO> teamListView(@ModelAttribute TeamInfoVO teamVo){
		return teamService.teamListView(teamVo);
	}
}
