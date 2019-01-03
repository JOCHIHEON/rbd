package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.FreeComentRepository;
import net.javajs.rbd.vo.FreeComentVO;
@Repository
public class FreeComentRepositoryImpl implements FreeComentRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.FREECOMENT.insertFreeComent",freeComentVo);
	}

	@Override
	public Integer updateFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.FREECOMENT.updateFreeComent", freeComentVo);
	}

	@Override
	public Integer deleteFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.FREECOMENT.deleteFreeComent", freeComentVo);
	}

	@Override
	public List<FreeComentVO> freeComentList(Integer fre_no) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.FREECOMENT.freeComentList", fre_no);
	}

}
