package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.QnaboardVO;

public interface QnaboardService {

	public Integer insertQnA(QnaboardVO qnaVo);
	public Integer updateQnA(QnaboardVO qnaVo);
	public QnaboardVO selectQnA(Integer qna_no);
	public List<QnaboardVO> selectListQnA(QnaboardVO qnaVo);
	public Integer deleteQnA(QnaboardVO qnaVo);
}
