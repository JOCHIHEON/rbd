package com.example.demo.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import com.example.demo.config.Paging;

import lombok.Data;

@Data
@Alias("qnaboardVO")
public class QnaboardVO {

	@NotNull
	private Integer ui_no;
	private Integer qna_no;
	@NotNull
	@Length(max = 200)
	private String qna_title;
	@NotNull
	@Length(max = 3000)
	private String qna_content;
	private String qna_credat;
	private String qna_moddate;
	private List<QnacomentVO> qnacoments;
	private Paging paging;
}
