package net.javajs.rbd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javajs.rbd.collection.Player;
import net.javajs.rbd.collection.Team;
import net.javajs.rbd.repository.TeamRepository;
import net.javajs.rbd.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private TeamRepository teamRepo;

	@Override
	public Player playerView(String team_code, String player_no) {
		// TODO Auto-generated method stub
		Team team = teamRepo.findByTeamPlayerDetail(team_code, player_no);
		List<Player> playerList = team.getPlayer_info();
		Player player = null;
		if(playerList.size()==1) {
			player = playerList.get(0);
		}
		return player;
	}

	//플레이어 전체리스트 
	@Override
	public List<Player> playerListView(Player playerVo) {
		// TODO Auto-generated method stub
		List<Team> teamList = teamRepo.findByPlayerList();
		List<Player> playerList = new ArrayList<>();
		for(Team t : teamList) {
			for(Player p : t.getPlayer_info()) {
				playerList.add(p);
			}
		}
		return playerList;
	}

	@Override
	public List<Player> teamPlayerList(String team_code) {
		// TODO Auto-generated method stub
		Team team = teamRepo.findByTeamPlayerList(team_code);
		List<Player> playerList = team.getPlayer_info();
		return playerList;
	}

}
