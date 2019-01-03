package net.javajs.rbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javajs.rbd.repository.FreeComentRepository;
import net.javajs.rbd.service.FreeComentService;
import net.javajs.rbd.vo.FreeComentVO;

@Service
public class FreeComentServiceImpl implements FreeComentService {
	
	@Autowired
	private FreeComentRepository freeComentRepo;
	
	@Override
	public Integer insertFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return freeComentRepo.insertFreeComent(freeComentVo);
	}

	@Override
	public Integer updateFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return freeComentRepo.updateFreeComent(freeComentVo);
	}

	@Override
	public Integer deleteFreeComent(FreeComentVO freeComentVo) {
		// TODO Auto-generated method stub
		return freeComentRepo.deleteFreeComent(freeComentVo);
	}

	@Override
	public List<FreeComentVO> freeComentList(Integer fre_no) {
		// TODO Auto-generated method stub
		return freeComentRepo.freeComentList(fre_no);
	}

}
