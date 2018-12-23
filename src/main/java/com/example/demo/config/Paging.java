package com.example.demo.config;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("paging")
public class Paging {
	private Integer totalData; // 총 게시물 수, select count(*) from board
	private Integer startViewNum;
	private Integer endViewNum;
	private Integer totalView;
	private Integer startBlock;
	private Integer endBlock;
	private Integer totalBlock;
	private Integer viewLength=15;  // 1 페이지에 보여질 게시물 수
	private Integer blockLength=10; // 1 페이지에 보여질 블락 수
	private Integer clickBlock;
	
	public void setPaging(Integer clickBlock,Integer totalData) {
		this.clickBlock = clickBlock;
		this.totalData = totalData;
		if(clickBlock==0) {
			clickBlock = 1;
		}
		totalView = (int)(Math.ceil((double)totalData / viewLength));
		totalBlock =  (int)(Math.ceil((double)totalView / blockLength));
		
		startBlock = ((clickBlock -1) / blockLength) * blockLength + 1;
		endBlock = startBlock + blockLength - 1;
		if(endBlock>totalView) {
			endBlock = totalView; 
		}
				
		startViewNum = (clickBlock - 1) * viewLength + 1 - 1; //mysql limit 0부터 시작
		endViewNum = clickBlock * viewLength;
	}
}
