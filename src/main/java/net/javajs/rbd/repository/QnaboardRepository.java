package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.QnaboardVO;

public interface QnaboardRepository {

	public Integer insertQnA(QnaboardVO qnaVo);
	public Integer updateQnA(QnaboardVO qnaVo);
	public QnaboardVO selectQnA(Integer qna_no);
	public List<QnaboardVO> selectListQnA(QnaboardVO qnaVo); //관리자 화면(답글 남김 안남김으로 나눔?), 개인 qna 리스트 뷰 + paging
	public Integer deleteQnA(QnaboardVO qnaVo);
	public Integer selectQnACount();
}
