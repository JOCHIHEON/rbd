package com.example.demo.service;

import org.bson.types.ObjectId;

import com.example.demo.collection.Record;

public interface WLRecordsService {
	public Record getWLRecords(ObjectId _id);
}
