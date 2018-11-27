package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.QnaboardRepository;
import com.example.demo.vo.QnaboardVO;

@Repository
public class QnaboardRepositoryImpl implements QnaboardRepository{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.QNABOARD.insertQnA",qnaVo);
	}

	@Override
	public Integer updateQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.QNABOARD.updateQnA",qnaVo);
	}

	@Override
	public QnaboardVO selectQnA(Integer qna_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.QNABOARD.selectQnA",qna_no);
	}

	@Override
	public List<QnaboardVO> selectListQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.QNABOARD.selectListQnA",qnaVo);
	}

	@Override
	public Integer deleteQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.QNABOARD.deleteQnA", qnaVo);
	}

	@Override
	public Integer selectQnACount() {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.QNABOARD.selectQnACount");
	}

}
