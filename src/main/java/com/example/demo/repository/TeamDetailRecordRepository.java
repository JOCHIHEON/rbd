package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.TeamDetailRecordVO;

public interface TeamDetailRecordRepository {
	public Integer insertTeamDeRecord(TeamDetailRecordVO teamDeRecordVo);
	public Integer updateTeamDeRecord(TeamDetailRecordVO teamDeRecordVo);
	public Integer deleteTeamDeRecord(TeamDetailRecordVO teamDeRecordVo);
	
	public TeamDetailRecordVO teamDeRecordView(Integer team_code);
	public List<TeamDetailRecordVO> teamDeRecordListView(TeamDetailRecordVO teamDeRecordVo);

}
