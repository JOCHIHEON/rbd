package com.example.demo.repository;

import java.util.Map;

import com.example.demo.vo.FanBoardVO;

public interface FanBoardRepository {
	public Integer insertFan(FanBoardVO fanVo);
	public Integer updateFan(FanBoardVO fanVo);
	public Integer deleteFan(FanBoardVO fanVo);
	public FanBoardVO fanView(Integer fan_no);
	public Map<String, Object> fanListView(FanBoardVO fanVo);
	
	public Integer countFan();
	public Integer insertlookup(FanBoardVO fanVo);
	public Integer deleteLike(FanBoardVO fanVo);
	
}
