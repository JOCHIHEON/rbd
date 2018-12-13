package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.Paging;
import com.example.demo.config.PassEncryption;
import com.example.demo.jwt.JWTFactory;
import com.example.demo.service.SignService;
import com.example.demo.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // <- controller + responsebody
public class SignController {
	@Autowired
	private JWTFactory jwtf;
	@Autowired
	private SignService signService;

	@PostMapping("/sign")
	public Integer insertSign(@Valid @RequestBody UserInfoVO userVo) {
		userVo.setUi_pwd(PassEncryption.encPwd(userVo.getUi_pwd()));
		return signService.insertSign(userVo);
	}

	@PutMapping("/user")
	public Integer updateSign(@Valid @RequestBody UserInfoVO userVo) {
		if (userVo.getUi_pwd() == null || userVo.getUi_pwd().equals("")) {
			return -1;
		}
		userVo.setUi_pwd(PassEncryption.encPwd(userVo.getUi_pwd()));
		return signService.updateSign(userVo);
	}

	@GetMapping("/sign/{ui_id}")
	public Integer findId(@PathVariable String ui_id) {
		return signService.findId(ui_id);
	}

	@PostMapping("/login")
	public UserInfoVO selectSign(@RequestBody UserInfoVO userVo, HttpSession session) throws Exception {
		userVo.setUi_pwd(PassEncryption.encPwd(userVo.getUi_pwd()));
		userVo = signService.selectSign(userVo);
		if (userVo.getUi_no() != 0) {
			userVo.setToken(jwtf.createJWT(userVo));
			log.debug("userVo =>{}", userVo.toString());
			log.debug("session no => {}", session.getAttribute("no"));
			log.debug("session =>{}", session.getAttribute("id"));
			return userVo;
		}
		return null;
	}

	@GetMapping("/user/{ui_no}")
	public UserInfoVO selectView(@PathVariable Integer ui_no) {
		return signService.selectView(ui_no);
	}

	@GetMapping("/user")
	public List<UserInfoVO> selectListView(@RequestParam(value = "clickBlock") Integer clickBlock,
			@ModelAttribute UserInfoVO userVo) {
		userVo.setPaging(new Paging());
		userVo.getPaging().setClickBlock(clickBlock);
		return signService.selectListView(userVo);
	}

	@GetMapping("/logout")
	public Integer integer(HttpSession session) {
		if (session.getAttribute("id") != null || session.getAttribute("manager") != null) {
			session.removeAttribute("id");
			session.removeAttribute("manager");
			session.invalidate();
			return 1;
		}
		return -1;
	}
}
