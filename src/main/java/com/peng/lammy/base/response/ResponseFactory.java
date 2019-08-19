package com.peng.lammy.base.response;

/**
 * 响应生成工厂
 * 
 * @author jp
 * @time 2017年11月8日 上午11:44:00
 */
public final class ResponseFactory {
	/**
	 * 无数据成功响应
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T> Response<T> creatSuccessResponse() {
		return new Response<T>().setResponseType(ExceptionType.SUCCESS);
	}

	/**
	 * 带数据成功响应
	 * 
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> Response<T> creatSuccessResponse(T data) {
		return new Response<T>().setData(data).setResponseType(ExceptionType.SUCCESS);
	}

	/**
	 * 系统错误响应
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param responseType
	 * @return
	 */
	public static <T> Response<T> creatErrorResponse() {
		return new Response<T>().setResponseType(ExceptionType.SERVER_EXCEPTION);
	}

	/**
	 * 系统错误响应
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param responseType
	 * @return
	 */
	public static <T> Response<T> creatErrorResponse(int code, String message) {
		return new Response<T>().setCode(code).setMsg(message);
	}

	/**
	 * 系统响应错误
	 * 
	 * @param exceptionType
	 * @return
	 */
	public static <T> Response<T> creatErrorResponse(ExceptionType exceptionType) {
		return new Response<T>().setResponseType(exceptionType);
	}
}
