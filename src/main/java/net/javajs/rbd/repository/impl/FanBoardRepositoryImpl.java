package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.FanBoardRepository;
import net.javajs.rbd.vo.FanBoardVO;
@Repository
public class FanBoardRepositoryImpl implements FanBoardRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	@Override
	public Integer insertFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.FANBOARD.insertFan", fanVo);
	}

	@Override
	public Integer updateFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.FANBOARD.updateFan",fanVo);
	}

	@Override
	public Integer deleteFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.FANBOARD.deleteFan", fanVo);
	}

	@Override
	public FanBoardVO fanView(Integer fan_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.FANBOARD.fanView",fan_no);
	}

	@Override
	public List<FanBoardVO> fanListView(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.FANBOARD.fanListView", fanVo);
	}

	@Override
	public Integer countFan() {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.FANBOARD.countFan");
	}

	@Override
	public Integer insertlookup(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.FANBOARD.insertlookupFan", fanVo);
	}

	@Override
	public Integer deleteLike(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.FANBOARD.deleteLike", fanVo);
	}

}
