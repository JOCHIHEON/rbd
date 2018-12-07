package com.example.demo.vo;


import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import com.example.demo.config.Paging;

import lombok.Data;

@Data
@Alias("userVO")
public class UserInfoVO {
	
	private Integer ui_no;
	@NotNull
	@Length(min=5, max=20)
	private String ui_id;
	@NotNull
	@Length(min=2, max=20)
	private String ui_name;
	@NotNull
	@Length(min=8, max=20)
	private String ui_pwd;
	@NotNull
	@Length(min=5, max=20)
	private String ui_nick;
	@NotNull
	@Length(min=0, max=100)
	private String ui_support;
	@NotNull
	private String ui_email;
	@NotNull
	private String ui_tell;
	private Integer ui_active;
	private Paging paging;
}

