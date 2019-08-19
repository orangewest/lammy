package com.peng.lammy.domain.dto.work;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class GaugingPoiDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Excel(name = "送样日期", width = 15, importFormat = "yyyy-MM-dd")
	private String gaugingDate;//
	@Excel(name = "送样人", width = 15)
	private String sendPerson;// 送样人
	@Excel(name = "样品名称", width = 20)
	private String sampleName;// 样品名称
	@Excel(name = "检测编号")
	private String gaugingNo;//
	@Excel(name = "SiO2")
	private String sio2;//
	@Excel(name = "Fe2O3")
	private String fe2o3;//
	@Excel(name = "Al2O3")
	private String al2o3;//
	@Excel(name = "CaO")
	private String cao;//
	@Excel(name = "MgO")
	private String mgo;//
	@Excel(name = "Cd")
	private String cd;//
	@Excel(name = "Pb")
	private String pb;//
	@Excel(name = "H2O")
	private String h2o;//
	@Excel(name = "XRD")
	private String xrd;//
	@Excel(name = "比表面")
	private String ssa;//
	@Excel(name = "pH")
	private String ph;//
	@Excel(name = "-2μm")
	private String minusTwoμm;// -2μm
	@Excel(name = "白度")
	private String whiteness;// 白度
	@Excel(name = "IL")
	private String il;//
	@Excel(name = "悬浮度/mL")
	private String suspensibility;// 悬浮度/mL
	@Excel(name = "胶质价ml/15g")
	private String adsorbed;// 胶质价ml/15g
	@Excel(name = "膨胀容ml/g")
	private String bentonites;// 膨胀容ml/g
	@Excel(name = "粘度")
	private String viscosity;// 粘度
	@Excel(name = "吸蓝量")
	private String methyleneBlue;// 吸蓝量
	@Excel(name = "吸油量g/100g")
	private String oilAbsorption;// 吸油量g/100g
	@Excel(name = "备注", width = 20)
	private String remark;//
}
