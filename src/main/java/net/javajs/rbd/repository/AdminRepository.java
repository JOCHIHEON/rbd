package net.javajs.rbd.repository;

import java.util.List;

import net.javajs.rbd.vo.AdminInfoVO;

public interface AdminRepository {
	public Integer insertAdmin(AdminInfoVO AdminVo);// 등록

	public Integer updateAdmin(AdminInfoVO AdminVo);// 수정

	public Integer findId(String ad_id); // 아이디 중복 조회

	public AdminInfoVO selectAdmin(AdminInfoVO AdminVo);// 로그인
	
	public AdminInfoVO selectAdminView(Integer ad_no); //개인 뷰
	
	public List<AdminInfoVO> selectAdminListView(AdminInfoVO AdminVo); //관리자 리스트
	
	public Integer selectAdminCount();
}
