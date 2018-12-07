package com.example.demo.repository;

import com.example.demo.vo.LikeUnLikeVO;

public interface LikeUnLikeRepository {
	public Integer insertliUnLi(LikeUnLikeVO liUnliVo);
	public Integer deleteliUnLi(LikeUnLikeVO liUnliVo);
	
	public Integer selectliUnLi(LikeUnLikeVO liUnliVo);
	public Integer insertCnt(LikeUnLikeVO liUnliVo);
	public Integer liUnliDe(LikeUnLikeVO liUnliVo);
}
