package com.peng.lammy.domain.po.work;

import lombok.Data;

/**
 * @Description 检测管理dao对象
 * @author jp
 * @time 2018年2月7日 上午11:11:27
 */
@Data
public class Gauging {
	private Integer id;// 主键
	private String sendPerson;// 送样人
	private String sampleName;// 样品名称
	private String gaugingNo;//
	private String gaugingDate;//
	private String remark;//
	private String SiO2;//
	private String Fe2O3;//
	private String Al2O3;//
	private String CaO;//
	private String MgO;//
	private String Cd;//
	private String Pb;//
	private String H2O;//
	private String XRD;//
	private String SSA;//
	private String pH;//
	private String minusTwoμm;// -2μm
	private String whiteness;// 白度
	private String IL;//
	private String suspensibility;// 悬浮度/mL
	private String adsorbed;// 胶质价ml/15g
	private String bentonites;// 膨胀容ml/g
	private String viscosity;// 粘度
	private String methyleneBlue;// 吸蓝量
	private String oilAbsorption;// 吸油量g/100g
	private String createdTime;
	private String updateTime;
	private String isDelete;

}
