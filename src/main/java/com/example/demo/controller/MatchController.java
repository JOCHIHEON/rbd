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

import com.example.demo.service.MatchService;
import com.example.demo.vo.MatchInfoVO;

@RestController
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	@PostMapping("/match")
	public Integer insertMatch(@Valid @RequestBody MatchInfoVO matchVo) {
		return matchService.insertMatch(matchVo);
	}
	
	@PutMapping("/match")
	public Integer updateMatch(@Valid @RequestBody MatchInfoVO matchVo) {
		return matchService.updateMatch(matchVo);
	}
	
	@DeleteMapping("/match")
	public Integer deleteMatch(@RequestBody MatchInfoVO matchVo) {
		return matchService.deleteMatch(matchVo);
	}
	
	@GetMapping("/match/{match_no}")
	public MatchInfoVO matchView(@PathVariable Integer match_no) {
		return matchService.matchView(match_no);
	}
	
	@GetMapping("/match")
	public List<MatchInfoVO> matchListView(@ModelAttribute MatchInfoVO matchVo){
		return matchService.matchListView(matchVo);
	}
}
