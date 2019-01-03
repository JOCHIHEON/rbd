package net.javajs.rbd.service;

import java.util.List;

import net.javajs.rbd.vo.FanComentVO;

public interface FanComentService {
	
	public Integer insertFanComent(FanComentVO fanComentVo);
	public Integer updateFanComent(FanComentVO fanComentVo);
	public Integer deleteFanComent(FanComentVO fanComentVo);
	
	public List<FanComentVO> fanComentList(Integer fan_no);
	
}
