package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("playerVo")
public class PlayerVO {
	private Integer player_no;
	private Integer team_code;
	private String player_name;
	private String player_birth;
	private double player_height;
	private String player_position;
	private Integer player_lookupcnt;
	private String player_background;
	private Integer player_number;
	
	private PlayerRecordVO playerRecord;
	private Paging paging;

}