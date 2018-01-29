package com.peng.lammy.base.exception.handler;

import javax.servlet.ServletException;

import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.exception.BaseRuntimeException;
import com.peng.lammy.base.response.ExceptionType;
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
	public Response<?> systermException(Exception e) {
		log.error("系统出错了，原因是：" + e.getMessage(), e);
		return ResponseFactory.creatErrorResponse();
	}

	@ExceptionHandler(HttpMessageConversionException.class)
	public Response<?> httpMessageNotReadableException(HttpMessageConversionException e) {
		log.error("请求参数出错了，原因是：" + e.getMessage());
		return ResponseFactory.creatErrorResponse(ExceptionType.PARAM_EXCEPTION);
	}

	@ExceptionHandler(ServletException.class)
	public Response<?> servletException(ServletException e) {
		log.error("请求头部错误，原因是：" + e.getMessage());
		return ResponseFactory.creatErrorResponse(ExceptionType.REQUEST_EXCEPTION);
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

	@ExceptionHandler(IllegalArgumentException.class)
	public Response<?> IllegalArgumentException(IllegalArgumentException e) {
		log.warn("业务异常:code==>1001，message==>{}", e.getMessage());
		return ResponseFactory.creatErrorResponse(1001, e.getMessage());
	}

}
