package com.peng.lammy.base.exception;

import com.peng.lammy.base.response.ExceptionType;

/**
 * @Description 基础运行时异常（****其他所有业务运行时异常都要继承这个异常****）
 * @author jp
 * @time 2017年11月24日 下午2:37:04
 */
public class BaseRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int FAIL_CODE = 1000;

	private int code;// 错误代码
	private String message;// 错误信息

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public BaseRuntimeException() {
		super();
	}

	public BaseRuntimeException(String message, Throwable cause) {
		super(message, cause);
		this.code = FAIL_CODE;
		this.message = message;
	}

	public BaseRuntimeException(String message, int code, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.message = message;
	}

	public BaseRuntimeException(String message) {
		super(message);
		this.code = FAIL_CODE;
		this.message = message;
	}

	public BaseRuntimeException(String message, int code) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public BaseRuntimeException(ExceptionType exceptionType) {
		super(exceptionType.getMessage());
		this.code = exceptionType.getCode();
		this.message = exceptionType.getMessage();
	}

}
