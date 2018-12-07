package com.example.demo.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import com.example.demo.config.Paging;

import lombok.Data;

@Data
@Alias("matchVo")
public class MatchInfoVO {

	private Integer match_no;
	@NotNull
	private String match_day; //날짜 : 경기날짜
	@NotNull
	private Integer match_home;
	@NotNull
	private Integer match_away;
	@NotNull
	private Integer match_hscore;
	@NotNull
	private Integer match_ascore;
	@NotNull
	private String match_time; //시간
	@NotNull
	private String match_stadium;
	
	private Paging paging;
	
}