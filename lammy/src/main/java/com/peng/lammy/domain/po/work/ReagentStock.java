package com.peng.lammy.domain.po.work;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 试剂库存记录
 * @author jp
 * @time 2018年2月9日 下午3:21:47
 */
@Data
@NoArgsConstructor
public class ReagentStock {
	private Integer id;
	private Integer reagent_id;// 试剂id
	private Integer operation;// 操作类型（1、入库2、出库）
	private String operationDate;// 操作时间
	private Integer count;// 操作数量
	private String remark;// 备注
	private String createdTime;
	private String updateTime;
	private Integer isDelete;

	public ReagentStock(Integer reagent_id, Integer operation, String operationDate, Integer count, String remark,
			String createdTime, String updateTime, Integer isDelete) {
		super();
		this.reagent_id = reagent_id;
		this.operation = operation;
		this.operationDate = operationDate;
		this.count = count;
		this.remark = remark;
		this.createdTime = createdTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
	}

}
