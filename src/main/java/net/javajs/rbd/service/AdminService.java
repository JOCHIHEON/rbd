package net.javajs.rbd.service;

import java.util.List;

import net.javajs.rbd.vo.AdminInfoVO;

public interface AdminService {
	public Integer insertAdmin(AdminInfoVO adminVo);// 등록

	public Integer updateAdmin(AdminInfoVO adminVo);// 수정

	public Integer findId(String ad_id); // 아이디 중복 조회

	public AdminInfoVO selectAdmin(AdminInfoVO adminVo);// 로그인
	
	public AdminInfoVO selectAdminView(Integer ad_no); //개인 뷰
	
	public List<AdminInfoVO> selectAdminListView(AdminInfoVO adminVo); //관리자 리스트
}
