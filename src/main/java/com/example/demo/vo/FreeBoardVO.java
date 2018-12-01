package com.example.demo.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("freeboardVO")
public class FreeBoardVO {

	private Integer ui_no;
	private Integer fre_no;
	private String fre_title;
	private String fre_content;
	private String fre_credat; //등록일 Date type String type?
	private String fre_moddat; //수정일
	private Integer fre_lookupcnt; //조회수
	private Integer fre_like; //좋아요
	private Integer fre_unlike; //싫어요
	private List<FreeComentVO> freeComents;
	private Paging paging;
}
