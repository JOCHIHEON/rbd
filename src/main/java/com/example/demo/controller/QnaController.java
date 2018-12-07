package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.Paging;
import com.example.demo.service.QnaboardService;
import com.example.demo.service.QnacomentService;
import com.example.demo.vo.QnaboardVO;
import com.example.demo.vo.QnacomentVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class QnaController {
	/* qnaboard */
	@Autowired
	private QnaboardService qnaService;
	
	@Autowired
	private QnacomentService qcomentService;
	
	@PostMapping("/qna")
	public Integer insertQnA(@Valid @RequestBody QnaboardVO qnaVo) {
		return qnaService.insertQnA(qnaVo);
	}
	
	@PutMapping("/qna")
	public Integer updateQnA(@Valid @RequestBody QnaboardVO qnaVo) {
		log.debug(qnaVo.toString());
		return qnaService.updateQnA(qnaVo);
	}
	
	@GetMapping("/qna/{qna_no}")
	public QnaboardVO selectQnA(@PathVariable Integer qna_no) {
		return qnaService.selectQnA(qna_no);
	}
	
	@GetMapping("/qna")
	public List<QnaboardVO> selectListQnA(@ModelAttribute QnaboardVO qnaVo, @RequestParam(value="clickBlock") Integer clickBlock){
		qnaVo.setPaging(new Paging());
		qnaVo.getPaging().setClickBlock(clickBlock);
		return qnaService.selectListQnA(qnaVo);
	}
	
	@DeleteMapping("/qna")
	public Integer deleteQnA(@RequestBody QnaboardVO qnaVo) {
		return qnaService.deleteQnA(qnaVo);
	}
	
	/* qnacoment */
	@PostMapping("/qnareply")
	public Integer insertQnAComent(@Valid @RequestBody QnacomentVO qnacomentVo, HttpSession session) {
		if((session.getAttribute("id")!= null && qnacomentVo.getUi_no()==null) || (session.getAttribute("manager")!=null && qnacomentVo.getAd_no()==null && qnacomentVo.getUi_no() != null)) {
			return -1;
		}
		return qcomentService.insertQnacoment(qnacomentVo);
	}
	
	@PutMapping("/qnareply")
	public Integer updateQnAComent(@Valid @RequestBody QnacomentVO qnacomentVo, HttpSession session) {
		if((session.getAttribute("id")!= null && qnacomentVo.getUi_no()==null) || (session.getAttribute("manager")!=null && qnacomentVo.getAd_no()==null && qnacomentVo.getUi_no() != null)) {
			return -1;
		}
		return qcomentService.updateQnacoment(qnacomentVo);
	}	
	
	@DeleteMapping("/qnareply")
	public Integer deleteQnAComent(@RequestBody QnacomentVO qnacomentVo, HttpSession session) {
		if((session.getAttribute("id")!= null && qnacomentVo.getUi_no()==null) || (session.getAttribute("manager")!=null && qnacomentVo.getAd_no()==null && qnacomentVo.getUi_no() != null)) {
			return -1;
		}
		return qcomentService.deleteQnacoment(qnacomentVo);
	}	
}
