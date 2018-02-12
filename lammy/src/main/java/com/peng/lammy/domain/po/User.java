package com.peng.lammy.domain.po;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private String createdTime;
	private String updateTime;
	private Integer isDelete;
}
