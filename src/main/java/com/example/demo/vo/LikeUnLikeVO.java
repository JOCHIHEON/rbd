package com.example.demo.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("likeUnlikeVo")
public class LikeUnLikeVO {
	
	@NotNull
	private Integer like_type;
	@NotNull
	private Integer board_no;
	@NotNull
	private Integer ui_no;
	
	private Integer lik;
	private Integer unlik;
}
