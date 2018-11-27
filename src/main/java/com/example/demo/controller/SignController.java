package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SignService;
import com.example.demo.vo.UserInfoVO;

@RestController // <- controller + responsebody
public class SignController {
	
	@Autowired
	private SignService signService;
	
	@PostMapping("/sign")
	public Integer insertSign(@RequestBody UserInfoVO userVo) {
		return signService.insertSign(userVo);
	}
	
	@PutMapping("/user")
	public Integer updateSign(@RequestBody UserInfoVO userVo){
		return signService.updateSign(userVo);
	}
	
	@GetMapping("/sign/{ui_id}")
	public Integer findId(@PathVariable String ui_id) {
		return signService.findId(ui_id);
	}
	
	@PostMapping("/login")
	public Integer selectSign(@RequestBody UserInfoVO userVo, HttpSession session) {
		userVo = signService.selectSign(userVo);
		if(userVo.getUi_no() != null) {
			session.setAttribute("id", userVo.getUi_id());
			session.setAttribute("no", userVo.getUi_no());
			return 1;
		}
		return 0;
	}
	
	@GetMapping("/user/{ui_no}")
	public UserInfoVO selectView(@PathVariable Integer ui_no) {
		return signService.selectView(ui_no);
	}
	
	@GetMapping("/user")
	public List<UserInfoVO> selectListView(@RequestParam(value="ui_name") String ui_name,@RequestParam(value="ui_nick") String ui_nick,@RequestParam(value="ui_support") Integer ui_support){
		UserInfoVO userVo = new UserInfoVO();
		userVo.setUi_name(ui_name);
		userVo.setUi_nick(ui_nick);
		userVo.setUi_support(ui_support);
		return signService.selectListView(userVo);
	}
	
	@GetMapping("/logout")
	public Integer integer(HttpSession session) {
		if(session.getAttribute("id")!=null) {
			session.removeAttribute("id");
			session.invalidate();
			return 1;
		}
		return -1;
	}
}
