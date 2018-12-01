package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PlayerRecordRepository;
import com.example.demo.service.PlayerRecordService;
import com.example.demo.vo.PlayerRecordVO;

@Service
public class PlayerRecordServiceImpl implements PlayerRecordService {
	
	@Autowired
	private PlayerRecordRepository playerRecordRepo;
	@Override
	public Integer insertPlayerRecord(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return playerRecordRepo.insertPlayerRecord(playerRecordVo);
	}

	@Override
	public Integer updatePlayerRecord(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return playerRecordRepo.updatePlayerRecord(playerRecordVo);
	}

	@Override
	public Integer deletePlayerRecord(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return playerRecordRepo.deletePlayerRecord(playerRecordVo);
	}

	@Override
	public PlayerRecordVO playerRecordView(Integer player_no) {
		// TODO Auto-generated method stub
		return playerRecordRepo.playerRecordView(player_no);
	}

	@Override
	public List<PlayerRecordVO> playerRecordListView(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return playerRecordRepo.playerRecordListView(playerRecordVo);
	}

}
