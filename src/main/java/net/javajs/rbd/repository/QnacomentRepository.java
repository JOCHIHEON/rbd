package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.QnacomentVO;

public interface QnacomentRepository {
	
	public Integer insertQnacoment(QnacomentVO qnacomentVo);
	public Integer updateQnacoment(QnacomentVO qnacomentVo);
	public Integer deleteQnacoment(QnacomentVO qnacomentVo); //qna_no, qnaco_no use
	
	public List<QnacomentVO> qnaComentList(Integer qna_no);
}
