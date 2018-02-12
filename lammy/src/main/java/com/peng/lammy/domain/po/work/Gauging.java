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
	private Integer gaugingNoOrder;//
	private String gaugingDate;//
	private String remark;//
	private String sio2;//
	private String fe2o3;//
	private String al2o3;//
	private String cao;//
	private String mgo;//
	private String cd;//
	private String pb;//
	private String h2o;//
	private String xrd;//
	private String ssa;//
	private String ph;//
	private String minusTwoμm;// -2μm
	private String whiteness;// 白度
	private String il;//
	private String suspensibility;// 悬浮度/mL
	private String adsorbed;// 胶质价ml/15g
	private String bentonites;// 膨胀容ml/g
	private String viscosity;// 粘度
	private String methyleneBlue;// 吸蓝量
	private String oilAbsorption;// 吸油量g/100g
	private String createdTime;
	private String updateTime;
	private Integer isDelete;

}
