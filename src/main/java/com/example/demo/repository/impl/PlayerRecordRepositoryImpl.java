package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.PlayerRecordRepository;
import com.example.demo.vo.PlayerRecordVO;

@Repository
public class PlayerRecordRepositoryImpl implements PlayerRecordRepository {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertPlayerRecord(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.PLAYERRECORD.insertPlayerRecord", playerRecordVo);
	}

	@Override
	public Integer updatePlayerRecord(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.PLAYERRECORD.updatePlayerRecord", playerRecordVo);
	}

	@Override
	public Integer deletePlayerRecord(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.PLAYERRECORD.deletePlayerRecord", playerRecordVo);
	}

	@Override
	public PlayerRecordVO playerRecordView(Integer player_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.PLAYERRECORD.playerRecordView", player_no);
	}

	@Override
	public List<PlayerRecordVO> playerRecordListView(PlayerRecordVO playerRecordVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.PLAYERRECORD.playerRecordListView", playerRecordVo);
	}

}
