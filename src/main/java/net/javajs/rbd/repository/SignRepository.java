package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.UserInfoVO;

public interface SignRepository {
	
	public Integer insertSign(UserInfoVO userVo);// 가입

	public Integer updateSign(UserInfoVO userVo);// 수정

	public Integer findId(String ui_id); // 아이디 중복 조회

	public UserInfoVO selectSign(UserInfoVO userVo);// 로그인
	
	public UserInfoVO selectView(Integer ui_no); //개인 뷰
	
	public List<UserInfoVO> selectListView(UserInfoVO userVo); //회원 리스트
	
	public Integer countUser();
}
