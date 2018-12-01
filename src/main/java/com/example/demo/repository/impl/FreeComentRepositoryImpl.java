package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.FreeComentRepository;
import com.example.demo.vo.FreeComentVO;
@Repository
public class FreeComentRepositoryImpl implements FreeComentRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.FREECOMENT.insertFreeComent",freeComentVo);
	}

	@Override
	public Integer updateFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.FREECOMENT.updateFreeComent", freeComentVo);
	}

	@Override
	public Integer deleteFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.FREECOMENT.deleteFreeComent", freeComentVo);
	}

	@Override
	public List<FreeComentVO> freeComentList(Integer fre_no) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.FREECOMENT.freeComentList", fre_no);
	}

}
