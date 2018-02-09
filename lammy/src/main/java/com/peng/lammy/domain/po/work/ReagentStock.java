package com.peng.lammy.domain.po.work;

import lombok.Data;

/**
 * @Description 试剂库存记录
 * @author jp
 * @time 2018年2月9日 下午3:21:47
 */
@Data
public class ReagentStock {
	private Integer id;
	private Integer reagent_id;// 试剂id
	private Integer operation;// 操作类型（1、入库2、出库）
	private String operationDate;// 操作时间
	private Integer count;// 操作数量
	private String unit;// 单位
	private String remark;// 备注
	private String createdTime;
	private String updateTime;
	private String isDelete;
}
