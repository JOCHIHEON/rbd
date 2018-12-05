package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("testVo")
public class TestVO {
	private String tid;
	private Integer tage;
}
