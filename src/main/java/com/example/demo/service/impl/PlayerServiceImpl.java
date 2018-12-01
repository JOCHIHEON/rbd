package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import com.example.demo.vo.PlayerVO;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepo;
	@Override
	public Integer insertPlayer(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return playerRepo.insertPlayer(playerVo);
	}

	@Override
	public Integer updatePlayer(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return playerRepo.updatePlayer(playerVo);
	}

	@Override
	public Integer deletePlayer(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return playerRepo.deletePlayer(playerVo);
	}

	@Override
	public PlayerVO playerView(Integer player_no) {
		// TODO Auto-generated method stub
		return playerRepo.playerView(player_no);
	}

	@Override
	public List<PlayerVO> playerListView(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return playerRepo.playerListView(playerVo);
	}

}
