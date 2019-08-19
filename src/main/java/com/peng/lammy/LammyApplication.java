package com.peng.lammy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.peng.lammy.dao")
public class LammyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LammyApplication.class, args);
	}

}
