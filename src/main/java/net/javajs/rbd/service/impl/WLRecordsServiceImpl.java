package net.javajs.rbd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.javajs.rbd.collection.Record;
import net.javajs.rbd.collection.Team;
import net.javajs.rbd.collection.TeamRank;
import net.javajs.rbd.repository.TeamRepository;
import net.javajs.rbd.repository.WLRecordsRepository;
import net.javajs.rbd.repository.WLRecordsRepositoryMk;
import net.javajs.rbd.service.WLRecordsService;
import net.javajs.rbd.vo.TeamCompareTeam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WLRecordsServiceImpl implements WLRecordsService {

	@Autowired
	private WLRecordsRepository wlrrepo;
	@Autowired
	private TeamRepository teamrepo;
	
	@Autowired
	@Qualifier("wlMk")
	private WLRecordsRepositoryMk wlMk;
	
	@Override
	public Record getWLRecords(ObjectId _id) {
		return wlrrepo.findBy_id(_id);
	}

	@Override
	public List<TeamRank> getRank() {
		// TODO Auto-generated method stub
		List<TeamRank> ranks = new ArrayList<>();
		for(Team team : teamrepo.findByRank()) {
			ranks.add(team.getTeamDetail().get(0).getTeamRank());
		}
		return ranks;
	}

	@Override
	public TeamCompareTeam getCompare(String homeT, String awayT) {
		TeamCompareTeam tct = new TeamCompareTeam();
		for(Team t : teamrepo.findByTeamCompare(homeT, awayT)) {
			if(t.getTeam_name().indexOf(homeT)!= -1) {
				tct.setHome(t);
			}else if (t.getTeam_name().indexOf(awayT)!= -1) {
				tct.setAway(t);
			}
		}
		List<Record> records =wlMk.findByTeamtoTeam(homeT, awayT); 
		int win = 0, lose = 0;
		for(Record r : records) {
			if(r.getHomeScore()> r.getAwayScore()) {
				tct.getHome().getTeamDetail().get(0).getTeamRank().setWin(++win);
			}else {
				tct.getHome().getTeamDetail().get(0).getTeamRank().setLose(++lose);
			}
		}
		tct.setRecords(records);
		return tct;
	}
}
