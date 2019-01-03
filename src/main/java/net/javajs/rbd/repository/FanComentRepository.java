package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.FanComentVO;

public interface FanComentRepository {
	
	public Integer insertFanComent(FanComentVO fanComentVo);
	public Integer updateFanComent(FanComentVO fanComentVo);
	public Integer deleteFanComent(FanComentVO fanComentVo);
	
	public List<FanComentVO> fanComentList(Integer fan_no);
}
