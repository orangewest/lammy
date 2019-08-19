package com.peng.lammy.domain.dto.work;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Description 试剂库存记录
 * @author jp
 * @time 2018年2月9日 下午3:21:47
 */
@Data
public class ReagentStockPoiDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Excel(name = "试剂名称", width = 20)
	private String reagentName;
	@Excel(name = "操作类型", replace = { "入库_1", "出库_2" })
	private Integer operation;
	@Excel(name = "操作日期", width = 20)
	private String operationDate;
	@Excel(name = "操作数量")
	private Integer count;// 操作数量
	@Excel(name = "单位")
	private String unit;// 单位
	@Excel(name = "备注", width = 20)
	private String remark;// 备注
}
