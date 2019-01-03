package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.FanBoardVO;

public interface FanBoardRepository {
	public Integer insertFan(FanBoardVO fanVo);
	public Integer updateFan(FanBoardVO fanVo);
	public Integer deleteFan(FanBoardVO fanVo);
	public FanBoardVO fanView(Integer fan_no);
	public List<FanBoardVO> fanListView(FanBoardVO fanVo);
	
	public Integer countFan();
	public Integer insertlookup(FanBoardVO fanVo);
	public Integer deleteLike(FanBoardVO fanVo);
	
}
