package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LikeUnLikeRepository;
import com.example.demo.service.LikeUnLikeService;
import com.example.demo.vo.LikeUnLikeVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LikeUnLikeServiceImpl implements LikeUnLikeService {

	@Autowired
	private LikeUnLikeRepository liRepo;

	@Override
	public Integer insertliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		if ((liUnliVo.getLik() == null && liUnliVo.getUnlik() == null) || liRepo.selectliUnLi(liUnliVo) != 0) {
			return -1;
		}
		int suc = liRepo.insertliUnLi(liUnliVo);
		if (suc == 1) {
			liRepo.insertCnt(liUnliVo);
		}
		return suc;
	}

	@Override
	public Integer deleteliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		if (liRepo.selectliUnLi(liUnliVo) == 0) {
			return -1;
		}
		int suc = liRepo.deleteliUnLi(liUnliVo);
		if (suc == 1) {
			liRepo.insertCnt(liUnliVo);
		}
		return suc;
	}

}
