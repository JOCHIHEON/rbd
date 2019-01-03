package net.javajs.rbd.service;

import java.util.List;

import org.bson.types.ObjectId;

import net.javajs.rbd.collection.Record;
import net.javajs.rbd.collection.TeamRank;
import net.javajs.rbd.vo.TeamCompareTeam;

public interface WLRecordsService {
	public Record getWLRecords(ObjectId _id);
	public List<TeamRank> getRank();
	public TeamCompareTeam getCompare(String homeT,String awayT);
	
}
