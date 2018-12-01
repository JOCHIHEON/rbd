package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.FreeBoardRepository;
import com.example.demo.vo.FreeBoardVO;

@Repository
public class FreeBoardRepositoryImpl implements FreeBoardRepository {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.FREEBOARD.insertFree",freeVo);
	}

	@Override
	public Integer updateFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.FREEBOARD.updateFree",freeVo);
	}

	@Override
	public Integer deleteFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.FREEBOARD.deleteFree", freeVo);
	}

	@Override
	public FreeBoardVO freeView(Integer fre_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.FREEBOARD.freeView",fre_no);
	}

	@Override
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.FREEBOARD.freeListView",freeVo);
	}

	@Override
	public Integer selectFreeCount() {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.FREEBOARD.selectFreeCount");
	}

}
