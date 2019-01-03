package net.javajs.rbd.service;

import java.util.List;

import net.javajs.rbd.vo.QnaboardVO;

public interface QnaboardService {

	public Integer insertQnA(QnaboardVO qnaVo);
	public Integer updateQnA(QnaboardVO qnaVo);
	public QnaboardVO selectQnA(Integer qna_no);
	public List<QnaboardVO> selectListQnA(QnaboardVO qnaVo);
	public Integer deleteQnA(QnaboardVO qnaVo);
}
