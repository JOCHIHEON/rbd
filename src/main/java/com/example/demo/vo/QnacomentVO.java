package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("qnacomentVO")
public class QnacomentVO{
	private Integer ad_no;
	private Integer ui_no;
	private Integer qna_no;
	private Integer qnaco_no;
	private String qnaco_content;
	private String qnaco_credat;
	private String qnaco_moddate;
}
