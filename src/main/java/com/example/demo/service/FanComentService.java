package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.FanComentVO;

public interface FanComentService {
	
	public Integer insertFanComent(FanComentVO fanComentVo);
	public Integer updateFanComent(FanComentVO fanComentVo);
	public Integer deleteFanComent(FanComentVO fanComentVo);
	
	public List<FanComentVO> fanComentList(Integer fan_no);
	
}
