package com.example.demo.vo;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("qnacomentVO")
public class QnacomentVO{
	private Integer ad_no;
	private Integer ui_no;
	@NotNull
	private Integer qna_no;
	private Integer qnaco_no;
	@NotNull
	@Length(max=200)
	private String qnaco_content;
	private String qnaco_credat;
	private String qnaco_moddate;
	private Paging paging;
}
