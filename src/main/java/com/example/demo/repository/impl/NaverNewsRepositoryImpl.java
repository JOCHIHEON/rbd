package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.collection.NaverKBLNews;
import com.example.demo.repository.NaverNewsRepositoryMk;

import lombok.extern.slf4j.Slf4j;

@Repository//("nickname") -> autowrite 에서 Qualifier로 바로보논건데..똥멍충
@Slf4j
public class NaverNewsRepositoryImpl implements NaverNewsRepositoryMk {

	@Autowired
	private MongoTemplate mt;
	
	@Override
	public List<NaverKBLNews> findByPaging(Integer page) {
		log.info("mt=>{}",mt);
		Query query = new Query().with(new Sort(Sort.Direction.DESC, "date"));
		query.skip((page-1)*15);
		query.limit(15);
		List<NaverKBLNews> l = mt.find(query, NaverKBLNews.class);
		return l;
	}
	

}
