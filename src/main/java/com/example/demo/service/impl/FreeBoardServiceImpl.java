package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FreeBoardRepository;
import com.example.demo.repository.FreeComentRepository;
import com.example.demo.service.FreeBoardService;
import com.example.demo.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardRepository freeboardRepo;
	@Autowired
	private FreeComentRepository freeComentRepo;
	
	@Override
	public Integer insertFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return freeboardRepo.insertFree(freeVo);
	}

	@Override
	public Integer updateFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return freeboardRepo.updateFree(freeVo);
	}

	@Override
	public Integer deleteFree(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		return freeboardRepo.deleteFree(freeVo);
	}

	@Override
	public FreeBoardVO freeView(Integer fre_no) {
		// TODO Auto-generated method stub
		FreeBoardVO freeVo =  freeboardRepo.freeView(fre_no);
		freeVo.setFreeComents(freeComentRepo.freeComentList(fre_no));
		return freeVo;
	}

	@Override
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo) {
		// TODO Auto-generated method stub
		freeVo.getPaging().setPaging(freeVo.getPaging().getClickBlock(), freeboardRepo.selectFreeCount());
		return freeboardRepo.freeListView(freeVo);
	}

}
