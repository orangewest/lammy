package com.peng.lammy.domain.po;

import lombok.Data;

/**
 * @Description 字典操作
 * @author jp
 * @time 2018年2月9日 下午3:48:22
 */
@Data
public class Dictionary {
	private Integer id;
	private String dictCode;
	private String dictName;
	private String dictType;
	private String createdTime;
	private String updateTime;
	private String isDelete;
}
