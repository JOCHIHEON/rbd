package com.example.demo.config;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("paging")
public class Paging {
	private Integer totalData; //select count(*) from qnaboard 받아옴
	private Integer startViewNum;
	private Integer endViewNum;
	private Integer totalView;
	private Integer startBlock;
	private Integer endBlock;
	private Integer totalBlock;
	private Integer viewLength=15;
	private Integer blockLength=10;
	private Integer clickBlock;
	
	public void setPaging(Integer clickBlock,Integer totalData) {
		this.clickBlock = clickBlock;
		this.totalData = totalData;
		if(clickBlock==0) {
			clickBlock = 1;
		}
		totalView = (int)Math.ceil(totalData / viewLength);
		totalBlock =  (int)(Math.ceil(totalView / blockLength));
		
		startBlock = ((clickBlock -1) / blockLength) * blockLength + 1;
		endBlock = startBlock + blockLength - 1;
		if(totalView<=endBlock) {
			endBlock = totalView; 
		}
				
		startViewNum = (clickBlock - 1) * viewLength + 1 - 1; //mysql limit 0부터 시작
		endViewNum = clickBlock * viewLength;
	}
}
