package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.QnacomentVO;

public interface QnacomentService {
	
	public Integer insertQnacoment(QnacomentVO qnacomentVo);
	public Integer updateQnacoment(QnacomentVO qnacomentVo);
	public Integer deleteQnacoment(QnacomentVO qnacomentVo); //qna_no, qnaco_no use
	
	public List<QnacomentVO> qnaComentList(Integer qna_no);
}
