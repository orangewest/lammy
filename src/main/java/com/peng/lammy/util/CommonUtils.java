package com.peng.lammy.util;

import com.xiaoleilu.hutool.util.StrUtil;

/**
 * 通用工具类
 * 
 * @author Administrator
 *
 */
public final class CommonUtils {
	/**
	 * 给字符串前后增加%
	 * 
	 * @param str
	 * @return
	 */
	public static String addPercent(String str) {
		if (StrUtil.isBlank(str)) {
			return str;
		}
		return "%" + str + "%";
	}
}
