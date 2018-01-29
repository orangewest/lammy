package com.peng.lammy.base.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.exception.BaseRuntimeException;
import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 全局异常控制
 * @author jp
 * @time 2017年12月4日 上午9:14:40
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 系统异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response<?>> systermException(Exception e) {
		log.error("系统出错了，原因是：" + e.getMessage(), e);
		return new ResponseEntity<Response<?>>(ResponseFactory.creatErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 业务异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BaseRuntimeException.class)
	public Response<?> serviceException(BaseRuntimeException e) {
		log.warn("业务异常:code==>{}，message==>{}", e.getCode(), e.getMessage());
		return ResponseFactory.creatErrorResponse(e.getCode(), e.getMessage());
	}

}
