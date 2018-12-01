package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.JapanService;
import com.example.demo.vo.JapanVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class JapanController {

	@Autowired
	private JapanService js;
	
	@GetMapping("/1")
	public List<JapanVO> home(@ModelAttribute JapanVO jvo) {				
		return js.selectJapanList(jvo); 
	}
	
	@PostMapping("/")
	@ResponseBody
	public int insertJapan(@RequestBody JapanVO jvo) {
		return js.insertJapan(jvo);
	}
	
	@PostMapping(value = "/test", consumes = {"multipart/form-data"}, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	public JapanVO completeTask(@RequestPart("japan") JapanVO jvo,
			@RequestPart("resources") MultipartFile[] mfs) {
		log.debug("jvo=>{}",jvo);
		log.debug("mfs[0]=>{}",mfs[0]);
		return null;
	}
}
