package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MatchRepository;
import com.example.demo.service.MatchService;
import com.example.demo.vo.MatchInfoVO;

@Service
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	private MatchRepository matchRepo;
	@Override
	public Integer insertMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return matchRepo.insertMatch(matchVo);
	}

	@Override
	public Integer updateMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return matchRepo.updateMatch(matchVo);
	}

	@Override
	public Integer deleteMatch(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return matchRepo.deleteMatch(matchVo);
	}

	@Override
	public MatchInfoVO matchView(Integer match_no) {
		// TODO Auto-generated method stub
		return matchRepo.matchView(match_no);
	}

	@Override
	public List<MatchInfoVO> matchListView(MatchInfoVO matchVo) {
		// TODO Auto-generated method stub
		return matchRepo.matchListView(matchVo);
	}

}
