package net.javajs.rbd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.javajs.rbd.service.NaverNewsService;

@RestController
public class NaverNewsController {
	
	@Autowired
	private NaverNewsService newsService;
	
	@GetMapping("/news/{page}")
	public Map<String, Object> newsList(@PathVariable Integer page){
		return newsService.newsList(page);
	}
}
