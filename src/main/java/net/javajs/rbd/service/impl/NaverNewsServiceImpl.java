package net.javajs.rbd.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javajs.rbd.config.Paging;
import net.javajs.rbd.repository.NaverNewsRepository;
import net.javajs.rbd.repository.NaverNewsRepositoryMk;
import net.javajs.rbd.service.NaverNewsService;

@Service
public class NaverNewsServiceImpl implements NaverNewsService {

	@Autowired
	private NaverNewsRepositoryMk newsRepoMk;
	
	@Autowired
	private NaverNewsRepository newsRepo;
	@Override
	public Map<String, Object> newsList(Integer page) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		Paging paging = new Paging();
		paging.setPaging(page, (int)newsRepo.count());
		map.put("paging", paging);
		map.put("newsList", newsRepoMk.findByPaging(page));
		return map;
	}

}
