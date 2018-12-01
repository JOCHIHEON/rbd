package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.PlayerVO;

public interface PlayerRepository {
	public Integer insertPlayer(PlayerVO playerVo);
	public Integer updatePlayer(PlayerVO playerVo);
	public Integer deletePlayer(PlayerVO playerVo);
	
	public PlayerVO playerView(Integer player_no);
	public List<PlayerVO> playerListView(PlayerVO playerVo);
}
