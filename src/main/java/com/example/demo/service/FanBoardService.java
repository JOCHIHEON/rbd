package com.example.demo.service;

import java.util.Map;

import com.example.demo.vo.FanBoardVO;

public interface FanBoardService {
	
	public Integer insertFan(FanBoardVO fanVo);
	public Integer updateFan(FanBoardVO fanVo);
	public Integer deleteFan(FanBoardVO fanVo);
	public FanBoardVO fanView(Integer fan_no, boolean check);
	public Map<String, Object> fanListView(FanBoardVO fanVo);
}
