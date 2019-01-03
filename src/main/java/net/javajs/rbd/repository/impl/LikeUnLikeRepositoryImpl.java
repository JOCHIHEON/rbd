package net.javajs.rbd.repository.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.LikeUnLikeRepository;
import net.javajs.rbd.vo.LikeUnLikeVO;

@Repository
public class LikeUnLikeRepositoryImpl implements LikeUnLikeRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.LIKEUNLIKE.insertLiUnLi",liUnliVo);
	}

	@Override
	public Integer deleteliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.LIKEUNLIKE.deleteLiUnLi", liUnliVo);
	}

	@Override
	public Integer selectliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.LIKEUNLIKE.selectLiUnLi",liUnliVo);
	}

	@Override
	public Integer insertCnt(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.LIKEUNLIKE.liUnliUp", liUnliVo);
	}

	@Override
	public Integer liUnliDe(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.delete("net.javajs.rbd.LIKEUNLIKE.liUnliDe",liUnliVo);
	}

}
