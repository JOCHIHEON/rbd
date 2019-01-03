package net.javajs.rbd.vo;

import java.util.List;

import net.javajs.rbd.collection.Record;
import net.javajs.rbd.collection.Team;

import lombok.Data;

@Data
public class TeamCompareTeam {

	private Team home;
	private Team away;
	private Integer win;
	private Integer lose;
	

	
	private List<Record> records;
}
