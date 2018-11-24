package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.JapanVO;

public interface JapanService {
	public List<JapanVO> selectJapanList(JapanVO jvo);
	public int insertJapan(JapanVO jvo);
	public int updateJapan(JapanVO jvo);
}
