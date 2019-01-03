package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.QnaboardRepository;
import net.javajs.rbd.vo.QnaboardVO;

@Repository
public class QnaboardRepositoryImpl implements QnaboardRepository{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.QNABOARD.insertQnA",qnaVo);
	}

	@Override
	public Integer updateQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.QNABOARD.updateQnA",qnaVo);
	}

	@Override
	public QnaboardVO selectQnA(Integer qna_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.QNABOARD.selectQnA",qna_no);
	}

	@Override
	public List<QnaboardVO> selectListQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.QNABOARD.selectListQnA",qnaVo);
	}

	@Override
	public Integer deleteQnA(QnaboardVO qnaVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.QNABOARD.deleteQnA", qnaVo);
	}

	@Override
	public Integer selectQnACount() {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.QNABOARD.selectQnACount");
	}

}
