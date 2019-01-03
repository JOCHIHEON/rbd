package net.javajs.rbd.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.javajs.rbd.collection.Record;
import net.javajs.rbd.collection.TeamRank;
import net.javajs.rbd.service.WLRecordsService;
import net.javajs.rbd.vo.TeamCompareTeam;

@RestController
public class WLRecordsController {

	@Autowired
	private WLRecordsService wlrs;
	
	@GetMapping("/wlrs/{id}")
	public Record getWLRecords(@PathVariable("id") ObjectId id) {
		return wlrs.getWLRecords(id);
	}
	
	@GetMapping("/wlrs")
	public List<TeamRank> getRank(){
		return wlrs.getRank();
	}
	@GetMapping("/wlrs/{homeT}/{awayT}")
	public TeamCompareTeam getCompare(@PathVariable String homeT, @PathVariable String awayT){
		return wlrs.getCompare(homeT, awayT);
	}
}
