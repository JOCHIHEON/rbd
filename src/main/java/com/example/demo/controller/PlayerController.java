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

import com.example.demo.service.PlayerService;
import com.example.demo.vo.PlayerVO;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@PostMapping("/player")
	public Integer insertPlayer(@Valid @RequestBody PlayerVO playerVo) {
		return playerService.insertPlayer(playerVo);
	}
	
	@PutMapping("/player")
	public Integer updatePlayer(@Valid @RequestBody PlayerVO playerVo) {
		return playerService.updatePlayer(playerVo);
	}
	
	@DeleteMapping("/player")
	public Integer deletePlayer(@RequestBody PlayerVO playerVo) {
		return playerService.deletePlayer(playerVo);
	}
	
	@GetMapping("/player/{player_no}")
	public PlayerVO playerView(@PathVariable Integer player_no) {
		return playerService.playerView(player_no);
	}
	
	@GetMapping("/player")
	public List<PlayerVO> playerListView(@ModelAttribute PlayerVO playerVo){
		return playerService.playerListView(playerVo);
		
	}
} 
