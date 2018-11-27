package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("admininfoVo")
public class AdminInfoVO {

	private Integer ad_no;
	private String ad_id;
	private String ad_name;
	private String ad_pwd;
	private String ad_nick;
	private String ad_email;
	private String ad_tell;
	private Integer ad_active;
	
}
