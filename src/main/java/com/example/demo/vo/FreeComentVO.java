package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import com.example.demo.collection.Paging;

import lombok.Data;

@Data
@Alias("freecomentVO")
public class FreeComentVO {
	
	private Integer freco_no;
	private String freco_content;
	private Integer freco_like;
	private Integer freco_unlike;
	private String freco_credat;
	private String freco_moddat;
	private Integer fre_no;
	private Integer ui_no; //nick?name?id?찾아야해
	private Paging paging;
}
