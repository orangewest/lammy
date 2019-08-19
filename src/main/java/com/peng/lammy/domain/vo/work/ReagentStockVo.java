package com.peng.lammy.domain.vo.work;

import lombok.Data;

@Data
public class ReagentStockVo {
	private Integer id;
	private String reagentName;
	private Integer operation;
	private String operationDate;
	private Integer count;// 操作数量
	private String unit;// 单位
	private String remark;// 备注
}
