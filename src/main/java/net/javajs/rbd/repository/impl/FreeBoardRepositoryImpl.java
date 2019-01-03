package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.FreeBoardRepository;
import net.javajs.rbd.vo.FreeBoardVO;

@Repository
public class FreeBoardRepositoryImpl implements FreeBoardRepository {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.FREEBOARD.insertFree",freeVo);
	}

	@Override
	public Integer updateFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.FREEBOARD.updateFree",freeVo);
	}

	@Override
	public Integer deleteFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.FREEBOARD.deleteFree", freeVo);
	}

	@Override
	public FreeBoardVO freeView(Integer fre_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.FREEBOARD.freeView",fre_no);
	}

	@Override
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.FREEBOARD.freeListView",freeVo);
	}

	@Override
	public Integer selectFreeCount() {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.FREEBOARD.selectFreeCount");
	}

	@Override
	public Integer insertlookup(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.FREEBOARD.insertlookupFree",freeVo);
	}

	@Override
	public Integer deleteLike(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.FREEBOARD.deleteLike", freeVo);
	}

}
