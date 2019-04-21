package com.imec.central.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class PropertiesUtils  {
	/**
	 * 获取配置文件信息
	 * @param porpName 属性名称
	 * @param fileName 文件名
	 * @return 
	 */
	public static String getPropertiesValue(String porpName,String fileName){
		try {
			Properties p = getPropertiesByPath(fileName);
			String propValue = p.getProperty(porpName);
			return propValue;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获取包含的配置信息
	 * @param porpName 包含的属性名称
	 * @param fileName 配置文件名称
	 * @return
	 */
	public static Map<String,String> getContainsPropertiesMap(String porpName,String fileName){
		try {
			Properties p = getPropertiesByPath(fileName);
			Set<String> propertyNames = p.stringPropertyNames();

			Map<String,String> propertiesMap = new HashMap<String, String>();
			for(String propertyName : propertyNames){
				if(propertyName.contains(porpName)){
					propertiesMap.put(propertyName,p.getProperty(propertyName));
				}
			}
			return propertiesMap;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取配置对象
	 * @param fileName 配置文件名称
	 * @return
	 * @throws IOException
	 */
	public static Properties getPropertiesByPath(String fileName) throws IOException {
		Properties p = new Properties();

		String url = PropertiesUtils.class.getResource("/").getPath()+
				java.io.File.separator + fileName+".properties";
		p.load(new FileInputStream(url));
		return p;
	}
}
