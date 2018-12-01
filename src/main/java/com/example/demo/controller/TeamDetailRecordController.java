package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TeamDetailRecordService;
import com.example.demo.vo.TeamDetailRecordVO;

@RestController
public class TeamDetailRecordController {
	
	@Autowired
	private TeamDetailRecordService teamDeService;
	
	@PostMapping("/detail")
	public Integer insertTeamDeRecord(@RequestBody TeamDetailRecordVO teamDeRecordVo) {
		return teamDeService.insertTeamDeRecord(teamDeRecordVo);
	}
	
	@PutMapping("/detail")
	public Integer updateTeamDeRecord(@RequestBody TeamDetailRecordVO teamDeRecordVo) {
		return teamDeService.updateTeamDeRecord(teamDeRecordVo);
	}
	
	@DeleteMapping("/detail")
	public Integer deleteTeamDeRecord(@RequestBody TeamDetailRecordVO teamDeRecordVo) {
		return teamDeService.deleteTeamDeRecord(teamDeRecordVo);
	}
	
	@GetMapping("/detail/{team_code}")
	public TeamDetailRecordVO teamDeRecordView(@PathVariable Integer team_code) {
		return teamDeService.teamDeRecordView(team_code);
	}
	
	@GetMapping("/datail")
	public List<TeamDetailRecordVO> teamDeRecordListView(@ModelAttribute TeamDetailRecordVO teamDeRecordVo){
		return teamDeService.teamDeRecordListView(teamDeRecordVo);
	}
}
