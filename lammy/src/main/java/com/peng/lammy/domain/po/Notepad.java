package com.peng.lammy.domain.po;

import lombok.Data;

@Data
public class Notepad {
	private Integer id;// '主键'
	private String title;// '标题'
	private String content;// '内容'
	private int state;// 当前状态（0：未完成1:已完成）
	private String completeTime;// 完成时间
	private int isRemind;// '是否提醒'(0:否1:是)
	private String remindTime;// 提醒时间
	private String createdTime;
	private String updateTime;
	private String isDelete;
}
