package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.PlayerVO;

public interface PlayerService {
	
	public Integer insertPlayer(PlayerVO playerVo);
	public Integer updatePlayer(PlayerVO playerVo);
	public Integer deletePlayer(PlayerVO playerVo);
	
	public PlayerVO playerView(Integer player_no);
	public List<PlayerVO> playerListView(PlayerVO playerVo);
}
