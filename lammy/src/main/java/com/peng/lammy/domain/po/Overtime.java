package com.peng.lammy.domain.po;

import lombok.Data;

@Data
public class Overtime {
	private Integer id;
	private Integer userId;
	private String overtimeDate;// 加班日期
	private String startTime;// 加班开始时间
	private String endTime;// 加班结束时间
	private String timeLength;// 加班时间
	private String remark;// 加班说明
}
