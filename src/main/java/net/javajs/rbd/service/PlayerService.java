package net.javajs.rbd.service;

import java.util.List;

import net.javajs.rbd.collection.Player;

public interface PlayerService {

	public Player playerView(String team_code, String player_no);
	public List<Player> playerListView(Player playerVo);
	public List<Player> teamPlayerList(String team_code);
}
