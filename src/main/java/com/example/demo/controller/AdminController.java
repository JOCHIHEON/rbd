package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.Paging;
import com.example.demo.config.PassEncryption;
import com.example.demo.service.AdminService;
import com.example.demo.vo.AdminInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public Integer adminRegister(@Valid @RequestBody AdminInfoVO adminVo) {
		adminVo.setAd_pwd(PassEncryption.encPwd(adminVo.getAd_pwd()));
		return adminService.insertAdmin(adminVo);
	}
	
	@PutMapping("/admin")
	public Integer adminUpdate(@Valid @RequestBody AdminInfoVO adminVo) {
		if(adminVo.getAd_pwd()!=null  || !adminVo.getAd_pwd().equals("")) {
			adminVo.setAd_pwd(PassEncryption.encPwd(adminVo.getAd_pwd()));
		}
		return adminService.updateAdmin(adminVo);
	}
	
	@GetMapping("/admini/{ad_id}")
	public Integer findId(@PathVariable String ad_id) {
		return adminService.findId(ad_id);
	}
	
	@PostMapping("/admini")
	public Integer selectSign(@RequestBody AdminInfoVO adminVo, HttpSession session) {
		//adminVo.setAd_pwd(PassEncryption.encPwd(adminVo.getAd_pwd()));
		adminVo = adminService.selectAdmin(adminVo);
		log.debug(adminVo.toString());
		if(adminVo.getAd_no() != null) {
			session.setAttribute("manager", adminVo.getAd_id());
			session.setAttribute("no", adminVo.getAd_no());
			return 1;
		}
		return 0;
	}
	
	@GetMapping("/admin/{ad_no}")
	public AdminInfoVO selectView(@PathVariable Integer ad_no) {
		return adminService.selectAdminView(ad_no);
	}
	
	@GetMapping("/admin") 
	public List<AdminInfoVO> selectListView(@RequestParam(value="clickBlock") Integer clickBlock, @RequestParam(value="ad_name") String ad_name,@RequestParam(value="ad_id") String ad_id){
		AdminInfoVO adminVo = new AdminInfoVO();
		adminVo.setAd_id(ad_id);
		adminVo.setAd_name(ad_name);
		adminVo.setPaging(new Paging());
		adminVo.getPaging().setClickBlock(clickBlock);
		return adminService.selectAdminListView(adminVo);
	}
}
