package net.javajs.rbd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.javajs.rbd.collection.NaverKBLNews;

public interface NaverNewsRepository extends MongoRepository<NaverKBLNews, String>{

}
