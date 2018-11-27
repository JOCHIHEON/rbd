package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.QnaboardService;
import com.example.demo.vo.QnaboardVO;

@RestController
public class QnaboardController {
	
	@Autowired
	private QnaboardService qnaService;
	
	@PostMapping("/qna")
	public Integer insertQnA(@RequestBody QnaboardVO qnaVo) {
		return qnaService.insertQnA(qnaVo);
	}
	
	@PutMapping("/qna")
	public Integer updateQnA(@RequestBody QnaboardVO qnaVo) {
		return qnaService.updateQnA(qnaVo);
	}
	
	@GetMapping("/qna/{qna_no}")
	public QnaboardVO selectQnA(@PathVariable Integer qna_no) {
		return qnaService.selectQnA(qna_no);
	}
	
	@GetMapping("/qna")
	public List<QnaboardVO> selectListQnA(@ModelAttribute QnaboardVO qnaVo){
		return qnaService.selectListQnA(qnaVo);
	}
	
	@DeleteMapping("/qna")
	public Integer deleteQnA(@RequestBody QnaboardVO qnaVo) {
		return qnaService.deleteQnA(qnaVo);
	}
}
