package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.AdminRepository;
import net.javajs.rbd.vo.AdminInfoVO;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	@Override
	public Integer insertAdmin(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.ADMININFO.admininfoInsert",AdminVo);
	}

	@Override
	public Integer updateAdmin(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.ADMININFO.admininfoUpdate", AdminVo);
	}

	@Override
	public Integer findId(String ad_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.ADMININFO.admininfoIDCheck", ad_id);
	}

	@Override
	public AdminInfoVO selectAdmin(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.ADMININFO.admininfoSelect", AdminVo);
	}//login

	@Override
	public AdminInfoVO selectAdminView(Integer ad_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.ADMININFO.admininfoView", ad_no);
	}//view page

	@Override
	public List<AdminInfoVO> selectAdminListView(AdminInfoVO AdminVo) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.ADMININFO.admininfoList", AdminVo);
	}

	@Override
	public Integer selectAdminCount() {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.ADMININFO.selectAdminCount");
	}

}
