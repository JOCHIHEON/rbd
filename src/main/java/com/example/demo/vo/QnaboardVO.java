package com.example.demo.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("qnaboardVO")
public class QnaboardVO {

	private Integer ui_no;
	private Integer qna_no;
	private String qna_content;
	private String qna_credat;
	private String qna_moddate;
	private List<QnacomentVO> qnacoments;
	private Paging paging;
}
