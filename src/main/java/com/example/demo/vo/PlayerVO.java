package com.example.demo.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("playerVo")
public class PlayerVO {
	
	private Integer player_no;
	@NotNull
	private Integer team_code;
	@NotNull
	private String player_name;
	private String player_birth;
	private double player_height;
	@NotNull
	private String player_position;
	private Integer player_lookupcnt;
	private String player_background;
	private Integer player_number;
	
	private PlayerRecordVO playerRecord;
	private Paging paging;

}