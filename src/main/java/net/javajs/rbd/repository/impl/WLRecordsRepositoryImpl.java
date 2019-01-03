package net.javajs.rbd.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.collection.Record;
import net.javajs.rbd.repository.WLRecordsRepositoryMk;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Repository("wlMk")
public class WLRecordsRepositoryImpl implements WLRecordsRepositoryMk {

	@Autowired
	private MongoTemplate mt;

	@Override
	public List<Record> findByTeamtoTeam(String homeT, String awayT) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.andOperator(Criteria.where("date").gt("20181012"));
		criteria.orOperator(Criteria.where("awayName").regex(awayT, "i").and("homeName").regex(homeT, "i"),
				Criteria.where("awayName").regex(homeT, "i").and("homeName").regex(awayT, "i"));
		Query query = new Query(criteria).with(new Sort(Sort.Direction.DESC, "date"));
		List<Record> recods = mt.find(query, Record.class);
		return recods;
	}

}
