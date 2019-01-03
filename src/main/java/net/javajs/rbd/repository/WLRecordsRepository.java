package net.javajs.rbd.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import net.javajs.rbd.collection.Record;

public interface WLRecordsRepository extends MongoRepository<Record, String> {

	public Record findBy_id(ObjectId _id);
	
	@Query(value="{ 'date' : { $gt: '20181012' } }") //2018 - 2019 시즌
	public List<Record> findByDate();
	//"{'team_name' : {$regex : ?0, $options: 'i'}}"
}

