package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.JapanService;
import com.example.demo.vo.JapanVO;

@RestController
public class JapanController {

	@Autowired
	private JapanService js;
	
	@GetMapping("/")
	public List<JapanVO> home(@ModelAttribute JapanVO jvo) {				
		return js.selectJapanList(jvo);
	}
	
	@PostMapping("/")
	@ResponseBody
	public int insertJapan(@RequestBody JapanVO jvo) {
		return js.insertJapan(jvo);
	}
}
