package com.example.demo.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@ControllerAdvice
public class ValidException {

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public Map<String, String> validException(MethodArgumentNotValidException ex){
		BindingResult br =ex.getBindingResult();
		
		Map<String,String> m = new HashMap<String,String>();
		for(FieldError fe : br.getFieldErrors()) {
			m.put(fe.getField(), fe.getDefaultMessage());
			log.info("field Err => {}, {}",fe.getField(),fe.getDefaultMessage());
		}
		
		return m;
		
	}
}
