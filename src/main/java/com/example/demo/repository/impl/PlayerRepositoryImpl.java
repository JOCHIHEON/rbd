package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.PlayerRepository;
import com.example.demo.vo.PlayerVO;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertPlayer(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.PLAYER.insertPlayer", playerVo);
	}

	@Override
	public Integer updatePlayer(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.PLAYER.updatePlayer",playerVo);
	}

	@Override
	public Integer deletePlayer(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.PLAYER.deletePlayer",playerVo);
	}

	@Override
	public PlayerVO playerView(Integer player_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.PLAYER.playerView",player_no);
	}

	@Override
	public List<PlayerVO> playerListView(PlayerVO playerVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.PLAYER.playerListView",playerVo);
	}

}
