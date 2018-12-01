package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.PlayerRecordVO;

public interface PlayerRecordRepository {
	public Integer insertPlayerRecord(PlayerRecordVO playerRecordVo);
	public Integer updatePlayerRecord(PlayerRecordVO playerRecordVo);
	public Integer deletePlayerRecord(PlayerRecordVO playerRecordVo);
	
	public PlayerRecordVO playerRecordView(Integer player_no);
	public List<PlayerRecordVO> playerRecordListView(PlayerRecordVO playerRecordVo);
}
