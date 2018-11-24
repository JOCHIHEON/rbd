package com.example.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.vo.WLRecords;

public interface WLRecordsRepository extends MongoRepository<WLRecords, String> {

	public WLRecords findBy_id(ObjectId _id);
}
