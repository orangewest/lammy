package com.peng.lammy.domain.dto.work;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Description 实验试剂实体
 * @author jp
 * @time 2018年2月9日 下午1:07:06
 */
@Data
public class ReagentPoiDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1229970024000365290L;
	@Excel(name = "试剂名称")
	private String reagentName;// 试剂名称
	@Excel(name = "规格")
	private String standard;// 规格
	@Excel(name = " 类型")
	private String type;// 类型
	@Excel(name = "库存数量")
	private Integer stock;// 库存数量
	@Excel(name = "库存单位")
	private String unit;// 库存单位
}
