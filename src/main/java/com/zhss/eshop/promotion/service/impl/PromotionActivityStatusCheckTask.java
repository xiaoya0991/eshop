package com.zhss.eshop.promotion.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.promotion.constant.PromotionActivityStatus;
import com.zhss.eshop.promotion.dao.PromotionActivityDAO;
import com.zhss.eshop.promotion.domain.PromotionActivityDO;

/**
 * 促销活动状态检查任务
 * @author zhonghuashishan
 *
 */
@Component
public class PromotionActivityStatusCheckTask {
	
	private static final Logger logger = LoggerFactory.getLogger(
			PromotionActivityStatusCheckTask.class);

	/**
	 * 促销活动管理DAO组件
	 */
	@Autowired
	private PromotionActivityDAO promotionActivityDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 执行业务逻辑
	 */
    @Scheduled(fixedRate = 1 * 60 * 1000)
    public void execute() {
    	try {
    		List<PromotionActivityDO> activities = promotionActivityDAO.listAll();
        	
        	for(PromotionActivityDO activity : activities) {
        		if(PromotionActivityStatus.DISABLED.equals(activity.getStatus())) {
        			tryEnableActivity(activity); 
        		} else if(PromotionActivityStatus.ENABLED.equals(activity.getStatus())) {
        			tryDisableActivity(activity); 
        		}
        	}
		} catch (Exception e) {
			logger.error("error", e); 
		}
    }
    
    /**
     * 尝试启用促销活动
     * @param activity 促销活动
     * @throws Exception
     */
    private void tryEnableActivity(PromotionActivityDO activity) throws Exception {
    	Date currentTime = dateProvider.getCurrentTime();
    	if(currentTime.after(activity.getStartTime())) {  
    		promotionActivityDAO.updateStatus(activity.getId(), 
    				PromotionActivityStatus.ENABLED);  
    	}
    }
    
    /**
     * 尝试禁用促销活动
     * @param activity 促销活动
     * @throws Exception
     */
    private void tryDisableActivity(PromotionActivityDO activity) throws Exception {
    	Date currentTime = dateProvider.getCurrentTime();
    	if(currentTime.after(activity.getEndTime())) {   
    		promotionActivityDAO.updateStatus(activity.getId(), 
    				PromotionActivityStatus.DISABLED);  
    	}
    }

}