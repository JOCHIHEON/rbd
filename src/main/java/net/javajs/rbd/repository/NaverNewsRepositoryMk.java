package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.collection.NaverKBLNews;

public interface NaverNewsRepositoryMk {
	
	public List<NaverKBLNews> findByPaging(Integer page);
}
