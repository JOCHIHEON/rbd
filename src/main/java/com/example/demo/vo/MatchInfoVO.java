package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("matchVo")
public class MatchInfoVO {

	private Integer match_no;
	private String match_day; //날짜 : 경기날짜
	private Integer match_home;
	private Integer match_away;
	private Integer match_hscore;
	private Integer match_ascore;
	private String match_time; //시간
	private String match_stadium;
	
	private Paging paging;
	
}