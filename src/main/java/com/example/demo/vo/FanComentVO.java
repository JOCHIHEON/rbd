package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("fanComentVo")
public class FanComentVO {
	
	private Integer fanco_no;
	private String fanco_content;
	private Integer fanco_like;
	private Integer fanco_unlike;
	private String fanco_credat;
	private String fanco_moddat;
	private Integer ui_no;
	private Integer fan_no;
}
