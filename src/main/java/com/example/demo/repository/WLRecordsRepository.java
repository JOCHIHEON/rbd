package com.example.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.vo.Record;

public interface WLRecordsRepository extends MongoRepository<Record, String> {

	public Record findBy_id(ObjectId _id);
}
