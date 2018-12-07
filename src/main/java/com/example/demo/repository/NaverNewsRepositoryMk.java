package com.example.demo.repository;

import java.util.List;

import com.example.demo.collection.NaverKBLNews;

public interface NaverNewsRepositoryMk {
	
	public List<NaverKBLNews> findByPaging(Integer page);
}
