package com.example.demo.vo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("wlrecords")
public class WLRecords {

	private ObjectId _id;
	private Integer num;
	private String hname;
	private String aname;
	private Integer hscore;
	private Integer ascore;
	
}
