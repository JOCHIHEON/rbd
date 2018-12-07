package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LikeUnLikeService;
import com.example.demo.vo.LikeUnLikeVO;

@RestController
public class LikeUnLikeController {

	@Autowired
	private LikeUnLikeService likes;
	
	@PostMapping("/like")
	public Integer insertLikeUnLike(@Valid @RequestBody LikeUnLikeVO liUnLiVo) {
		return likes.insertliUnLi(liUnLiVo);
	}
	
	@DeleteMapping("/like")
	public Integer deleteLikeUnLike(@RequestBody LikeUnLikeVO liUnLiVo) {
		return likes.deleteliUnLi(liUnLiVo);
	}
}
