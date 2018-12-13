package com.example.demo.repository;

import java.util.List;

import com.example.demo.collection.Record;

public interface WLRecordsRepositoryMk {
	public List<Record> findByTeamtoTeam(String homeT, String awayT);

}
