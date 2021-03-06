package net.javajs.rbd.controller;

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

import net.javajs.rbd.config.Paging;
import net.javajs.rbd.service.FreeBoardService;
import net.javajs.rbd.service.FreeComentService;
import net.javajs.rbd.vo.FreeBoardVO;
import net.javajs.rbd.vo.FreeComentVO;

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
	public FreeBoardVO freeView(@PathVariable Integer fre_no) {
		return freeboardService.freeView(fre_no);
	}
	
	@GetMapping("/freeboard")
	public Map<String,Object> freeListView(FreeBoardVO freeVo, @RequestParam(value="clickBlock",required=false) Integer clickBlock){
		Map<String, Object> map = new HashMap<>();
		freeVo.setPaging(new Paging());
		freeVo.getPaging().setClickBlock(clickBlock==null?0:clickBlock);
		map.put("freeList", freeboardService.freeListView(freeVo));
		map.put("paging", freeVo.getPaging());
		return map;
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
