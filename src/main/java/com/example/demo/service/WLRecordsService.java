package com.example.demo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.demo.collection.Record;
import com.example.demo.collection.TeamRank;
import com.example.demo.vo.TeamCompareTeam;

public interface WLRecordsService {
	public Record getWLRecords(ObjectId _id);
	public List<TeamRank> getRank();
	public TeamCompareTeam getCompare(String homeT,String awayT);
	
}
