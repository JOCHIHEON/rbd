package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

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
		int suc = fanBoardRepo.deleteFan(fanVo);
		if( suc == 1 ) {
			suc += fanBoardRepo.deleteLike(fanVo);
		}
		return suc;
	}

	@Override
	public FanBoardVO fanView(Integer fan_no,boolean check) {
		// TODO Auto-generated method stub
		FanBoardVO fanVo = fanBoardRepo.fanView(fan_no);
		if(check) {
			fanBoardRepo.insertlookup(fanVo);
			fanVo = fanBoardRepo.fanView(fan_no);
		}
		fanVo.setFanComents(fanComentService.fanComentList(fan_no));
		return fanVo;
	}

	@Override
	public Map<String, Object> fanListView(FanBoardVO fanVo) {
		// TODO Auto-generated method stub
		fanVo.getPaging().setPaging(fanVo.getPaging().getClickBlock(), fanBoardRepo.countFan());
		return fanBoardRepo.fanListView(fanVo);
	}

}
