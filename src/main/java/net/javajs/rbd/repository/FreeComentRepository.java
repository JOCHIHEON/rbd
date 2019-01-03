package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.FreeComentVO;

public interface FreeComentRepository {
	
	public Integer insertFreeComent(FreeComentVO freeComentVo);
	public Integer updateFreeComent(FreeComentVO freeComentVo);
	public Integer deleteFreeComent(FreeComentVO freeComentVo);
	
	public List<FreeComentVO> freeComentList(Integer fre_no);
}
