package com.zhss.eshop.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 系统初始化监听器
 * @author zhonghuashishan
 *
 */
@WebListener
public class SystemInitContextListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("系统启动了。。。。。。。。");   
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		
	}
  
}