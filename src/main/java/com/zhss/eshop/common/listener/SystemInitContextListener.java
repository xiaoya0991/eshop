package com.zhss.eshop.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhss.eshop.common.bean.SpringApplicationContext;
import com.zhss.eshop.schedule.stock.ScheduleStockUpdateMessageConsumer;

/**
 * 系统初始化监听器
 * @author zhonghuashishan
 *
 */
@WebListener
public class SystemInitContextListener implements ServletContextListener {
	
	private static final Logger logger = LoggerFactory.getLogger(SystemInitContextListener.class);
	
	/**
	 * spring容器
	 */
	@Autowired
	private SpringApplicationContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("【系统启动】系统已经完成系统。。。。。。");   
		
		ScheduleStockUpdateMessageConsumer stockUpdateMessageConsumer = 
				context.getBean(ScheduleStockUpdateMessageConsumer.class);
		stockUpdateMessageConsumer.start();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
  
}