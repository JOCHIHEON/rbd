package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.JapanRepository;
import com.example.demo.vo.JapanVO;

@Repository
public class JapanRepositoryImpl implements JapanRepository{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public List<JapanVO> selectJapanList(JapanVO jvo) {
		return ss.selectList("com.example.demo.JAPAN.selectJapan",jvo);
	}

	@Override
	public int insertJapan(JapanVO jvo) {
		return ss.insert("com.example.demo.JAPAN.insertJapan",jvo);
	}

	@Override
	public int updateJapan(JapanVO jvo) {
		return ss.update("com.example.demo.JAPAN.updateJapan",jvo);
	}
}
