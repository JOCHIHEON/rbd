package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.collection.NaverKBLNews;

public interface NaverNewsRepository extends MongoRepository<NaverKBLNews, String>{

}
