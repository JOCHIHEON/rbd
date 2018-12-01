package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FanComentRepository;
import com.example.demo.service.FanComentService;
import com.example.demo.vo.FanComentVO;

@Service
public class FanComentServiceImpl implements FanComentService {
	
	@Autowired
	private FanComentRepository fanComentRepo;
	@Override
	public Integer insertFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return fanComentRepo.insertFanComent(fanComentVo);
	}

	@Override
	public Integer updateFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return fanComentRepo.updateFanComent(fanComentVo);
	}

	@Override
	public Integer deleteFanComent(FanComentVO fanComentVo) {
		// TODO Auto-generated method stub
		return fanComentRepo.deleteFanComent(fanComentVo);
	}

	@Override
	public List<FanComentVO> fanComentList(Integer fan_no) {
		// TODO Auto-generated method stub
		return fanComentRepo.fanComentList(fan_no);
	}

}
