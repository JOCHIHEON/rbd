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

import com.example.demo.collection.Player;
import com.example.demo.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/player/{team_code}/{player_no}")
	public Player playerView(@PathVariable String team_code, @PathVariable String player_no) {
		return playerService.playerView(team_code, player_no);
	}
	
	@GetMapping("/player")
	public List<Player> playerListView(@ModelAttribute Player playerVo){
		return playerService.playerListView(playerVo);
		
	}
	
	@GetMapping("/player/{team_code}")
	public List<Player> playerListView(@ModelAttribute Player playerVo, @PathVariable String team_code){
		return playerService.teamPlayerList(team_code);
		
	}
} 
