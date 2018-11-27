package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.QnaboardRepository;
import com.example.demo.service.QnaboardService;
import com.example.demo.vo.QnaboardVO;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QnaboardServiceImpl implements QnaboardService{
		
	@Autowired
	private QnaboardRepository qnaRepo;
	@Override
	public Integer insertQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return qnaRepo.insertQnA(qnaVo);
	}

	@Override
	public Integer updateQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return qnaRepo.updateQnA(qnaVo);
	}

	@Override
	public QnaboardVO selectQnA(Integer qna_no) {
		// TODO Auto-generated method stub
		return qnaRepo.selectQnA(qna_no);
	}

	@Override
	public List<QnaboardVO> selectListQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		qnaVo.getPaging().setPaging(qnaVo.getPaging().getClickBlock(), qnaRepo.selectQnACount());
		log.debug(qnaVo.getPaging().toString());
		return qnaRepo.selectListQnA(qnaVo);
	}

	@Override
	public Integer deleteQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return qnaRepo.deleteQnA(qnaVo);
	}

}
