package com.example.demo.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.QnacomentRepository;
import com.example.demo.vo.QnacomentVO;

@Repository
public class QnacomentRepositoryImpl implements QnacomentRepository{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.QNACOMENT.insertQcoment",qnacomentVo);
	}

	@Override
	public Integer updateQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.QNACOMENT.updateQcoment", qnacomentVo);
	}

	@Override
	public Integer deleteQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.QNACOMENT.deleteQcoment",qnacomentVo);
	}

}
