package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("playerrecordVo")
public class PlayerRecordVO {

	private Integer player_no;
	private Integer team_code;
	private String player_min; //출장시간 time
	private double player_pts;
	private double player_ast;
	private double player_red;
	private double plalyer_stl;
	private double player_blk;
	private double player_fg;
	private double player_ft;
	private double player_threept;
	private double player_fgp;
	private double player_threeptp;
	private double player_to;
	
	private Paging paging;
	
}