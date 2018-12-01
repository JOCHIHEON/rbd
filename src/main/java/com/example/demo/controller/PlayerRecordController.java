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

import com.example.demo.service.PlayerRecordService;
import com.example.demo.vo.PlayerRecordVO;

@RestController
public class PlayerRecordController {

	@Autowired
	private PlayerRecordService playerRecordService;
	
	@PostMapping("/precord")
	public Integer insertPlayerRecord(@RequestBody PlayerRecordVO playerRecordVo) {
		return playerRecordService.insertPlayerRecord(playerRecordVo);
	}
	
	@PutMapping("/precord")
	public Integer updatePlayerRecord(@RequestBody PlayerRecordVO playerRecordVo) {
		return playerRecordService.updatePlayerRecord(playerRecordVo);
	}
	
	@DeleteMapping("/precord")
	public Integer deletePlayerRecord(@RequestBody PlayerRecordVO playerRecordVo) {
		return playerRecordService.deletePlayerRecord(playerRecordVo);
	}
	
	@GetMapping("/precord/{player_no}")
	public PlayerRecordVO playerRecordView(@PathVariable Integer player_no) {
		return playerRecordService.playerRecordView(player_no);
	}
	
	@GetMapping("/precord")
	public List<PlayerRecordVO> playerRecordListView(@ModelAttribute PlayerRecordVO playerRecordVo){
		return playerRecordService.playerRecordListView(playerRecordVo);
	}
}
