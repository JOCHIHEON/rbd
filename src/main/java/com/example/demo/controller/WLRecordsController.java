package com.example.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.WLRecordsService;
import com.example.demo.vo.WLRecords;

@RestController
public class WLRecordsController {

	@Autowired
	private WLRecordsService wlrs;
	
	@GetMapping("/wlrs/{id}")
	public WLRecords getWLRecords(@PathVariable("id") ObjectId id) {
		return wlrs.getWLRecords(id);
	}
}
