package com.peng.lammy.base.interceptor;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "lammy.interceptor")
@Data
public class FilterUrlsPropertiesConifg {
	private List<String> urls;
}
