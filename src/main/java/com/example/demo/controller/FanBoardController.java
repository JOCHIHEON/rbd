package com.example.demo.controller;

import java.util.HashMap;
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
import com.example.demo.service.FanBoardService;
import com.example.demo.service.FanComentService;
import com.example.demo.vo.FanBoardVO;
import com.example.demo.vo.FanComentVO;

@RestController
public class FanBoardController {
	
	@Autowired
	private FanBoardService fanBoardService;
	
	@Autowired
	private FanComentService fanComentservice;
	
	@PostMapping("/fanboard")
	public Integer insertFanBoard(@Valid @RequestBody FanBoardVO fanVo) {
		return fanBoardService.insertFan(fanVo);
	}
	
	@PutMapping("/fanboard")
	public Integer updateFanBoard(@Valid @RequestBody FanBoardVO fanVo) {
		return fanBoardService.updateFan(fanVo);
	}
	
	@DeleteMapping("/fanboard")
	public Integer deleteFanBoard(@RequestBody FanBoardVO fanVo) {
		return fanBoardService.deleteFan(fanVo);
	}
	
	@GetMapping("/fanboard/{fan_no}")
	public FanBoardVO fanView(@PathVariable Integer fan_no, HttpServletRequest req,HttpServletResponse res) {
		boolean check = false;
		Cookie[] cookies = req.getCookies();
		Map<String, String> m = new HashMap<>();
		for(Cookie cookie : cookies) {
			m.put(cookie.getName(), cookie.getValue());
		}
		if(m.get("fanCnt")==null) {
			res.addCookie(new Cookie("fanCnt", "fanView"+fan_no));
			check=true;
		}
		return fanBoardService.fanView(fan_no,check);
	}
	
	@GetMapping("/fanboard")
	public Map<String,Object> fanListView(FanBoardVO fanVo, @RequestParam(value="clickBlock",required=false) Integer clickBlock, Map<String,Object> map){
		fanVo.setPaging(new Paging());
		fanVo.getPaging().setClickBlock(clickBlock==null?0:clickBlock);
		map.put("fanList", fanBoardService.fanListView(fanVo));
		map.put("paging", fanVo.getPaging());
		return fanBoardService.fanListView(fanVo);
	}
	
	/* fanReply */
	
	
	@PostMapping("/fanreply")
	public Integer insertFanComent(@Valid @RequestBody FanComentVO fanComentVo) {
		return fanComentservice.insertFanComent(fanComentVo);
	}
	
	@PutMapping("/fanreply")
	public Integer updateFanComent(@Valid @RequestBody FanComentVO fanComentVo) {
		return fanComentservice.updateFanComent(fanComentVo);
	}
	
	@DeleteMapping("/fanreply")
	public Integer deleteFanComent(@RequestBody FanComentVO fanComentVo) {
		return fanComentservice.deleteFanComent(fanComentVo);
	}
}
