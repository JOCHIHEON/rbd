package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.PlayerRecordVO;

public interface PlayerRecordService {
	
	public Integer insertPlayerRecord(PlayerRecordVO playerRecordVo);
	public Integer updatePlayerRecord(PlayerRecordVO playerRecordVo);
	public Integer deletePlayerRecord(PlayerRecordVO playerRecordVo);
	
	public PlayerRecordVO playerRecordView(Integer player_no);
	public List<PlayerRecordVO> playerRecordListView(PlayerRecordVO playerRecordVo);
	
}
