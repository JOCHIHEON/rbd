package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.FanBoardVO;

public interface FanBoardService {
	
	public Integer insertFan(FanBoardVO fanVo);
	public Integer updateFan(FanBoardVO fanVo);
	public Integer deleteFan(FanBoardVO fanVo);
	public FanBoardVO fanView(Integer fan_no, boolean check);
	public List<FanBoardVO> fanListView(FanBoardVO fanVo);
}
