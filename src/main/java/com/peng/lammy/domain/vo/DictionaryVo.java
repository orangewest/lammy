package com.peng.lammy.domain.vo;

import lombok.Data;

@Data
public class DictionaryVo {
	private Integer id;
	private String dictCode;
	private String dictName;
	private String dictType;
	private String typeName;
	private Integer dictAuth;
}
