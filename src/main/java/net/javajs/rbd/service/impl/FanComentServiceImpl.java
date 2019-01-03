package net.javajs.rbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javajs.rbd.repository.FanComentRepository;
import net.javajs.rbd.service.FanComentService;
import net.javajs.rbd.vo.FanComentVO;

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
