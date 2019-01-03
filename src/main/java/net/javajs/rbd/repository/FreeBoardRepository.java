package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.FreeBoardVO;

public interface FreeBoardRepository {
	public Integer insertFree(FreeBoardVO freeVo);
	public Integer updateFree(FreeBoardVO freeVo);
	public Integer deleteFree(FreeBoardVO freeVo);
	public FreeBoardVO freeView(Integer fre_no);
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo);
	
	public Integer selectFreeCount();
	public Integer insertlookup(FreeBoardVO freeVo);
	public Integer deleteLike(FreeBoardVO freeVo);
}
