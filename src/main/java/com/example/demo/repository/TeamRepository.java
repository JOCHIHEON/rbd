package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.collection.Team;

public interface TeamRepository extends MongoRepository<Team, String>{
	
	@Query(value = "{$and: [ { 'team_code' : ?0 }, { 'teamDetail.season' : ?1 } ]}", fields = "{ 'team_name' : 1, 'teamDetail' : { '$elemMatch' : { 'season' : ?1 } } }")
	public Team findByTeamDetail(String team_code, String season);
	
	@Query(value="{'team_code' : ?0}", fields = "{ team_code : 1, team_name : 1, team_owner : 1, team_reowner : 1, team_leader : 1, team_director : 1, team_coach : 1, team_address : 1, team_company : 1 }")
	public Team findByTeam(String team_code);
	
	@Query(value="{$and: [{$or : [{'team_name' : { $regex: ?0 }}, {'team_name' : { $regex: ?1 }}] }, { 'teamDetail.season' :  '2018-2019' } ]}", fields = "{ team_code : 1, 'teamDetail' : { '$elemMatch' : { 'season' : '2018-2019' } } }")
	public List<Team> findByTeamName(String homeT, String awayT);
	
	@Query(value = "{}", fields="{ team_code : 1, team_name : 1, 'teamDetail' : { '$elemMatch' : { 'season' : '2018-2019' } }  }")
	public List<Team> findByTeamList();
	
	@Query(value = "{}", fields="{ 'player_info.player_no' : 1 , 'player_info.team_code' : 1, 'player_info.player_name' : 1 }")
	public List<Team> findByPlayerList();
	
	@Query(value="{'team_code' : ?0}", fields="{ 'player_info.player_no' : 1,  'player_info.player_name' : 1  }")
	public Team findByTeamPlayerList(String team_code);
	
	@Query(value=" {$and : [ {'player_info.team_code' : ?0}, {'player_info.player_no' : ?1} ]}", fields ="{ 'player_info' : {'$elemMatch' : {player_no : ?1}} }")
	public Team findByTeamPlayerDetail(String team_code, String player_no);
	
	@Query(value="{}", fields = "{ team_code : 1, 'teamDetail' : { '$elemMatch' : { 'season' : '2018-2019' } } }")
	public List<Team> findByRank();
	
	@Query(value="{ $or : [ {'team_name' : { $regex: ?0 } }, {'team_name' : { $regex: ?1 } } ]}", fields = "{'team_name' : 1 , 'teamDetail' : { '$elemMatch' : { 'season' : '2018-2019' } } }")
	public List<Team> findByTeamCompare(String homeT, String awayT);
	
}
