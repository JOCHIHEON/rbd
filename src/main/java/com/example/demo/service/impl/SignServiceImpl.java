package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SignRepository;
import com.example.demo.service.SignService;
import com.example.demo.vo.UserInfoVO;

@Service
public class SignServiceImpl implements SignService{
	
	@Autowired
	private SignRepository signRepo;
	
	@Override
	public Integer insertSign(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		return signRepo.insertSign(userVo);
	}

	@Override
	public Integer updateSign(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		return signRepo.updateSign(userVo);
	}

	@Override
	public Integer findId(String ui_id) {
		// TODO Auto-generated method stub
		return signRepo.findId(ui_id);
	}

	@Override
	public UserInfoVO selectSign(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		return signRepo.selectSign(userVo);
	}

	@Override
	public UserInfoVO selectView(Integer ui_no) {
		// TODO Auto-generated method stub
		return signRepo.selectView(ui_no);
	}

	@Override
	public List<UserInfoVO> selectListView(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		userVo.getPaging().setPaging(userVo.getPaging().getClickBlock(), signRepo.countUser());
		return signRepo.selectListView(userVo);
	}

}
