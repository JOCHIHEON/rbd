package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.Paging;
import com.example.demo.service.FreeBoardService;
import com.example.demo.service.FreeComentService;
import com.example.demo.vo.FreeBoardVO;
import com.example.demo.vo.FreeComentVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeboardService;
	@Autowired
	private FreeComentService freeComentService;
	
	@PostMapping("/freeboard")
	public Integer insertFree(@Valid @RequestBody FreeBoardVO freeVo) {
		return freeboardService.insertFree(freeVo);
	}
	
	@PutMapping("/freeboard")
	public Integer updateFree(@Valid @RequestBody FreeBoardVO freeVo) {
		return freeboardService.updateFree(freeVo);
	}
	
	@DeleteMapping("/freeboard")
	public Integer deleteFree(@RequestBody FreeBoardVO freeVo) {
		return freeboardService.deleteFree(freeVo);
	}
	
	@GetMapping("/freeboard/{fre_no}")
	public FreeBoardVO freeView(@PathVariable Integer fre_no, HttpServletRequest req,HttpServletResponse res) {
		boolean check = false;
		Cookie[] cookies = req.getCookies();
		Map<String, String> m = new HashMap<>();
		for(Cookie cookie : cookies) {
			m.put(cookie.getName(), cookie.getValue());
		}
		if(m.get("freeCnt")==null) {
			res.addCookie(new Cookie("freeCnt", "freeView"+fre_no));
			check=true;
		}

		return freeboardService.freeView(fre_no, check);
	}
	
	@GetMapping("/freeboard")
	public List<FreeBoardVO> freeListView(FreeBoardVO freeVo, @RequestParam(value="clickBlock",required=false) Integer clickBlock){
		freeVo.setPaging(new Paging());
		freeVo.getPaging().setClickBlock(clickBlock==null?0:clickBlock);
		return freeboardService.freeListView(freeVo);
	}
		
	/* reply */
	
	@PostMapping("/freereply")
	public Integer insertFreeReply(@Valid @RequestBody FreeComentVO freeComentVo) {
		return freeComentService.insertFreeComent(freeComentVo);
	}
	
	@PutMapping("/freereply")
	public Integer updateFreeReply(@Valid @RequestBody FreeComentVO freeComentVo) {
		return freeComentService.updateFreeComent(freeComentVo);
	}
	
	@DeleteMapping("/freereply")
	public Integer deleteFreeReply(@RequestBody FreeComentVO freeComentVo) {
		return freeComentService.deleteFreeComent(freeComentVo);
	}
	
}
