package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("userVO")
public class UserInfoVO {
	private Integer ui_no;
	private String ui_id;
	private String ui_name;
	private String ui_pwd;
	private String ui_nick;
	private Integer ui_support;
	private String ui_eamil;
	private String ui_tell;
	private Integer ui_active;
}

