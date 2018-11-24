package com.example.demo.service;

import org.bson.types.ObjectId;

import com.example.demo.vo.WLRecords;

public interface WLRecordsService {
	public WLRecords getWLRecords(ObjectId _id);
}
