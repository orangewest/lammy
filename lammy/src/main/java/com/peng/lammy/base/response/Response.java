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
	private String msg;
	private T data;// 响应数据
	private long count;// 总条数

	public int getCode() {
		return code;
	}

	public Response<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public T getData() {
		return data;
	}

	public Response<T> setData(T data) {
		this.data = data;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Response<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public long getCount() {
		return count;
	}

	public Response<T> setCount(long count) {
		this.count = count;
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
		this.msg = exceptionType.getMessage();
		return this;
	}
}
