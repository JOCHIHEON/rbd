package com.example.demo.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("jvo")
public class JapanVO {
	
	private Integer jpnum;
	private String jpname;
	private String jpdesc;
	private List<TestVO> tlist;
	
}
