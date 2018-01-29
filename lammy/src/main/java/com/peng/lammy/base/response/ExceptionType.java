package com.peng.lammy.base.response;

/**
 * 错误响应类型枚举
 * 
 * @author jp
 * @time 2017年11月8日 上午11:42:54
 */
public enum ExceptionType {

	SUCCESS(0, "success"), // 成功
	REQUEST_EXCEPTION(400, "请求头部错误"), //
	PARAM_EXCEPTION(401, "请求参数错误"), //
	SERVER_EXCEPTION(500, "服务器异常"), // 系统错误
	SERVER_FAIL_EXCEPTION(501, "服务调用失败"), // 系统错误
	FAIL(1000, "");// 业务失败（未定义失败code）

	/*
	 * 下面定义一些业务异常代码
	 */

	private int code;
	private String message;

	ExceptionType(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
