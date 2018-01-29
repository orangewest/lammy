package com.peng.lammy.base.response;

import java.io.Serializable;

/**
 * @Description 所有响应接口
 * @author jp
 * @time 2017年11月24日 下午3:27:58
 */

public class Response<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
	private T data;// 响应数据

	public int getCode() {
		return code;
	}

	public Response<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Response<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public Response<T> setData(T data) {
		this.data = data;
		return this;
	}

	/**
	 * 设置响应类型
	 * 
	 * @param exceptionType
	 * @return
	 */
	public Response<T> setResponseType(ExceptionType exceptionType) {
		this.code = exceptionType.getCode();
		this.message = exceptionType.getMessage();
		return this;
	}
}
