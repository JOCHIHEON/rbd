package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.JapanRepository;
import com.example.demo.service.JapanService;
import com.example.demo.vo.JapanVO;

@Service
public class JapanServiceImpl implements JapanService{
	@Autowired
	private JapanRepository jrepo;
	
	@Override
	public List<JapanVO> selectJapanList(JapanVO jvo) {
		// TODO Auto-generated method stub
		return jrepo.selectJapanList(jvo);
	}

	@Override
	public int insertJapan(JapanVO jvo) {
		int cnt = jrepo.insertJapan(jvo);
		cnt += jrepo.updateJapan(jvo);
		return cnt;
	}

	@Override
	public int updateJapan(JapanVO jvo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
