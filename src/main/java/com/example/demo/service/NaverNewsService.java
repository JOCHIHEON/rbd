package com.example.demo.service;

import java.util.List;

import com.example.demo.collection.NaverKBLNews;

public interface NaverNewsService {
	public List<NaverKBLNews> newsList(Integer page);
}
