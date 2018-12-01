package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("teaminfoVo")
public class TeamInfoVO {

	private Integer team_code;
	private String team_name;
	private String team_owner;
	private String team_leader;
	private String team_director;
	private String team_coach;
	private String team_address;
	private String team_company;
}