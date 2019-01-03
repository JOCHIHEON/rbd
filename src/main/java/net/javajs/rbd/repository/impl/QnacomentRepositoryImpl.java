package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.QnacomentRepository;
import net.javajs.rbd.vo.QnacomentVO;

@Repository
public class QnacomentRepositoryImpl implements QnacomentRepository{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.QNACOMENT.insertQcoment",qnacomentVo);
	}

	@Override
	public Integer updateQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.QNACOMENT.updateQcoment", qnacomentVo);
	}

	@Override
	public Integer deleteQnacoment(QnacomentVO qnacomentVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.QNACOMENT.deleteQcoment",qnacomentVo);
	}

	@Override
	public List<QnacomentVO> qnaComentList(Integer qna_no) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.QNACOMENT.qnaComentList", qna_no);
	}

}
