package com.example.demo.repository.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.LikeUnLikeRepository;
import com.example.demo.vo.LikeUnLikeVO;

@Repository
public class LikeUnLikeRepositoryImpl implements LikeUnLikeRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;
	
	@Override
	public Integer insertliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.LIKEUNLIKE.insertLiUnLi",liUnliVo);
	}

	@Override
	public Integer deleteliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.LIKEUNLIKE.deleteLiUnLi", liUnliVo);
	}

	@Override
	public Integer selectliUnLi(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.LIKEUNLIKE.selectLiUnLi",liUnliVo);
	}

	@Override
	public Integer insertCnt(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.LIKEUNLIKE.liUnliUp", liUnliVo);
	}

	@Override
	public Integer liUnliDe(LikeUnLikeVO liUnliVo) {
		// TODO Auto-generated method stub
		return ss.delete("com.example.demo.LIKEUNLIKE.liUnliDe",liUnliVo);
	}

}
