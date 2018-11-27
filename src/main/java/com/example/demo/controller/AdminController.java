package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.AdminInfoVO;

@RestController
public class AdminController {
	
	@PostMapping("/admin")
	public Integer adminRegister(@RequestBody AdminInfoVO adminVo) {
		return 1;
	}
}
