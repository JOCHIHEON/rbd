package com.example.demo.vo;

import java.util.List;

import com.example.demo.collection.Record;
import com.example.demo.collection.Team;

import lombok.Data;

@Data
public class TeamCompareTeam {

	private Team home;
	private Team away;
	private Integer win;
	private Integer lose;
	

	
	private List<Record> records;
}
