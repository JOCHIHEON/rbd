package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FanBoardRepository;
import com.example.demo.service.FanBoardService;
import com.example.demo.service.FanComentService;
import com.example.demo.vo.FanBoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FanBoardServiceImpl implements FanBoardService {

	@Autowired
	private FanBoardRepository fanBoardRepo;

	@Autowired
	private FanComentService fanComentService;

	@Override
	public Integer insertFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return fanBoardRepo.insertFan(fanVo);
	}

	@Override
	public Integer updateFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return fanBoardRepo.updateFan(fanVo);
	}

	@Override
	public Integer deleteFan(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		return fanBoardRepo.deleteFan(fanVo);
	}

	@Override
	public FanBoardVO fanView(Integer fan_no) {
		// TODO Auto-generated method stub
		FanBoardVO fanVo = fanBoardRepo.fanView(fan_no);
		if (fanVo != null) {
			fanVo.setFanComents(fanComentService.fanComentList(fan_no));
		}
		return fanVo;
	}

	@Override
	public List<FanBoardVO> fanListView(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		fanVo.getPaging().setPaging(fanVo.getPaging().getClickBlock(), fanBoardRepo.countFan());
		return fanBoardRepo.fanListView(fanVo);
	}

}
