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
	public ResponseEntity<?> systermException(Exception e) {
		if (e instanceof BaseRuntimeException) {
			log.warn("自定义业务异常，原因是：" + e.getMessage());
			BaseRuntimeException baseRuntimeException = (BaseRuntimeException) e;
			if (baseRuntimeException.getCode() == 403) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
			} else {
				return new ResponseEntity<Response<?>>(ResponseFactory.creatErrorResponse(
						baseRuntimeException.getCode(), baseRuntimeException.getMessage()), HttpStatus.OK);
			}
		} else {
			log.error("系统出错了，原因是：" + e.getMessage(), e);
			return new ResponseEntity<String>(ResponseFactory.creatErrorResponse().getMsg(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
