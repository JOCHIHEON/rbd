package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.collection.Paging;
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
	public Integer insertFanBoard(@RequestBody FanBoardVO fanVo) {
		return fanBoardService.insertFan(fanVo);
	}
	
	@PutMapping("/fanboard")
	public Integer updateFanBoard(@RequestBody FanBoardVO fanVo) {
		return fanBoardService.updateFan(fanVo);
	}
	
	@DeleteMapping("/fanboard")
	public Integer deleteFanBoard(@RequestBody FanBoardVO fanVo) {
		return fanBoardService.deleteFan(fanVo);
	}
	
	@GetMapping("/fanboard/{fan_no}")
	public FanBoardVO fanView(@PathVariable Integer fan_no) {
		return fanBoardService.fanView(fan_no);
	}
	
	@GetMapping("/fanboard")
	public List<FanBoardVO> fanListView(FanBoardVO fanVo, @RequestParam(value="clickBlock") Integer clickBlock){
		fanVo.setPaging(new Paging());
		fanVo.getPaging().setClickBlock(clickBlock);
		return fanBoardService.fanListView(fanVo);
	}
	
	/* fanReply */
	
	
	@PostMapping("/fanreply")
	public Integer insertFanComent(@RequestBody FanComentVO fanComentVo) {
		return fanComentservice.insertFanComent(fanComentVo);
	}
	
	@PutMapping("/fanreply")
	public Integer updateFanComent(@RequestBody FanComentVO fanComentVo) {
		return fanComentservice.updateFanComent(fanComentVo);
	}
	
	@DeleteMapping("/fanreply")
	public Integer deleteFanComent(@RequestBody FanComentVO fanComentVo) {
		return fanComentservice.deleteFanComent(fanComentVo);
	}
}
