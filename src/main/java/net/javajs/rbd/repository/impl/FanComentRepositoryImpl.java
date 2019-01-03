package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.FanComentRepository;
import net.javajs.rbd.vo.FanComentVO;

@Repository
public class FanComentRepositoryImpl implements FanComentRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	
	@Override
	public Integer insertFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.FANCOMENT.insertFanComent", fanComentVo);
	}

	@Override
	public Integer updateFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.FANCOMENT.updateFanComent",fanComentVo);
	}

	@Override
	public Integer deleteFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.FANCOMENT.deleteFanComent", fanComentVo);
	}

	@Override
	public List<FanComentVO> fanComentList(Integer fan_no) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.FANCOMENT.fanComentList",fan_no);
	}

}
