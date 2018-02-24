package com.zhss.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.zhss.eshop.common.config.DruidDataSourceConfig;

/**
 * 系统启动类
 * @author zhonghuashishan
 *
 */
@SpringBootApplication
@EnableScheduling
@Import(DruidDataSourceConfig.class)
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
