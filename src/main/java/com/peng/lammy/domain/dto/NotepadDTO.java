package com.peng.lammy.domain.dto;

import lombok.Data;

@Data
public class NotepadDTO {
	private Integer id;// '主键'
	private Integer userId;
	private String title;// '标题'
	private String content;// '内容'
	private Integer state;// 当前状态（0：未完成1:已完成）
	private String completeTime;// 完成时间
	private int isRemind;// '是否提醒'(0:否1:是)
	private String remindTime;// 提醒时间
	private Integer page;
	private Integer limit;
}
