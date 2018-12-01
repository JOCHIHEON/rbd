package com.example.demo.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.AdminRepository;
import com.example.demo.vo.AdminInfoVO;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	
	@Autowired
	//@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	@Override
	public Integer insertAdmin(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.insert("com.example.demo.ADMININFO.admininfoInsert",AdminVo);
	}

	@Override
	public Integer updateAdmin(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.update("com.example.demo.ADMININFO.admininfoUpdate", AdminVo);
	}

	@Override
	public Integer findId(String ad_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.ADMININFO.admininfoIDCheck", ad_id);
	}

	@Override
	public AdminInfoVO selectAdmin(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.ADMININFO.admininfoSelect", AdminVo);
	}//login

	@Override
	public AdminInfoVO selectAdminView(Integer ad_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.ADMININFO.admininfoView", ad_no);
	}//view page

	@Override
	public List<AdminInfoVO> selectAdminListView(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.selectList("com.example.demo.ADMININFO.admininfoList", AdminVo);
	}

	@Override
	public Integer selectAdminCount() {
		// TODO Auto-generated method stub
		return ss.selectOne("com.example.demo.ADMININFO.selectAdminCount");
	}

}
