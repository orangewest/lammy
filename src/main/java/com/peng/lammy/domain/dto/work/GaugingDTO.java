package com.peng.lammy.domain.dto.work;

import lombok.Data;

@Data
public class GaugingDTO {
	private String sendPerson;// 送样人
	private String sampleName;// 样品名称
	private String gaugingNo;//
	private String gaugingDate;//
	private String year;//
	private String month;//
	private int page;
	private int limit;
}
