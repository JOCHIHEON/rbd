package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.JapanVO;

public interface JapanRepository {
	public List<JapanVO> selectJapanList(JapanVO jvo);
	public int insertJapan(JapanVO jvo);
	public int updateJapan(JapanVO jvo);
}
