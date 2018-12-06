package com.example.demo.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("teaminfoVo")
public class TeamInfoVO {

	@NotNull
	private Integer team_code;
	@NotNull
	private String team_name;
	@NotNull
	private String team_owner;
	@NotNull
	private String team_leader;
	@NotNull
	private String team_director;
	@NotNull
	private String team_coach;
	@NotNull
	private String team_address;
	@NotNull
	private String team_company;
}