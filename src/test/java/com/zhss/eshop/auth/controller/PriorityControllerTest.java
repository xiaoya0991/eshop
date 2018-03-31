package com.zhss.eshop.auth.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.auth.constant.PriorityType;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.domain.PriorityVO;
import com.zhss.eshop.auth.service.PriorityService;
import com.zhss.eshop.common.util.DateProvider;

import net.minidev.json.JSONArray;

/**
 * 权限管理模块的controller组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PriorityController.class)  
public class PriorityControllerTest {
	
	/**
	 * mvc测试模拟类
	 */
	@Autowired
	private MockMvc mvc;

	/**
	 * 权限管理模块的service组件
	 */
	@MockBean
	private PriorityService priorityService;
	
	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	
	/**
	 * 初始化方法
	 */
	@Before
	public void setup() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = dateFormatter.parse(dateFormatter.format(new Date()));  
		when(dateProvider.getCurrentTime()).thenReturn(currentTime);
		when(dateProvider.formatDatetime(currentTime)).thenReturn(dateFormatter.format(currentTime));
		when(dateProvider.parseDatetime(dateFormatter.format(currentTime))).thenReturn(currentTime);
	}
	
	/**
	 * 测试查询根权限
	 * @throws Exception
	 */
	@Test
	public void testListRootPriorities() throws Exception {
		Long parentId = null;
		List<PriorityDTO> rootPriorityDTOs = createMockPriorityDTOs(parentId);
		when(priorityService.listRootPriorities()).thenReturn(rootPriorityDTOs);
		List<PriorityVO> rootPriorityVOs = convertPriorityDTOs2VOs(rootPriorityDTOs);
		
		mvc.perform(get("/auth/priority/root"))
			.andExpect(content().json(JSONArray.toJSONString(rootPriorityVOs))); 
	}
	
	/**
	 * 测试根据父权限id查询子权限
	 * @throws Exception
	 */
	@Test
	public void testListChildPriorities() throws Exception {
		Long parentId = 1L;
		List<PriorityDTO> childPriorityDTOs = createMockPriorityDTOs(parentId);
		when(priorityService.listChildPriorities(parentId)).thenReturn(childPriorityDTOs);
		List<PriorityVO> rootPriorityVOs = convertPriorityDTOs2VOs(childPriorityDTOs);
		
		mvc.perform(get("/auth/priority/child/{parentId}", parentId)) 
				.andExpect(content().json(JSONArray.toJSONString(rootPriorityVOs))); 
	}
	
	/**
	 * 测试根据id查询权限
	 * @throws Exception
	 */
	@Test
	public void testGetPriorityById() throws Exception {
		Long id = 2L;
		Long parentId = 1L;
		PriorityDTO priorityDTO = createMockPriorityDTO(id, parentId);
		PriorityVO priorityVO = convertPriorityDTO2VO(priorityDTO);
		
		when(priorityService.getPriorityById(id)).thenReturn(priorityDTO);
		
		mvc.perform(get("/auth/priority/{id}", id)) 
				.andExpect(content().json(JSONObject.toJSONString(priorityVO))); 
	}
	
	/**
	 * 测试新增权限
	 * @throws Exception
	 */
	@Test
	public void testSavePriority() throws Exception {
		Long id = 2L;
		Long parentId = 1L;
		PriorityDTO priorityDTO = createMockPriorityDTO(id, parentId);
		PriorityVO priorityVO = convertPriorityDTO2VO(priorityDTO);
		
		mvc.perform(post("/auth/priority/").contentType("application/json").content(JSONObject.toJSONString(priorityVO)))  
				.andExpect(content().string("true"));  
	}
	
	/**
	 * 测试修改权限
	 * @throws Exception
	 */
	@Test
	public void testUpdatePriority() throws Exception {
		Long id = 2L;
		Long parentId = 1L;
		PriorityDTO priorityDTO = createMockPriorityDTO(id, parentId);
		PriorityVO priorityVO = convertPriorityDTO2VO(priorityDTO);
		
		mvc.perform(put("/auth/priority/{id}", id).contentType("application/json").content(JSONObject.toJSONString(priorityVO)))  
				.andExpect(content().string("true"));   
	}
	
	/**
	 * 测试删除权限
	 * @throws Exception
	 */
	@Test
	public void testRemovePriority() throws Exception {
		Long id = 2L;
		
		when(priorityService.removePriority(id)).thenReturn(true); 
		
		mvc.perform(delete("/auth/priority/{id}", id))  
				.andExpect(content().string("true"));   
	}
	
	/**
	 * 构造模拟的权限DO集合
	 * @param parentId 父权限id
	 * @return 权限DO集合
	 * @throws Exception
	 */
	private List<PriorityDTO> createMockPriorityDTOs(Long parentId) throws Exception {
		Long id1 = 1L;
		Long id2 = 2L;
		
		List<PriorityDTO> rootPriorityDTOs = new ArrayList<PriorityDTO>();
		rootPriorityDTOs.add(createMockPriorityDTO(id1, parentId));
		rootPriorityDTOs.add(createMockPriorityDTO(id2, parentId));
		
		return rootPriorityDTOs;
	}
	
	/**
	 * 构造一个权限DO对象
	 * @return 权限DO对象
	 * @throws Exception
	 */
	private PriorityDTO createMockPriorityDTO(Long id, Long parentId) throws Exception {
		Random random = new Random();
		int randomInt = random.nextInt() * 100;
		
		PriorityDTO priorityDO = new PriorityDTO();
		priorityDO.setId(id); 
		priorityDO.setCode("TEST_" + randomInt);  
		priorityDO.setGmtCreate(dateProvider.getCurrentTime()); 
		priorityDO.setGmtModified(dateProvider.getCurrentTime()); 
		priorityDO.setParentId(parentId); 
		priorityDO.setPriorityComment("TEST_" + randomInt);
		priorityDO.setPriorityType(PriorityType.MENU);
		priorityDO.setUrl("http://127.0.0.1/" + randomInt);  
		
		return priorityDO;
	}
	
	/**
	 * 将权限DO对象转换为权限DTO对象
	 * @param priorityDO 权限DO对象
	 * @return 权限DTO对象
	 */
	private PriorityVO convertPriorityDTO2VO(PriorityDTO priorityDTO) throws Exception {
		PriorityVO priorityVO = new PriorityVO();
		priorityVO.setCode(priorityDTO.getCode()); 
		priorityVO.setGmtCreate(dateProvider.formatDatetime(priorityDTO.getGmtCreate()));   
		priorityVO.setGmtModified(dateProvider.formatDatetime(priorityDTO.getGmtModified()));  
		priorityVO.setId(priorityDTO.getId()); 
		priorityVO.setParentId(priorityDTO.getParentId()); 
		priorityVO.setPriorityComment(priorityDTO.getPriorityComment()); 
		priorityVO.setPriorityType(priorityDTO.getPriorityType()); 
		priorityVO.setUrl(priorityDTO.getUrl());
		return priorityVO;
	}
	
	/**
	 * 将权限DO集合转换为权限DTO集合
	 * @param priorityDOs 权限DO集合
	 * @return 权限DTO集合
	 */
	private List<PriorityVO> convertPriorityDTOs2VOs(
			List<PriorityDTO> priorityDTOs) throws Exception {
		List<PriorityVO> priorityVOs = new ArrayList<PriorityVO>(priorityDTOs.size()); 
		for(PriorityDTO priorityDTO : priorityDTOs) {
			priorityVOs.add(convertPriorityDTO2VO(priorityDTO));  
		}
		return priorityVOs;
	}
	
}
