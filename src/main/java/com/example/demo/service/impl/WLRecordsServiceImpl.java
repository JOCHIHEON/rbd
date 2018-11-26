package com.example.demo.service.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.WLRecordsRepository;
import com.example.demo.service.WLRecordsService;
import com.example.demo.vo.Record;

@Service
public class WLRecordsServiceImpl implements WLRecordsService{

	@Autowired
	private WLRecordsRepository wlrrepo;
	@Override
	public Record getWLRecords(ObjectId _id) {
		return wlrrepo.findBy_id(_id);
	}

}
