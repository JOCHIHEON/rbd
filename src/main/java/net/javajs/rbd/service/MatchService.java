package net.javajs.rbd.service;

import java.util.List;

import net.javajs.rbd.vo.MatchInfoVO;

public interface MatchService {
	
	public Integer insertMatch(MatchInfoVO matchVo);
	public Integer updateMatch(MatchInfoVO matchVo);
	public Integer deleteMatch(MatchInfoVO matchVo);
	
	public MatchInfoVO matchView(Integer match_no);
	public List<MatchInfoVO> matchListView(MatchInfoVO matchVo);
	
}
