package net.javajs.rbd.repository;

import net.javajs.rbd.vo.LikeUnLikeVO;

public interface LikeUnLikeRepository {
	public Integer insertliUnLi(LikeUnLikeVO liUnliVo);
	public Integer deleteliUnLi(LikeUnLikeVO liUnliVo);
	
	public Integer selectliUnLi(LikeUnLikeVO liUnliVo);
	public Integer insertCnt(LikeUnLikeVO liUnliVo);
	public Integer liUnliDe(LikeUnLikeVO liUnliVo);
}
