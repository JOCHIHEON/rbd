package net.javajs.rbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javajs.rbd.repository.FreeBoardRepository;
import net.javajs.rbd.repository.FreeComentRepository;
import net.javajs.rbd.service.FreeBoardService;
import net.javajs.rbd.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardRepository freeboardRepo;
	@Autowired
	private FreeComentRepository freeComentRepo;
	
	@Override
	public Integer insertFree(FreeBoardVO freeVo) {
		return freeboardRepo.insertFree(freeVo);
	}

	@Override
	public Integer updateFree(FreeBoardVO freeVo) {
		return freeboardRepo.updateFree(freeVo);
	}

	@Override
	public Integer deleteFree(FreeBoardVO freeVo) {
		return freeboardRepo.deleteFree(freeVo);
	}

	@Override
	public FreeBoardVO freeView(Integer fre_no,boolean check) {
		FreeBoardVO freeVo =  freeboardRepo.freeView(fre_no);
		if(check) {
			freeboardRepo.insertlookup(freeVo);
			freeVo =  freeboardRepo.freeView(fre_no);
		}
		freeVo.setFreeComents(freeComentRepo.freeComentList(fre_no));
		return freeVo;
	}

	@Override
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo) {
		freeVo.getPaging().setPaging(freeVo.getPaging().getClickBlock(), freeboardRepo.selectFreeCount());
		return freeboardRepo.freeListView(freeVo);
	}

}
