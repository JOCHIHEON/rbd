package net.javajs.rbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javajs.rbd.repository.AdminRepository;
import net.javajs.rbd.service.AdminService;
import net.javajs.rbd.vo.AdminInfoVO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Integer insertAdmin(AdminInfoVO adminVo) {
		// TODO Auto-generated method stub
		return adminRepo.insertAdmin(adminVo);
	}

	@Override
	public Integer updateAdmin(AdminInfoVO adminVo) {
		// TODO Auto-generated method stub
		return adminRepo.updateAdmin(adminVo);
	}

	@Override
	public Integer findId(String ad_id) {
		// TODO Auto-generated method stub
		return adminRepo.findId(ad_id);
	}

	@Override
	public AdminInfoVO selectAdmin(AdminInfoVO adminVo) {
		// TODO Auto-generated method stub
		return adminRepo.selectAdmin(adminVo);
	}

	@Override
	public AdminInfoVO selectAdminView(Integer ad_no) {
		// TODO Auto-generated method stub
		return adminRepo.selectAdminView(ad_no);
	}

	@Override
	public List<AdminInfoVO> selectAdminListView(AdminInfoVO adminVo) {
		// TODO Auto-generated method stub
		adminVo.getPaging().setPaging(adminVo.getPaging().getClickBlock(), adminRepo.selectAdminCount());
		return adminRepo.selectAdminListView(adminVo);
	}

}
