package net.javajs.rbd.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.javajs.rbd.repository.SignRepository;
import net.javajs.rbd.vo.UserInfoVO;

@Repository
public class SignRepositoryImpl implements SignRepository {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession ss;

	@Override
	public Integer insertSign(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		return ss.insert("net.javajs.rbd.USERINFO.userinfoInsert", userVo);
	}

	@Override
	public Integer updateSign(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		return ss.update("net.javajs.rbd.USERINFO.userinfoUpdate", userVo);
	}

	@Override
	public Integer findId(String ui_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.USERINFO.userinfoIDCheck", ui_id);
	}

	@Override
	public UserInfoVO selectSign(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.USERINFO.userinfoSelect", userVo);
	}

	@Override
	public UserInfoVO selectView(Integer ui_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.USERINFO.userinfoView", ui_no);
	}

	@Override
	public List<UserInfoVO> selectListView(UserInfoVO userVo) {
		// TODO Auto-generated method stub
		return ss.selectList("net.javajs.rbd.USERINFO.userinfoList",userVo);
	}

	@Override
	public Integer countUser() {
		// TODO Auto-generated method stub
		return ss.selectOne("net.javajs.rbd.USERINFO.countUser");
	}

}
