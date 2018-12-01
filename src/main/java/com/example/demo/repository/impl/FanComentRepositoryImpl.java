package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.FanComentRepository;
import com.example.demo.vo.FanComentVO;

@Repository
public class FanComentRepositoryImpl implements FanComentRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	
	@Override
	public Integer insertFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.FANCOMENT.insertFanComent", fanComentVo);
	}

	@Override
	public Integer updateFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.FANCOMENT.updateFanComent",fanComentVo);
	}

	@Override
	public Integer deleteFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.FANCOMENT.deleteFanComent", fanComentVo);
	}

	@Override
	public List<FanComentVO> fanComentList(Integer fan_no) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.FANCOMENT.fanComentList",fan_no);
	}

}
