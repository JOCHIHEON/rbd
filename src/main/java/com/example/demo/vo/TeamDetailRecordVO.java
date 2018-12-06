package com.example.demo.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("teamDeRecordVo")
public class TeamDetailRecordVO {
	
	@NotNull
	private Integer team_code;
	@NotNull
	private String season;
	private double teamde_pts;
	private double teamde_lostpts;
	private double teamde_assist;
	private double teamde_reb;
	private double teamde_stl;
	private double teamde_blk;
	private double teamde_fg;
	private double teamde_threept;
	private double teamde_ft;
	private double teamde_fgp;
	private double teamde_threeptp;
	private double teamde_ftp;
	private double teamde_to;
	
	private Paging paging;
	
}