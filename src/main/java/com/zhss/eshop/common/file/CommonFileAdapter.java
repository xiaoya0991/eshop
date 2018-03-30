package com.zhss.eshop.common.file;

import java.io.File;

/**
 * 文件
 * @author zhonghuashishan
 *
 */
public class CommonFileAdapter implements CommonFile {

	private File file;
	
	public CommonFileAdapter(String path) {
		this.file = new File(path); 
	}
	
	/**
	 * 判断文件是否存在
	 * @return 是否存在
	 * @throws Exception
	 */
	@Override
	public Boolean exists() throws Exception {
		return file.exists();
	}
	
	/**
	 * 递归创建所有子目录
	 * @return 处理结果
	 * @throws Exception
	 */
	@Override
	public Boolean createDirectories() throws Exception {
		return file.mkdirs();
	}
	
	/**
	 * 获取文件的绝对路径 
	 * @return 绝对路径
	 * @throws Exception
	 */
	@Override
	public String getAbsolutePath() throws Exception {
		return file.getAbsolutePath();
	}
	
	/**
	 * 获取文件名
	 * @param file 文件 
	 * @return 文件名
	 * @throws Exception
	 */
	@Override
	public String getFilename() throws Exception {
		return file.getName();
	}
	
	/**
	 * 删除文件
	 * @return 处理结果
	 * @throws Exception
	 */
	@Override
	public Boolean remove() throws Exception {
		return file.delete();
	}

	/**
	 * 获取文件路径
	 */
	@Override
	public String getPath() throws Exception {
		return file.getPath();
	}
	
}
