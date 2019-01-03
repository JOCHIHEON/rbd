package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.collection.Record;

public interface WLRecordsRepositoryMk {
	public List<Record> findByTeamtoTeam(String homeT, String awayT);

}
