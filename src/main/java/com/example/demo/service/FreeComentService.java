package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.FreeComentVO;

public interface FreeComentService {
	
	public Integer insertFreeComent(FreeComentVO freeComentVo);
	public Integer updateFreeComent(FreeComentVO freeComentVo);
	public Integer deleteFreeComent(FreeComentVO freeComentVo);
	
	public List<FreeComentVO> freeComentList(Integer fre_no);
}
