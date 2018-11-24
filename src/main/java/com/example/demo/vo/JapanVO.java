package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("jvo")
public class JapanVO {
	private Integer jpnum;
	private String jpname;
	private String jpdesc;
}
