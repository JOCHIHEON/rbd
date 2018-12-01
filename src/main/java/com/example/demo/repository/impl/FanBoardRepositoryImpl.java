package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.FanBoardRepository;
import com.example.demo.vo.FanBoardVO;
@Repository
public class FanBoardRepositoryImpl implements FanBoardRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	@Override
	public Integer insertFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.FANBOARD.insertFan", fanVo);
	}

	@Override
	public Integer updateFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.FANBOARD.updateFan",fanVo);
	}

	@Override
	public Integer deleteFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.FANBOARD.deleteFan", fanVo);
	}

	@Override
	public FanBoardVO fanView(Integer fan_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.FANBOARD.fanView",fan_no);
	}

	@Override
	public List<FanBoardVO> fanListView(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.FANBOARD.fanListView", fanVo);
	}

	@Override
	public Integer countFan() {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.FANBOARD.countFan");
	}

}
