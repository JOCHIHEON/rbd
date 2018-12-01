package com.example.demo.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("fanBoardVo")
public class FanBoardVO {
	
	private Integer fan_no;
	private String fan_title;
	private String fan_content;
	private String fan_credat;
	private String fan_moddat;
	private Integer lookupcnt;
	private Integer fan_lookupcnt;
	private Integer fan_like;
	private Integer fan_unlike;
	private Integer ui_no;
	private Paging paging;
	private List<FanComentVO> fanComents;
}
