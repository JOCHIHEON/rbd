package net.javajs.rbd.service;

import java.util.List;

import net.javajs.rbd.vo.FreeBoardVO;

public interface FreeBoardService {

	public Integer insertFree(FreeBoardVO freeVo);
	public Integer updateFree(FreeBoardVO freeVo);
	public Integer deleteFree(FreeBoardVO freeVo); //fre_no를 조회하고 그 row의 ui_no가 같으면 del가능하게
	public FreeBoardVO freeView(Integer fre_no, boolean check);
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo);
}
