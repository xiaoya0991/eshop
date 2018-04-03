package com.zhss.eshop.common.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件工具类
 * 
 * 适配器模式，常用于两种场景：
 * 
 * 1、就是你做了一个系统，这个系统有第一个版本的接口，但是你后面系统设计第二个版本的时候，很多接口都改变了。
 * 
 * 跟旧版本的接口进行兼容，就是说你现在的业务代码需要面向新版本的接口去编程，但是无奈很多代码都是基于旧版本去
 * 封装的。此时你就只能做一个新旧版本之间的适配器，这个适配器实现新接口，但是组合了老接口的实现类
 * 然后所有新接口的实现，都是基于老接口的实现类去完成的，那么这个适配器，就可以给我们提供新接口，同时他还
 * 基于老接口完成了大部分代码的实现，不用全部重新写了
 * 
 * 2、你手上有一份第三方的api，但是你自己的系统，需要根据你自己的编程规范，定义一套实用第三方api功能的接口
 * 
 * 这套接口跟第三方api接口是不一样的，做一个适配器，适配器就是实现了你自己定义的接口，但是组合了第三方api接口的
 * 实现类，你的系统中的业务代码，都是面向你自己定义的接口去编程的，但是你的适配器是基于第三方api去实现功能的
 * 
 * 第三方api和本地接口进行适配
 * 
 * 就是将jdk提供的文件操作的api，适配成我们的系统需要的这么一套接口
 * 
 * @author zhonghuashishan
 *
 */
public class FileUtils {

	/**
	 * 根据相对路径获取一个绝对路径
	 * @param relativePath 相对路径
	 * @return 绝对路径
	 * @throws Exception
	 */
	public static String getPathByRelative(String relativePath) throws Exception {
		File appBaseDir = new File(ResourceUtils.getURL("classpath:").getPath());
		if(!appBaseDir.exists()) {
			appBaseDir = new File(""); 
		}
		
		File targetDir = new File(appBaseDir.getAbsolutePath(), relativePath); 
		if(!targetDir.exists()) {
			targetDir.mkdirs();
		}
		
		return targetDir.getAbsolutePath();
	}
	
	/**
	 * 上传一个文件
	 * @param file 文件
	 * @param uploadDirPath 上传目录的路径
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(MultipartFile file, 
			String uploadDirPath) throws Exception {
		File uploadDir = new File(uploadDirPath);
	    if(!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }
	     
	    String pathSeparator = System.getProperties().getProperty("file.separator");
	    String originalFilename = file.getOriginalFilename();
	    String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);  
	    String filename = UUID.randomUUID().toString().replace("-", "") + "." + suffix;  
	    String targetFilePath = uploadDirPath + pathSeparator + filename;
	    
	    File targetFile = new File(targetFilePath);
	    file.transferTo(targetFile);  
	    
	    return targetFile.getAbsolutePath();
	}
	
	/**
	 * 删除文件
	 * @param filePath 文件路径
	 * @return 文件
	 * @throws Exception
	 */
	public static Boolean deleteFile(String filePath) throws Exception {
		File file = new File(filePath);
		return file.delete();
	}
	
}

