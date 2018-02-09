package com.peng.lammy.domain.po.work;

import lombok.Data;

/**
 * @Description 实验试剂实体
 * @author jp
 * @time 2018年2月9日 下午1:07:06
 */
@Data
public class Reagent {
	private Integer id;
	private String reagentName;// 试剂名称
	private String standard;// 规格
	private String type;// 类型
	private Integer stock;// 库存数量
	private String createdTime;
	private String updateTime;
	private String isDelete;
}
