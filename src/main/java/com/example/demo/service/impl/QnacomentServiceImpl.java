package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.QnacomentRepository;
import com.example.demo.service.QnacomentService;
import com.example.demo.vo.QnacomentVO;

@Service
public class QnacomentServiceImpl implements QnacomentService{
	
	@Autowired
	private QnacomentRepository qcomentRepo;
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public Integer insertQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		if(qnacomentVo.getAd_no() != null && adminCheck(qnacomentVo.getAd_no())) {
			return 0;
		}
		return qcomentRepo.insertQnacoment(qnacomentVo);
	}

	@Override
	public Integer updateQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		if(qnacomentVo.getAd_no() != null && adminCheck(qnacomentVo.getAd_no())) {
			return -1;
		}
		return qcomentRepo.updateQnacoment(qnacomentVo);
	}

	@Override
	public Integer deleteQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		if(qnacomentVo.getAd_no() != null && adminCheck(qnacomentVo.getAd_no())) {
			return -1;
		}
		return qcomentRepo.deleteQnacoment(qnacomentVo);
	}
	
	@Override
	public List<QnacomentVO> qnaComentList(Integer qna_no) {
		// TODO Auto-generated method stub
		return qcomentRepo.qnaComentList(qna_no);
	}
	
	private Boolean adminCheck(Integer ad_no) {
		return adminRepo.selectAdminView(ad_no).getAd_id() != null?false:true;
	}


}
