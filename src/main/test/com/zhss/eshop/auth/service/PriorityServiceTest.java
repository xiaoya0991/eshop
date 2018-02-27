package com.zhss.eshop.auth.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.auth.constant.PriorityType;
import com.zhss.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 权限管理模块的service组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class PriorityServiceTest {

	/**
	 * 权限管理模块的service组件
	 */
	@Autowired
	private PriorityService priorityService;
	/**
	 * 权限管理模块的DAO组件
	 */
	@MockBean
	private PriorityDAO priorityDAO;
	/**
	 * 角色和权限关系管理模块的DAO组件
	 */
	@MockBean
	private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;
	/**
	 * 账号和权限关系管理模块的DAO组件
	 */
	@MockBean
	private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;
	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = dateFormatter.parse(dateFormatter.format(new Date()));  
		when(dateProvider.getCurrentTime()).thenReturn(currentTime);
	}
	
	/**
	 * 测试查询根权限
	 * @throws Exception
	 */
	@Test
	public void testListRootPriorities() throws Exception {
		Long parentId = null;
		List<PriorityDO> rootPriorityDOs = createMockPriorityDOs(parentId);
		when(priorityDAO.listRootPriorities()).thenReturn(rootPriorityDOs);
		Map<Long, PriorityDTO> rootPriorityDTOMap = convertPriorityDOs2Map(rootPriorityDOs);
		
		List<PriorityDTO> resultRootPriorityDTOs = priorityService.listRootPriorities();
		
		comparePriorityDTOs(rootPriorityDTOMap, resultRootPriorityDTOs);
	}
	
	/**
	 * 测试根据父权限id查询子权限
	 * @throws Exception
	 */
	@Test
	public void testListChildPriorities() throws Exception {
		Long parentId = 1L;
		List<PriorityDO> childPriorityDOs = createMockPriorityDOs(parentId);
		when(priorityDAO.listChildPriorities(parentId)).thenReturn(childPriorityDOs);
		Map<Long, PriorityDTO> childPriorityDTOMap = convertPriorityDOs2Map(childPriorityDOs);
		
		List<PriorityDTO> resultChildPriorityDTOs = priorityService
				.listChildPriorities(parentId);
		
		comparePriorityDTOs(childPriorityDTOMap, resultChildPriorityDTOs);
	}
	
	/**
	 * 测试根据id查询权限
	 * @throws Exception
	 */
	@Test
	public void testGetPriorityById() throws Exception {
		Long id = 2L;
		Long parentId = 1L;
		PriorityDO priorityDO = createMockPriorityDO(id, parentId);
		PriorityDTO priorityDTO = convertPriorityDO2DTO(priorityDO);
		
		when(priorityDAO.getPriorityById(id)).thenReturn(priorityDO);
		
		PriorityDTO resultPriorityDTO = priorityService.getPriorityById(id);
		
		assertEquals(priorityDTO, resultPriorityDTO); 
	}
	
	/**
	 * 测试新增权限
	 * @throws Exception
	 */
	@Test
	public void testSavePriority() throws Exception {
		Long id = 2L;
		Long parentId = 1L;
		PriorityDO priorityDO = createMockPriorityDO(id, parentId);
		PriorityDTO priorityDTO = convertPriorityDO2DTO(priorityDO);
		
		when(priorityDAO.savePriority(priorityDO)).thenReturn(id);
		
		priorityService.savePriority(priorityDTO);
		
		verify(priorityDAO, times(1)).savePriority(priorityDO);
	}
	
	/**
	 * 测试更新权限
	 * @throws Exception
	 */
	@Test
	public void testUpdatePriority() throws Exception {
		Long id = 2L;
		Long parentId = 1L;
		PriorityDO priorityDO = createMockPriorityDO(id, parentId);
		PriorityDTO priorityDTO = convertPriorityDO2DTO(priorityDO);
		
		when(priorityDAO.updatePriority(priorityDO)).thenReturn(true);
		
		priorityService.updatePriority(priorityDTO);
		
		verify(priorityDAO, times(1)).updatePriority(priorityDO);
	}
	
	/**
	 * 测试删除权限
	 * @throws Exception
	 */
	@Test
	public void testRemovePriority() throws Exception {
		// 完成所有DAO行为的mock
		Long id = 2L;
		Long parentId = 1L;
		PriorityDO priorityDO = createMockPriorityDO(id, parentId);
		when(priorityDAO.getPriorityById(id)).thenReturn(priorityDO);
		
		Long childId = 3L;
		PriorityDO childPriorityDO = createMockPriorityDO(childId, id);
		List<PriorityDO> childPriorityDOs = new ArrayList<PriorityDO>();
		childPriorityDOs.add(childPriorityDO);
		when(priorityDAO.listChildPriorities(id)).thenReturn(childPriorityDOs);
		when(priorityDAO.listChildPriorities(childId)).thenReturn(new ArrayList<PriorityDO>());  
		
		when(rolePriorityRelationshipDAO.countByPriorityId(childId)).thenReturn(0L); 
		when(accountPriorityRelationshipDAO.countByPriorityId(childId)).thenReturn(0L);
		
		when(rolePriorityRelationshipDAO.countByPriorityId(id)).thenReturn(0L); 
		when(accountPriorityRelationshipDAO.countByPriorityId(id)).thenReturn(0L);
		
		when(priorityDAO.removePriority(childId)).thenReturn(true);
		when(priorityDAO.removePriority(id)).thenReturn(true);
		
		// 实际执行service方法
		Boolean removePriorityResult = priorityService.removePriority(id);
		
		// 执行断言
		verify(priorityDAO, times(1)).getPriorityById(id);
		verify(priorityDAO, times(2)).listChildPriorities(id);
		verify(priorityDAO, times(2)).listChildPriorities(childId);
		verify(rolePriorityRelationshipDAO, times(1)).countByPriorityId(id);
		verify(rolePriorityRelationshipDAO, times(1)).countByPriorityId(childId);
		verify(accountPriorityRelationshipDAO, times(1)).countByPriorityId(id);
		verify(accountPriorityRelationshipDAO, times(1)).countByPriorityId(childId);
		verify(priorityDAO, times(1)).removePriority(id);
		verify(priorityDAO, times(1)).removePriority(childId); 
		
		assertTrue(removePriorityResult);
	}
	
	/**
	 * 构造模拟的权限DO集合
	 * @param parentId 父权限id
	 * @return 权限DO集合
	 * @throws Exception
	 */
	private List<PriorityDO> createMockPriorityDOs(Long parentId) throws Exception {
		Long id1 = 1L;
		Long id2 = 2L;
		
		List<PriorityDO> rootPriorityDOs = new ArrayList<PriorityDO>();
		rootPriorityDOs.add(createMockPriorityDO(id1, parentId));
		rootPriorityDOs.add(createMockPriorityDO(id2, parentId));
		
		return rootPriorityDOs;
	}
	
	/**
	 * 构造一个权限DO对象
	 * @return 权限DO对象
	 * @throws Exception
	 */
	private PriorityDO createMockPriorityDO(Long id, Long parentId) throws Exception {
		Random random = new Random();
		int randomInt = random.nextInt() * 100;
		
		PriorityDO priorityDO = new PriorityDO();
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
	 * 将权限DO集合转换为权限DTO集合
	 * @param priorityDOs 权限DO集合
	 * @return 权限DTO集合
	 */
	private Map<Long, PriorityDTO> convertPriorityDOs2Map(List<PriorityDO> priorityDOs) {
		Map<Long, PriorityDTO> priorityDTOMap = new HashMap<Long, PriorityDTO>(priorityDOs.size()); 
		for(PriorityDO priorityDO : priorityDOs) {
			priorityDTOMap.put(priorityDO.getId(), convertPriorityDO2DTO(priorityDO));  
		}
		return priorityDTOMap;
	}
	
	/**
	 * 比较两个权限DTO集合
	 * @param priorityDTOMap 权限DTO集合1
	 * @param priorityDTOs 权限DTO集合2
	 */
	private void comparePriorityDTOs(Map<Long, PriorityDTO> priorityDTOMap, 
			List<PriorityDTO> priorityDTOs) {
		assertEquals(priorityDTOMap.size(), priorityDTOs.size());
		
		for(PriorityDTO resultPriorityDTO : priorityDTOs) {
			PriorityDTO rootPrioiryDTO = priorityDTOMap.get(resultPriorityDTO.getId());
			assertEquals(rootPrioiryDTO, resultPriorityDTO); 
		}
	}
	
	/**
	 * 将权限DO对象转换为权限DTO对象
	 * @param priorityDO 权限DO对象
	 * @return 权限DTO对象
	 */
	private PriorityDTO convertPriorityDO2DTO(PriorityDO priorityDO) {
		PriorityDTO priorityDTO = new PriorityDTO();
		priorityDTO.setCode(priorityDO.getCode()); 
		priorityDTO.setGmtCreate(priorityDO.getGmtCreate()); 
		priorityDTO.setGmtModified(priorityDO.getGmtModified()); 
		priorityDTO.setId(priorityDO.getId()); 
		priorityDTO.setParentId(priorityDO.getParentId()); 
		priorityDTO.setPriorityComment(priorityDO.getPriorityComment()); 
		priorityDTO.setPriorityType(priorityDO.getPriorityType()); 
		priorityDTO.setUrl(priorityDO.getUrl());
		return priorityDTO;
	}
	
}
