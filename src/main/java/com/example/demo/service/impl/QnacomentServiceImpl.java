package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.QnacomentRepository;
import com.example.demo.service.QnacomentService;
import com.example.demo.vo.QnacomentVO;

@Service
public class QnacomentServiceImpl implements QnacomentService{
	
	@Autowired
	private QnacomentRepository qcomentRepo;
	@Override
	public Integer insertQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		if(qnacomentVo.getUi_no() == null && qnacomentVo.getAd_no() == null) {
			return -1;
		} //둘 다 null이면 등록한 사람이 없으는거니까 리턴
		return qcomentRepo.insertQnacoment(qnacomentVo);
	}

	@Override
	public Integer updateQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return qcomentRepo.updateQnacoment(qnacomentVo);
	}

	@Override
	public Integer deleteQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return qcomentRepo.deleteQnacoment(qnacomentVo);
	}

}
